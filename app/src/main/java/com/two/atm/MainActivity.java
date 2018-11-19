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
            if(resultCode == RESULT_OK){
            }else {
                finish();
            }
        }
    }
}
//    else{
//    Intent nickname = new Intent(this , NicknameActivity.class );
//    startActivity(nickname);
//}



