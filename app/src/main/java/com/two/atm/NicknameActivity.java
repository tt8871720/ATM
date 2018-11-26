package com.two.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends BaseActivity {

    private EditText ednickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }
    public void next(View view){
        ednickname = findViewById(R.id.ed_nickname);
        String nickname = ednickname.getText().toString();
      user.setNickname(nickname);
        Intent age = new Intent(this , AgeActivity.class);
        startActivity(age);
    }
}
