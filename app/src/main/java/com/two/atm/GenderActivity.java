package com.two.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends BaseActivity {

    private EditText edgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next (View view){
        edgender = findViewById(R.id.ed_gender);
        String gender = edgender.getText().toString();
      user.setGender(gender);
        Intent main = new Intent(this , MainActivity.class);
        setResult(RESULT_OK);
        // single clear 刪除面的Activity
        // single top 回到指定的Activity而非重新建立一個刪除前面的
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }
    public void back(View view){
        finish();
    }
}
