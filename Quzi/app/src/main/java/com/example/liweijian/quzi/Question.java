package com.example.liweijian.quzi;

/**
 * Created by liweijian on 2017/4/13.
 */

public class Question {
    private int mTextResId;

    public Question(int mTextResId, boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    private boolean mAnswerTrue;

    public int getmTextResId() {
        return mTextResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmTextResId(int mTextResId) {

        this.mTextResId = mTextResId;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
