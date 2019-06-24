package com.example.scholarship_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class StudentLogin extends AppCompatActivity {

    private Button logoutButton;
    private Button loginButton;
    private static String mUsername;
    public FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN=1;
    public static int flag=0;
    private MainActivity mainActivity = new MainActivity();

    public String getmUsername() {
        return mUsername;
    }

    public static void setmUsername(String mUsername) {
        StudentLogin.mUsername = mUsername;
    }

    public void student(View view) {
        Intent stu = new Intent(this, StudentLogin.class);
        startActivity(stu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);



        mFirebaseAuth = FirebaseAuth.getInstance();

        logoutButton = findViewById(R.id.logout);
        loginButton = findViewById(R.id.login);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(StudentLogin.this);
                flag=0;
                mUsername = " ";
                Intent stu = new Intent(StudentLogin.this, MainActivity.class);
                startActivity(stu);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stu = new Intent(StudentLogin.this, StudentActivity.class);
                startActivity(stu);

            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebasAuth) {
                FirebaseUser currentuser = mFirebaseAuth.getCurrentUser();
                if (currentuser != null) {
                    onSignedInInitialize(currentuser.getDisplayName());
                } else {
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);


                }
            }
        };

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN) {
            if(resultCode == RESULT_CANCELED)
                finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out_menu:
                AuthUI.getInstance().signOut(this);
                mUsername = " ";
                flag=0;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onSignedInInitialize(String username) {
        mUsername = username;
        if (flag !=1) {
            startActivity(new Intent(StudentLogin.this, StudentActivity.class));
            flag=1;
        }

    }

    private void  onSignedOutCleanup() {
        mUsername = " ";
    }

}
