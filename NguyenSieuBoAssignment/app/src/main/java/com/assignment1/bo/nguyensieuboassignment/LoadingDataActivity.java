package com.assignment1.bo.nguyensieuboassignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoadingDataActivity extends AppCompatActivity {
    private TextView usernameLoad,useremailLoad,userAutoText,userToggle;
    private Button buttonLoad;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LoadingDataActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("LoadingDataActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("LoadingDataActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("LoadingDataActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("LoadingDataActivity", "Now running onRestart");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LoadingDataActivity", "Now running onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_data);
        usernameLoad = (TextView) findViewById(R.id.loadUserName);
        useremailLoad = (TextView) findViewById(R.id.loadUserMail);
        userAutoText = (TextView) findViewById(R.id.autocompleteload);
        userToggle = (TextView) findViewById(R.id.togglebuttonload);
        buttonLoad = (Button) findViewById(R.id.buttonload);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInformation();
            }
        });
    }
    public void getUserInformation() {
        //In the second activity or any other activity, you can get the userName and age like thi
        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("user_name", null);
        String userEmail = sharedPreferences.getString("user_email", null);
        String userChoseToggle = sharedPreferences.getString("toggle_button",null);
        String userChoseAutoText = sharedPreferences.getString("auto_complete",null);
        if(userName.equals("") && userEmail != null){
            Toast.makeText(LoadingDataActivity.this,"Cannot find username, Successfully loaded userEmail !!!",Toast.LENGTH_SHORT).show();
            useremailLoad.setText(userEmail);
            userAutoText.setText(userChoseAutoText);
            userToggle.setText(userChoseToggle);
        } else if(userEmail.equals("") && userName != null){
            Toast.makeText(LoadingDataActivity.this,"Cannot find useremail, Successfully loaded userName !!!",Toast.LENGTH_SHORT).show();
            usernameLoad.setText(userName);
            userAutoText.setText(userChoseAutoText);
            userToggle.setText(userChoseToggle);
        } else if(userName != null && userEmail != null){
            Toast.makeText(LoadingDataActivity.this,"Successfully loaded all data!!!",Toast.LENGTH_SHORT).show();
            usernameLoad.setText(userName);
            useremailLoad.setText(userEmail);
            userAutoText.setText(userChoseAutoText);
            userToggle.setText(userChoseToggle);
        }
    }
}
