package com.tb.demo.geoquiz;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public Question setTextResId(int textResId) {
        mTextResId = textResId;
        return this;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public Question setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
        return this;
    }
}
