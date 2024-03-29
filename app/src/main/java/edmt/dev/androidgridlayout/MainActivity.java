package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 0) // Activate My Profile
                    {
                        Intent intent = new Intent (MainActivity.this, ActivityOne.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1) // Activate Questionnaire
                    {
                        Intent intent = new Intent (MainActivity.this, Questionnaire.class);
                        startActivity(intent);
                    }
                    else if(finalI == 2) // Activate My Health
                    {
                        Intent intent = new Intent (MainActivity.this, MyHealth.class);
                        startActivity(intent);
                    }
                    else if(finalI == 3) // Activate Motivation
                    {
                        Intent intent = new Intent (MainActivity.this, MotivationHome.class);
                        startActivity(intent);
                    }
                    else if(finalI == 4) // Activate Chat
                    {
                        Intent intent = new Intent (MainActivity.this, Chat.class);
                        startActivity(intent);
                    }
                    else if(finalI == 5) // Activate About Us
                    {
                        Intent intent = new Intent (MainActivity.this, AboutUs.class);
                        startActivity(intent);
                    }


                }
            });
        }
    }
}
