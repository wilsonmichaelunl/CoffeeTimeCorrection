package carlcrate.come.coffeeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class MainActivity extends Activity {
    private TimeCalc newTime = new TimeCalc();
    private TextView display;
    private static final String KEY_TEXT_VALUE = "textValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.instruction);
        if(savedInstanceState != null){
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            display.setText(savedText);
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, display.getText());
    }

    public void onClickFindTime(View view) throws ParseException, InvocationTargetException {
        //Get a reference to the TextView
        display = (TextView) findViewById(R.id.instruction);
        //Get a reference to the first EditText
        EditText desiredTime = (EditText) findViewById(R.id.desired_time);
        //Get a reference to the second EditText
        EditText timeOnMaker = (EditText) findViewById(R.id.time_on_maker);
        //Get the the desired time from the input
        String brewTime = String.valueOf(desiredTime.getText());
        //Get the time on the coffee maker from the input
        String machineTime = String.valueOf(timeOnMaker.getText());
        //Get time from the TimeCalc Class
        String timeToShow = newTime.getTime(brewTime, machineTime);
        //Display the selected item
        display.setText(timeToShow);
    }
}
