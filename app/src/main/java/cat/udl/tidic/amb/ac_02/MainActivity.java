package cat.udl.tidic.amb.ac_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView EventsTextView;
    private EditText logEditText;
    private Button createButton;
    private TextView ResultTextView;
    private int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        createButton = (Button) findViewById(R.id.button_create);
        ResultTextView = (TextView) findViewById(R.id.textView_result);

        try{
            Bundle extras = getIntent().getExtras();
            int i = extras.getInt("contador");
            Log.d("MainActivity",String.valueOf(i));
            contador = i;
            ResultTextView.setText(String.valueOf(i));

        }catch (Exception e){

            System.out.println(e);

        }

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("contador",contador);
                startActivity(i);

            }
        });

    }

    public void updateBio(String toString) {


    }
}
