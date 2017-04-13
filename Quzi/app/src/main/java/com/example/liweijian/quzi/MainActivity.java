package com.example.liweijian.quzi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

class Debug {
    public static int line(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        if (trace == null || trace.length == 0)
            return -1; //
        return trace[0].getLineNumber();
    }
    public static String fun(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        if (trace == null)
            return ""; //
        return trace[0].getMethodName();
    }
}

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "com.example.liweijian.quzi.index";
    private static final int REQUEST_CODE_CHEAT = 0;

    private Button mTrueButton;
    private Button mFlaseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionView;
    private Button mCheatButton;
    private Boolean mWasCheat = false;

    private Question[] mQuestions = new Question[] {
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, true)
    };

    private  int mCurrentIndex = 0;


    void test() {
        int i = -1%3;
        int i2 = 1%3;
        int i4 = 0%3;
        int i5 = 2%3;
        int i6 = 3%3;

    }


    void checkAnswer(boolean check) {

        if (mWasCheat) {
            Toast.makeText(MainActivity.this,
                    R.string.wasCheat,
                    LENGTH_SHORT).show();
        }
        else if (mQuestions[mCurrentIndex].ismAnswerTrue() == check) {
            Toast.makeText(MainActivity.this,
                    R.string.correct_toast,
                    LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,
                    R.string.incorrect_toast,
                    LENGTH_SHORT).show();
        }
    }


    void updateQuestion() {
        int question = mQuestions[mCurrentIndex].getmTextResId();
        mQuestionView.setText(question);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("quzi", Debug.fun(new Exception()));
        mQuestionView = (TextView) findViewById(R.id.question_view);

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = CheatActivity.newIntent(MainActivity.this, mQuestions[mCurrentIndex].ismAnswerTrue());
                //startActivity();
                startActivityForResult(i, REQUEST_CODE_CHEAT);
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFlaseButton = (Button) findViewById(R.id.false_button);
        mFlaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mCurrentIndex == 0) {
                    mCurrentIndex = 2;
                } else
                {
                    mCurrentIndex = (mCurrentIndex-1) % mQuestions.length;
                }
                updateQuestion();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mQuestionView = (TextView) findViewById(R.id.question_view);
                mCurrentIndex = (mCurrentIndex+1) % mQuestions.length;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("quzi", Debug.fun(new Exception()));
        outState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data != null) {
                mWasCheat = CheatActivity.wasAnswerShow(data);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("quzi", Debug.fun(new Exception()));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
