package com.assignment1.bo.nguyensieuboassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity {
    private Button Loginbutton;
    private EditText editText,email;
    private Spinner spinner;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LoginActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("LoginActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("LoginActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("LoginActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("LoginActivity", "Now running onRestart");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("LoginActivity", "Now running onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = (EditText)findViewById(R.id.Username);
        email = (EditText)findViewById(R.id.Email);
        spinner = (Spinner)findViewById(R.id.spinner);
        final CheckBox Confirmcb = (CheckBox) findViewById(R.id.checkBox);
        Loginbutton = (Button) findViewById(R.id.loginbutton);
            Confirmcb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton Button, boolean isChecked) {

                    if (Button.isChecked()) {
                        Loginbutton.setEnabled(true);
                    } else {
                        Loginbutton.setEnabled(false);
                    }
                }

            });
        Loginacivity();
    }


    public void Loginacivity () {
        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ListViewActivity.class);
                String text = spinner.getSelectedItem().toString();
                //In this activity save the name in the shared preference
                SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("user_name", editText.getText().toString()).putString("user_email", email.getText().toString()).apply();
                switch (text) {
                    case "Male": {
                        String message = "Mr. " + editText.getText().toString();
                        intent.putExtra("gender", message);
                        break;
                    }
                    case "Female": {
                        String message = "Mrs or Ms " + editText.getText().toString();
                        intent.putExtra("gender", message);
                        break;
                    }
                    case "Others": {
                        String message = editText.getText().toString();
                        intent.putExtra("gender", message);
                        break;
                    }
                }
                startActivity(intent);

            }
        });


    }
}
