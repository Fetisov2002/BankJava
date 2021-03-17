package com.example.myapplicationsber;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.myapplicationsber.R.*;

public class MainActivity extends AppCompatActivity {

    private final String pin = "07102";
    EditText textPassword;
    Button btn;
    Button ClearButton;

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
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.one));
    }
    private void display2(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.two));
    }
    private void display3(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.three));
    }
    private void display4(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.four));
    }
    private void display5(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.five));
    }
    private void display6(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.six));
    }
    private void display7(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.seven));
    }
    private void display8(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.eight));
    }
    private void display9(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.nine));
    }
    private void display0(int number) {
        EditText textPassword = (EditText) findViewById(id.textPassword);
        textPassword.setText(textPassword.getText() + getString(string.zero));
    }

    public void onClickClear(View v) {
        switch (v.getId()){
            case R.id.ClearButton:
                textPassword.setText(null);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.activity_main);

        ClearButton = (Button) findViewById(R.id.ClearButton);
        ClearButton.setOnClickListener(this::onClickClear);

        textPassword = (EditText) findViewById(id.textPassword);//поле для ввода пароля
        btn = (Button)findViewById(id.search);                  //кнопка Enter при ее нажатии выполняется код

        btn.setOnClickListener(new View.OnClickListener(){       // к кнопке присваивается код который бужет запускать при ее нажатии
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(textPassword.getText().toString())){
                    Toast.makeText(MainActivity.this,"Введите пароль",Toast.LENGTH_SHORT).show();
                    }else
                        if(textPassword.getText().toString().equals(pin)) {
                            Toast.makeText(getApplicationContext(),"Добро пожаловать",Toast.LENGTH_SHORT).show();
                                                                                                                      //после того как пароль введен верно то включаетсяч переход на другой activity2
                            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);                  //начало перехода
                            startActivity(intent);
                            finish();                                                                                 //конец
                        }else{
                            Toast.makeText(getApplicationContext(),"Пароль не верный",Toast.LENGTH_SHORT).show();//в случае если пароль введен не верно
                }
            }
        });
    }
}

