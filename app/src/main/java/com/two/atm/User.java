package com.two.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class User extends AppCompatActivity {
    private Context context;
    String userid;
    String nickname;
    int age;
    String gender;
    boolean valid = false;
    SharedPreferences settings;
public User(Context context){
    this.context = context;
    //資料都放在settings裡
    settings = context.getSharedPreferences("user" , context.MODE_PRIVATE);
}
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getNickname() {
if(nickname == null){
    nickname = settings.getString("NICKNAME " , null);
}  return nickname;
     }

    public void setNickname(String nickname) {
        settings.edit()
                .putString("NICKNAME" , nickname)
                .apply();
        this.nickname = nickname;

    }

    public int getAge() {
     if(age == 0){
         age = settings.getInt("AGE" , 0);
    }return age;
    }

    public void setAge(int age) {
        settings.edit()
                .putInt("AGE" , age)
                .apply();
        this.age = age;
    }

    public String getGender() {
        if(gender == null) {
        gender = settings.getString("GENDER" , null);
        }return gender;
    }

    public void setGender(String gender) {
        settings.edit()
                .putString("GENDER" , gender)
                .apply();
        this.gender = gender;
    }

    public boolean isValid() {
        //資料已經填齊
        valid = getNickname() != null && age != 0 && gender != null;
        return valid;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
}
