package cat.udl.tidic.amb.ac_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.sql.Date;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    private Button createButton;
    private Button backButton;
    private EditText EditTextName;
    private CalendarView EditCalendar;
    private int any;
    private int mes;
    private int dia;
    private EditText EditTextDescription;
    private String date_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        createButton = (Button) findViewById(R.id.bttn_create);
        backButton = (Button) findViewById(R.id.bttn_back);
        EditTextName = (EditText) findViewById(R.id. editText_name);
        EditCalendar = (CalendarView) findViewById(R.id. calendarView);
        EditTextDescription = (EditText) findViewById(R.id.editText_description);
        Bundle extras = getIntent().getExtras();
        final int current_contador = extras.getInt("contador");


        EditCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                any = year;
                mes = month;
                dia = dayOfMonth;

                Calendar c = Calendar.getInstance();
                c.set(year, month, dayOfMonth);

                date_str = dayOfMonth + "-" + (month +  1) + "-" + year;

                EditCalendar.setDate(c.getTimeInMillis());


            }
        });


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviem text
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("name",EditTextName.getText().toString());
                i.putExtra("calendar",date_str);
                i.putExtra("description",EditTextDescription.getText().toString());
                i.putExtra("contador",current_contador);
                startActivity(i);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
