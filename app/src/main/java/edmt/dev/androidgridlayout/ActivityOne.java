package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ActivityOne extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();

    String name = user.getDisplayName();
    String email = user.getEmail();
    String phone_number = user.getPhoneNumber();

    TextView textView3, textView9, textView11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setText(name);

        textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setText(email);

        textView11 = (TextView)findViewById(R.id.textView11);
        textView11.setText(phone_number);
    }


    public void logout (View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}
