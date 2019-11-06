package com.nabil.whereisthebus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nabil.whereisthebus.Fetchers.FetchBusArrival;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    Button getBusTimingButton;
    EditText busStopCodeInput;
    TextView displayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBusTimingButton = findViewById(R.id.getBusTimingButton);
        busStopCodeInput = findViewById(R.id.busStopCodeInput);
        displayInfo = findViewById(R.id.displayInfo);

        // TODO: MAKE ADAPTER FOR BUS ARRIVALS

        getBusTimingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_text = busStopCodeInput.getText().toString();
                if(!input_text.equals("")){
                    new FetchBusArrival(input_text, MainActivity.this).execute();
                }else{
                    // TODO: CONVERT ERROR MESSAGES TO TOASTS
                    // Temporary error message
                    displayInfo.setText("Input something!");
                }
            }
        });
    }
}