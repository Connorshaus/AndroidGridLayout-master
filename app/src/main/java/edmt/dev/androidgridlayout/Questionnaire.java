package edmt.dev.androidgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Questionnaire extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;
    private Button mButtonExit;

    private int mScore = 0;
    private int mQuestionNumber = 0;

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        mButtonChoice5 = (Button)findViewById(R.id.choice5);
        mButtonExit = (Button)findViewById(R.id.quit);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("questionnaire score");

        updateQuestion();

        //Button1 Listener
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = mScore + 1;
                updateScore(mScore);
                if (mQuestionNumber == 10){myRef.setValue(mScore);}
                updateQuestion();
            }
        });
        //End of Button1

        //Button2 Listener
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = mScore + 2;
                updateScore(mScore);
                if (mQuestionNumber == 10){myRef.setValue(mScore);}
                updateQuestion();
            }
        });
        //End of Button2

        //Button3 Listener
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = mScore + 3;
                updateScore(mScore);
                if (mQuestionNumber == 10){myRef.setValue(mScore);}
                updateQuestion();
            }
        });
        //End of Button3

        //Button4 Listener
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = mScore + 4;
                updateScore(mScore);
                if (mQuestionNumber == 10){myRef.setValue(mScore);}
                updateQuestion();
            }
        });
        //End of Button4

        //Button5 Listener
        mButtonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScore = mScore + 5;
                updateScore(mScore);
                if (mQuestionNumber == 10){myRef.setValue(mScore);}
                updateQuestion();
            }
        });
        //End of Button5

        //Button Exit Listener
        mButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        //End of Button Exit


    };

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        mButtonChoice5.setText(mQuestionLibrary.getChoice5(mQuestionNumber));

        mQuestionNumber++;
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }

    private void updateFire(){
        myRef.push().setValue(mScore);
    }

}

//databaseReference.child("users").push().setValue(userInformation)
//myRef.child(questionnaire score").push().setValue(mScore);
