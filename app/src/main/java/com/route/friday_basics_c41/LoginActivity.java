package com.route.friday_basics_c41;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e("LoginActivity", "onCreate");
        Button loginButton = findViewById(R.id.loginBtn);
//        View.OnClickListener x = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LoginActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LoginActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LoginActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LoginActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LoginActivity", "onResume");
    }
}