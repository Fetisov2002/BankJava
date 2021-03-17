package com.example.myapplicationsber;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationsber.ui.BankJava;

import org.w3c.dom.Text;

public class MainActivityMoney extends AppCompatActivity {
    EditText popolnite;
    Button press;
    TextView UserName;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved";
    private int savedText;
    TextView balance;

    Button ClearButton;
    double money;

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
        EditText popolnite= (EditText) findViewById(R.id.popolnite);
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

    public void onClickClear(View v) {
        switch (v.getId()){
            case R.id.ClearButton:
                popolnite.setText(null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_money);

        ActionBar actionBar =getSupportActionBar();//кнопка назад
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        balance = (TextView) findViewById(R.id.balance);//определяем место где буддет выводиться инфа
        balance.setText(getIntent().getStringExtra("balance"));//с помощью ключа передаем инфу

        Intent intent = getIntent();
        UserName = (TextView) findViewById(R.id.UserName);
        UserName.setText(intent.getStringExtra("position"));

        ClearButton = (Button) findViewById(R.id.ClearButton);
        ClearButton.setOnClickListener(this::onClickClear);


        popolnite = (EditText) findViewById(R.id.popolnite);
        press = (Button) findViewById(R.id.press);
        press.setOnClickListener(this::onClick);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.press:
                BankJava bankJava = new BankJava();
                //bankJava.Withdraw();
                break;
        }






        //money -= Integer.valueOf(popolnite.getText().toString());
        //if (a > b) {
            //Toast.makeText(MainActivityMoney.this, "Недостаточно средств", Toast.LENGTH_LONG).show();
       // } else {
        /**
            balance.setText((money) + "руб");
            Toast.makeText(MainActivityMoney.this, "Списано" + money + "руб", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            intent.putExtra("balance", balance.getText().toString());     //передача инфы на другой активити

            Intent intent1 = new Intent(MainActivityMoney.this, MainActivity2.class);
            intent1.putExtra("balance", balance.getText().toString());
            startActivity(intent1);
            startActivity(intent);
            finish();
         **/

        }
    //}
            @Override
            protected void onStart () {
                super.onStart();
                loadText();
            }

        private void loadText() {
            sPref = getSharedPreferences("text", MODE_PRIVATE);
            String savedText = sPref.getString(SAVED_TEXT, "");
            balance.setText(savedText);

        }

        protected void onDestroy() {
            super.onDestroy();
            loadText();

        }
    /**


        press.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /**
                
                if (TextUtils.isEmpty(popolnite.getText().toString())) {
                    Toast.makeText(MainActivityMoney.this, "Укажите сумму перевода", Toast.LENGTH_LONG).show();
                } else {

                    double a = Double.parseDouble(popolnite.getText().toString());
                    //double b = Double.parseDouble(balance.setText(SAVED_TEXT));
                    //String c = b - a;
                    Toast.makeText(MainActivityMoney.this, "Cписано " + a + "руб", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("balance", balance.getText().toString());                       //передача инфы на другой активити
                    startActivity(intent);
                    finish();

                }
            }
            private void saveText() {
                sPref = getPreferences( MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString(SAVED_TEXT, balance.getText().toString());
                ed.commit();

                Toast.makeText(MainActivityMoney.this, "Text saved", Toast.LENGTH_LONG).show();
            }

            private void loadText() {
                sPref = getPreferences(MODE_PRIVATE);
                String savedText = sPref.getString(SAVED_TEXT,"");
                balance.setText(savedText);

                Toast.makeText(MainActivityMoney.this, "Text loaded", Toast.LENGTH_LONG).show();
            }
            protected void onDestroy() {
                super.onDestroy();
                saveText();
            }
        });

        }
        **/
    }










