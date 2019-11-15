package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MotivationHome extends AppCompatActivity {

    Button mQuoteBtn, mPicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_home);

        mQuoteBtn   = findViewById(R.id.quotes);
        mPicBtn    = findViewById(R.id.pics);

        mQuoteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(getApplicationContext(), quotes.class));
            }
        });

        mPicBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(getApplicationContext(), Motivation.class));
            }
        });
    }


}
