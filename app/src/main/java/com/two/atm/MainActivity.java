package com.two.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
boolean logon = false;//預設已經登入了
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    if(!logon){//若還沒登入將跳到LoginActivity
        Intent intent = new Intent(this , LoginActivity.class);
startActivity(intent);
    }
    }
}
