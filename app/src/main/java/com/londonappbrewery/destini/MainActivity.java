package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:


    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryTextView;
    int mIndex;
    int mNewQuestion;
    int mNewTopText;
    int mNewBottomText;

    private NextQuestion[] mQuestionsNext = new NextQuestion[]{
            new NextQuestion(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new NextQuestion(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new NextQuestion(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new NextQuestion(R.string.T4_End),
            new NextQuestion(R.string.T5_End),
            new NextQuestion(R.string.T6_End)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mIndex){
                    case 0: mIndex = 2;
                        break;
                    case 1: mIndex = 2;
                        break;
                    case 2: mIndex = 5;
                        break;
                    default:
                        mIndex = 0;
                        break;
                }
                updateQuestionAndChoice();
            }

        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mIndex){
                    case 0: mIndex = 1;
                        break;
                    case 1: mIndex = 3;
                        break;
                    case 2: mIndex = 4;
                        break;
                    default:
                        mIndex = 0;
                        break;
                }
                updateQuestionAndChoice();
            }
        });


    }

    private void updateQuestionAndChoice() {
        mNewQuestion = mQuestionsNext[mIndex].getQuestionID();
        mNewTopText = mQuestionsNext[mIndex].getTopAnswer();
        mNewBottomText = mQuestionsNext[mIndex].getBottomAnswer();
        mStoryTextView.setText(mNewQuestion);
        if (mIndex <= 2){
                mButtonTop.setText(mNewTopText);
                mButtonBottom.setText(mNewBottomText);
        }

    }
}
