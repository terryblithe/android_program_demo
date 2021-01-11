package com.tb.demo.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.icu.util.VersionInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.tb.demo.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.tb.demo.geoquiz.answer_shown";
    private static final String ANSWER_SHOWN = "answer_shown";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    private TextView mShowSdkVersionTextView;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            mAnswerIsTrue = savedInstanceState.getBoolean(EXTRA_ANSWER_IS_TRUE);
            setAnswerShownResult(true);
        } else {
            mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        }

        mAnswerTextView = findViewById(R.id.answer_text_view);

        mShowAnswerButton = findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

        mShowSdkVersionTextView = findViewById(R.id.show_sdk_version_text_view);
        int sdkInt = Build.VERSION.SDK_INT;
        mShowSdkVersionTextView.setText("API level " + sdkInt);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(EXTRA_ANSWER_IS_TRUE, mAnswerIsTrue);
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}