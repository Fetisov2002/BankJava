package com.example.myapplicationsber;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplicationsber.ui.karta;

import java.util.Scanner;

import static com.example.myapplicationsber.R.string.CardNumber;
import static com.example.myapplicationsber.R.string.money;
import static com.example.myapplicationsber.R.string.suma;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class MainActivitypop extends AppCompatActivity {
    protected TextView balance;
    protected EditText popolnite;
    Button press;
    Button buttonLoad;
    //double money = 0;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved";
    private String Text;

    double money = 0;//глобальная перемнная доступная всему приложению

    @Override
    protected void onStart() {
        super.onStart();
        TextView numberCard = findViewById(R.id.numberCard);
        numberCard.setText(numberCard.getText() + getString(CardNumber));

        TextView UserName = findViewById(R.id.UserName);
        UserName.setText(UserName.getText() + "Fetisov A.A.");
    }

    public void submitOrder1(View view) {
        display1(1);
    }

    public void submitOrder2(View view) {
        display2(2);
    }

    public void submitOrder3(View view) {
        display3(3);
    }

    public void submitOrder4(View view) {
        display4(4);
    }

    public void submitOrder5(View view) {
        display5(5);
    }

    public void submitOrder6(View view) {
        display6(6);
    }

    public void submitOrder7(View view) {
        display7(7);
    }

    public void submitOrder8(View view) {
        display8(8);
    }

    public void submitOrder9(View view) {
        display9(9);
    }

    public void submitOrder0(View view) {
        display0(0);
    }

    private void display1(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.one));
    }

    private void display2(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.two));
    }

    private void display3(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.three));
    }

    private void display4(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.four));
    }

    private void display5(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.five));
    }

    private void display6(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.six));
    }

    private void display7(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.seven));
    }

    private void display8(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.eight));
    }

    private void display9(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.nine));
    }

    private void display0(int number) {
        EditText popolnite = (EditText) findViewById(R.id.popolnite);
        popolnite.setText(popolnite.getText() + getString(R.string.zero));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitypop);

        ActionBar actionBar = getSupportActionBar();//кнопка назад
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        popolnite = (EditText) findViewById(R.id.popolnite);
        balance = (TextView) findViewById(R.id.balance);


        buttonLoad = (Button) findViewById(R.id.ClearButton);
        buttonLoad.setOnClickListener(this::onClickClear);

        press = (Button) findViewById(R.id.press);
        press.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.press:

                if (TextUtils.isEmpty(popolnite.getText().toString())) {
                    Toast.makeText(MainActivitypop.this, "Введите сумму пополнения ", Toast.LENGTH_SHORT).show();
                } else {

                    double ads = Double.parseDouble(popolnite.getText().toString());
                    money = money + ads;
                    balance.setText(String.valueOf(money));

                    Intent intent = new Intent(MainActivitypop.this, MainActivity2.class);                  //начало перехода
                    intent.putExtra("balance", balance.getText().toString());
                    startActivity(intent);
                    finish();
                }
        }
    }



                @Override
                public boolean onOptionsItemSelected (MenuItem item){
                    switch (item.getItemId()) {
                        case android.R.id.home:
                            this.finish();
                            return true;
                        default:
                            return super.onOptionsItemSelected(item);
                    }
                }

                public void onClickClear (View v){
                    switch (v.getId()) {
                        case R.id.ClearButton:
                            popolnite.setText(null);
                    }
                }
                private void saveText () {
                    sPref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(SAVED_TEXT, balance.getText().toString());
                    ed.commit();

                }

                protected void onDestroy () {
                    super.onDestroy();
                    saveText();
                }

}









