package com.two.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserid;
    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edusername = findViewById(R.id.ed_userid);
        String uid = getSharedPreferences("Atm" , MODE_PRIVATE)
                .getString("USERNAME" , " ");//" "為空字串
        edusername.setText(uid);
        DBHelper helper = new DBHelper(this , "money .db" , null , 1);
     //   helper.getWritableDatabase().insert()
    }
    public void login(View view){
                 //變數名稱                                            //id
        edUserid = findViewById(R.id.ed_userid);
        edPassword = findViewById(R.id.ed_password);
      String uid = edUserid.getText().toString();
      String psw = edPassword.getText().toString();
        if(uid.equals("apple") && psw.equals("123")){
            //方法一
//            SharedPreferences settings = getSharedPreferences("Atm" , MODE_PRIVATE);
//            settings.edit().putString("USERNAME" , uid).apply();
            //方法二
            getSharedPreferences("Atm" , MODE_PRIVATE)
                    .edit()
                    .putString("USERNAME" , uid )
                    .apply();
            Toast.makeText(this, "登入成功" , Toast.LENGTH_LONG ).show();
            setResult(RESULT_OK);
            finish();
        }else{//登入失敗
           new  AlertDialog.Builder(this).setTitle("Atm")
                   .setMessage("登入失敗").setPositiveButton("ok" ,null)
                   .show();

            }

    }
}
