package com.example.scholarship_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

    }

    public void student(View view) {
        Intent stu = new Intent(this, StudentLogin.class);
        startActivity(stu);
    }

    public void admin(View view) {
        Intent stu = new Intent(this, AdminLogin.class);
        startActivity(stu);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
