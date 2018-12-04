package com.two.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    //數字隨便設
    private static final int RC_LOGIN = 1;
    boolean logon = false; //預設已經登入了
    List<String> fruits = Arrays.asList("Banana", "Guava", "Pinapple");

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
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter());
    }
//    private void list(List<String> fruits) {
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , fruits);
//        ListView listview = findViewById(R.id.list);


    //    }
    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        //紅字時按Alt + Enter = implement,就會自動出現下列@
        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new FruitViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FruitAdapter.FruitViewHolder holder, int position) {
//因為這裡沒有內容,所以還不會顯示
        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        class FruitViewHolder extends RecyclerView.ViewHolder {
            TextView nameText;

            public FruitViewHolder(View itemView) {
                super(itemView);
                nameText = itemView.findViewById(android.R.id.text1);
            }
        }
    }

    public void listView() {
        List<String> fruits = Arrays.asList("Banana", "Guava", "Pinapple");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
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




