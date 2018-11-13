package com.two.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edUserid = findViewById(R.id.ed_userid);
        edUserid.setText(getSharedPreferences("atm" , MODE_PRIVATE).getString("USERID" , ""));
    }
    public void login(View view){
                 //變數名稱                                            //id
        EditText edUserid = findViewById(R.id.ed_userid);
        EditText edPassword = findViewById(R.id.ed_password);
        String uid = edUserid.getText().toString();
        String pw = edPassword.getText().toString();
        if(uid.equals("apple") && pw.equals("123")){
            Toast.makeText(this , "登入成功" , Toast.LENGTH_LONG).show();
            getSharedPreferences("USERID" , MODE_PRIVATE)
               .edit()
                    .putString("USERID" , uid)
                    .apply();
            setResult(RESULT_OK);
            finish();
        }else{//登入失敗
           new  AlertDialog.Builder(this).setTitle("Atm")
                   .setMessage("登入失敗").setPositiveButton("ok" ,null)
                   .show();

            }

    }
}
