package com.two.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean logon = false;//預設已經登入了
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

if(requestCode == RC_LOGIN){//成功登入,收到回傳值RC_LOGIN(100)
    if(resultCode != RESULT_OK){}//但不是因為帳密正確而成功所以退出
    finish();}
    else{
    Intent nickname = new Intent(this , NicknameActivity.class );
    startActivity(nickname);
}

    }
}
