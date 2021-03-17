package com.example.myapplicationsber;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button button_pop;
    Button button_op;
    Button button_pr;
    TextView balance;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved";
    double money = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        balance = (TextView) findViewById(R.id.balance);//определяем место где буддет выводиться инфа
        //loadText();
        balance.setText(getIntent().getStringExtra("balance"));//с помощью ключа передаем инфу
        //balance.setText(String.valueOf(money));
        button_pop = (Button) findViewById(R.id.button_pop);
        button_op = (Button) findViewById(R.id.button_op);
        button_pr = (Button) findViewById(R.id.button_pr);

        button_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivitypop.class);
                startActivity(intent);
            }
        });
        button_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivityop.class);
                startActivity(intent);
            }
        });
        button_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivitypr.class);
                startActivity(intent);
            }
        });
        /**
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivitypop.class);  ///кнопка назад
                startActivity(intent);
            }
        });
         **/

    }

        @Override
        protected void onStart () {
            super.onStart();

            TextView numberCard = findViewById(R.id.numberCard);
            numberCard.setText(numberCard.getText() + getString(R.string.CardNumber));

            TextView UserName = findViewById(R.id.UserName);
            UserName.setText(UserName.getText() + "Fetisov A.A.");

        }

        private void saveText() {
            sPref = getPreferences( MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_TEXT, balance.getText().toString());
            ed.commit();
        }

        private void loadText() {
            sPref = getSharedPreferences("saved",MODE_PRIVATE);
            String savedText = sPref.getString(SAVED_TEXT,"");
            balance.setText(savedText);
        }
        protected void onDestroy(){
            super.onDestroy();
            loadText();
        }
}

