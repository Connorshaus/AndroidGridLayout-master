package edmt.dev.androidgridlayout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyHealth extends AppCompatActivity {
    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series;
    private List<Integer> td;
    private int lastX = 0;
    int numOfQuizesTaken = 10;
    int maxScore = 60;
    int minScore = 0;
    int minNumOfQuizesTaken = 1;
    int scores = 0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_health);
        // we get graph view instance
        final GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Quiz Attempt");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Quiz Score");
        graph.setTitle("Questionnaire Statistics");
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(currentFirebaseUser.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            int numOfScores;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                numOfScores = (int) dataSnapshot.getChildrenCount() - 1;
                td = new ArrayList<>();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    String num = postSnapshot.getValue().toString();
                    td.add(Integer.parseInt(num));
                }
                for(int i = 0; i < td.size(); i++)
                {
                    Log.d("array element " + i, "" + td.get(i) );
                }
                series = new LineGraphSeries<DataPoint>();
                for(int i = 0; i < td.size(); i++)
                {
                    series.appendData(new DataPoint(i + 1, td.get(i)), false, 20);
                }
                graph.addSeries(series);
                Viewport viewport = graph.getViewport();
                viewport.setYAxisBoundsManual(true);
                viewport.setXAxisBoundsManual(true);
                viewport.setMinY(minScore);
                viewport.setMaxY(maxScore);
                viewport.setMinX(1);
                viewport.setMaxX(td.size() + 2);
                viewport.setScalable(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
