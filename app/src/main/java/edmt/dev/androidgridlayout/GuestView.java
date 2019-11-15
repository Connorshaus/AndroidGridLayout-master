package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class GuestView extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_view);

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
                    if(finalI == 0) // Activate My Register
                    {
                        Intent intent = new Intent (GuestView.this, Register.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1) // Activate Motivation
                    {
                        Intent intent = new Intent (GuestView.this, MotivationHome.class);
                        startActivity(intent);
                    }
                    else if(finalI == 2) // Activate About Us
                    {
                        Intent intent = new Intent (GuestView.this, AboutUs.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
