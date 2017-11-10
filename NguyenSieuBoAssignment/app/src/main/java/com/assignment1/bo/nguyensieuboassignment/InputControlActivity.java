package com.assignment1.bo.nguyensieuboassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class InputControlActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("InputControlActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("InputControlActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("InputControlActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("InputControlActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("InputControlActivity", "Now running onRestart");
        super.onRestart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("InputControlActivity", "Now running onCreate");
        final SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        Button submitbutton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_control);
        final Intent intent = this.getIntent();
        // Testing Auto Complete Suggestions
        // Get a reference to the TextView and AutoCompleteTextView in the layout
        final AutoCompleteTextView autoCompletePlainText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        TextView autoCompleteTextView = (TextView) findViewById(R.id.autoCompleteTextView1);
        // Get the string array
        String[] autocomplete_array = getResources().getStringArray(R.array.autocomplete_array);
        // Set TextView information
        String autocomplete_message;
        autocomplete_message = "Testing autocomplete suggestions text";
        autoCompleteTextView.setText(autocomplete_message);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(InputControlActivity.this, android.R.layout.simple_dropdown_item_1line, autocomplete_array);
        autoCompletePlainText.setAdapter(adapter);
        // Testing Toggle Button
        TextView toggleButtonView = (TextView) findViewById(R.id.textViewToggle);
        // Set toggle information
        String toggle_message;
        toggle_message = "Testing toggle button";
        toggleButtonView.setText(toggle_message);
        // Set toggle button
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(InputControlActivity.this, "Toggle Button is On", Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle is disabled
                    Toast.makeText(InputControlActivity.this, "Toggle Button is Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Testing Radio Button
        TextView radioButtonView = (TextView) findViewById(R.id.textViewRadio);
        // set radio information
        String radio_message;
        radio_message = "Testing radio button \n" +
                "Questions: Are you a good student?";
        radioButtonView.setText(radio_message);
        submitbutton = (Button) findViewById(R.id.buttonsubmit);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putString("auto_complete", autoCompletePlainText.getText().toString()).apply();
                sharedPreferences.edit().putString("toggle_button", toggleButton.getText().toString()).apply();
                Toast.makeText(InputControlActivity.this, "Successfully Submitted Data (Toggle Button + Auto Suggestion)", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // Set radio button group
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton3:
                if (checked)
                    Toast.makeText(InputControlActivity.this,"You chose yes!!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(InputControlActivity.this,"You chose maybe!!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton1:
                if (checked)
                    Toast.makeText(InputControlActivity.this,"You chose no!!!",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}