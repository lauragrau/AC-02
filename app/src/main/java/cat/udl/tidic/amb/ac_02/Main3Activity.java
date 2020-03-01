package cat.udl.tidic.amb.ac_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Button OKButton;
    private Button CancelButton;
    private TextView RespuestaName;
    private TextView RespuestaCalendar;
    private TextView RespuestaDescription;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        OKButton = (Button) findViewById(R.id.bttn_accept);
        CancelButton = (Button) findViewById(R.id.bttn_cancel);
        RespuestaName = (TextView) findViewById(R.id.textView_n);
        RespuestaCalendar = (TextView) findViewById(R.id.textView_c);
        RespuestaDescription = (TextView) findViewById(R.id.textView_d);


        //agafem el text enviat
        Bundle extras = getIntent().getExtras();
        String n = extras.getString("name");
        String c = extras.getString("calendar");
        String d = extras.getString("description");
        contador = extras.getInt("contador");
        RespuestaName.setText(n);
        RespuestaCalendar.setText(c);
        RespuestaDescription.setText(d);




        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contador = contador + 1;

                Intent i = new Intent(Main3Activity.this, MainActivity.class);
                i.putExtra("contador", contador);
                startActivity(i);

            }
        });
    }
}
