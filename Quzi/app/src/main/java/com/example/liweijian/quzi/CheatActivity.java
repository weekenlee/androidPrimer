package com.example.liweijian.quzi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;
    private Boolean mAnsweristrue;

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.liweijian.quzi.answeristrue";
    private static final String EXTRA_ANSWER_SHOW = "com.example.liweijian.quzi.answershow";

    public static Intent newIntent(Context packageContext, boolean answerIsTrue)
    {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShow(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOW, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnsweristrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_textview);
        mShowAnswerButton = (Button) findViewById(R.id.showanswer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerTextView.setText(mAnsweristrue?"true":"false");
                setAnswerShowResult(true);
            }
        });
    }

    private void setAnswerShowResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
