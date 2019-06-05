package com.example.scholarship_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class stuLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_login);
    }

    public void log(View view) {
        Intent stu = new Intent(this,stuActivity.class);
        startActivity(stu);
    }

}
