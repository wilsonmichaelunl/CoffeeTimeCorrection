package carlcrate.come.coffeeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import java.text.ParseException;

public class MainActivity extends Activity {
    private TimeCalc newTime = new TimeCalc();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindTime(View view) throws ParseException {
        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.instruction);
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
        brands.setText("Set your coffee maker to make coffee at " + timeToShow);
    }
}
