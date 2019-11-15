package edmt.dev.androidgridlayout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Random;

public class MyHealth extends AppCompatActivity {
    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series;
    private int lastX = 0;
    int numOfQuizesTaken = 10;
    int maxScore = 10;
    int minScore = 0;
    int minNumOfQuizesTaken = 0;
    int scores = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_health);
        // we get graph view instance
        GraphView graph = (GraphView) findViewById(R.id.graph);
        // data
        series = new LineGraphSeries<DataPoint>();
        for(int i = minNumOfQuizesTaken; i <= numOfQuizesTaken; i++)
        {
            series.appendData(new DataPoint(i,i), false, 20);
        }
        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setXAxisBoundsManual(true);
        viewport.setMinY(minScore);
        viewport.setMaxY(maxScore);
        viewport.setMinX(minNumOfQuizesTaken);
        viewport.setMaxX(numOfQuizesTaken);
        viewport.setScrollable(false);
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(currentFirebaseUser.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            int numOfScores;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                numOfScores = (int) dataSnapshot.getChildrenCount() - 1;
                if(dataSnapshot.exists())
                {
                    myRef.child("numOfScores").setValue(numOfScores);
                }
                else
                {
                    myRef.child("numOfScores").setValue(1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
