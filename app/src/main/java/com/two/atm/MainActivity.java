package com.two.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity{
    private static final int RC_LOGIN = 1;
    boolean logon = false; //預設已經登入了
    List<String> fruits = Arrays.asList("Banana" , "Guava" , "Pinapple");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView nickText = findViewById(R.id.nickname);
//        nickText.setText(user.getNickname());
        if (!logon) {//若還沒登入將跳到LoginActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }

      //  list(fruits);
        // RecyclerView
 
    }

    class FruitsAdapter{

    }
    private void list(List<String> fruits) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , fruits);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                logon = true;
                //只要資料沒有填齊,就要再回到NicknameActivity
                if (user.isValid()) {
                    Intent nick = new Intent(this, NicknameActivity.class);
                    startActivity(nick);
                }
            }
        }
    }
}




