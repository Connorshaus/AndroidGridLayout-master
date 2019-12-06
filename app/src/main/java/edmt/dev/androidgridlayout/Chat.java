package edmt.dev.androidgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Chat extends AppCompatActivity {

    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        myRef = database.getReference("message");

        final TextView myText = findViewById(R.id.Text);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //myText.setText(dataSnapshot.getValue().toString());
                String[] Messages = dataSnapshot.getValue().toString().split(",");
                myText.setText("");

                //String[] firstMessage = Messages[0].split("=");
                //myText.append(firstMessage[2] + "\n");

                for(int i = 0; i < Messages.length; i++)
                {
                    int len = Messages.length - 1;
                    String[] finalMessage = Messages[i].split("=");
                    if(i == len){
                        String last = finalMessage[1];
                        String lastMessage = last.substring(0,last.length() - 2);
                        myText.append(lastMessage + "\n");
                    }else {
                        if (finalMessage.length == 2) {
                            myText.append(finalMessage[1] + "\n");
                        }
                        if (finalMessage.length == 3) {
                            myText.append(finalMessage[2] + "\n");
                        }

                    }
                    //myText.append(finalMessage[1] + "\n");
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                myText.setText("CANCELLED");
            }
        });

    }



    public void sendMessage(View view){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        EditText newText = findViewById(R.id.editText);
        myRef.child(user.getUid()).push().setValue(newText.getText().toString());
        newText.setText("");

    }

}
