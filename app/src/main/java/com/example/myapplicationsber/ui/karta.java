package com.example.myapplicationsber.ui;

import com.example.myapplicationsber.MainActivitypop;

import static com.example.myapplicationsber.R.string.money;

public class karta extends MainActivitypop {
    double money = 0;
   public void Deposit() {
       double ads = Double.parseDouble(popolnite.getText().toString());
       money = money + ads;
       balance.setText(String.valueOf(money));
   }
}
