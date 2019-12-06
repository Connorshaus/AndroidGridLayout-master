package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.renderscript.Element;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.lang.Math.E;

public class AboutUs extends AppCompatActivity {

    Button mResourcesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        mResourcesBtn = findViewById(R.id.resourcces);

        mResourcesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(getApplicationContext(), resources.class));
            }
        });

    }
}
