package com.assignment1.bo.nguyensieuboassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListViewActivity extends AppCompatActivity {
    private TextView username;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ListViewActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("ListViewActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("ListViewActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("ListViewActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("ListViewActivity", "Now running onRestart");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("ListViewActivity", "Now running onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        final Intent intent = this.getIntent();
        String gender= intent.getStringExtra("gender");
        if(gender == null){
            SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
            gender = sharedPreferences.getString("user_name", null);
            String greeting = "Hello " + gender + "\n"
                    + "Thanks for using the app" + "\n"
                    + "Please choose your option:";
            username = (TextView) findViewById(R.id.txtusername);
            username.setText(greeting);
        } else {
            String greeting = "Hello " + gender + "\n"
                    + "Thanks for using the app" + "\n"
                    + "Please choose your option:";
            username = (TextView) findViewById(R.id.txtusername);
            username.setText(greeting);
        }
        List<ViewOptions> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // ClickListener enable when user click item of the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                TextView t1  = (TextView) v.findViewById(R.id.itemView);

                if (Objects.equals(t1.getText().toString(), "Clock Alarm")) {

                    Intent intent1 = new Intent(ListViewActivity.this, ClockActivity.class);
                    startActivity(intent1);
                } else if (Objects.equals(t1.getText().toString(), "Testing Input Controls")){
                    Intent intent1 = new Intent(ListViewActivity.this, InputControlActivity.class);
                    startActivity(intent1);
                } else if (Objects.equals(t1.getText().toString(), "Simple Calendar")){
                    Intent intent1 = new Intent(ListViewActivity.this, SimpleCalendarActivity.class);
                    startActivity(intent1);
                } else if (Objects.equals(t1.getText().toString(), "Loading User Data")){
                    Intent intent1 = new Intent(ListViewActivity.this, LoadingDataActivity.class);
                    startActivity(intent1);
                }
            }
        });

    }
    private  List<ViewOptions> getListData() {
        List<ViewOptions> list = new ArrayList<ViewOptions>();
        ViewOptions clockalarm = new ViewOptions("Clock Alarm", "clock", "An Useful Alarm Clock");
        ViewOptions inputcontrols = new ViewOptions("Testing Input Controls", "inputcontrols", "Improve Programming");
        ViewOptions simplecalendar = new ViewOptions("Simple Calendar", "calendar", "A Calendar Implementation");
        ViewOptions loadingdata = new ViewOptions("Loading User Data","data", "Data Loading Test");
        list.add(clockalarm);
        list.add(inputcontrols);
        list.add(simplecalendar);
        list.add(loadingdata);
        return list;
    }


}
