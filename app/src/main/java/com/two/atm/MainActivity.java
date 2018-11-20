package com.two.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 1;
    boolean logon = false; //預設已經登入了
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    if(!logon){//若還沒登入將跳到LoginActivity
       Intent intent = new Intent(this , LoginActivity.class);
       startActivityForResult(intent , RC_LOGIN);
  }
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK){
                finish();
            }else {
                logon = true;
                String nickname = getSharedPreferences("user" , MODE_PRIVATE)
                        .getString("NICKNAME" , null);
                int age = getSharedPreferences("user" , MODE_PRIVATE)
                        .getInt("AGE" , 0);
                String gender = getSharedPreferences("user" , MODE_PRIVATE)
                        .getString("GENDER" , null);
                //只要資料沒有填齊,就要再回到NicknameActivity
                if(nickname == null || age == 0 || gender == null){
           Intent nick = new Intent(this , NicknameActivity.class);
           startActivity(nick);
            }}
        }
    }
}




