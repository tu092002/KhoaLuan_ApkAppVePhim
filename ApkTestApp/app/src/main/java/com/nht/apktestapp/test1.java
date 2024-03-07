package com.nht.apktestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class test1 extends AppCompatActivity {

    EditText edtF,edtC;
    Button btnFtoC,btnCtoF,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);

        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnCtoF = findViewById(R.id.btnCtoF);
        btnFtoC = findViewById(R.id.btnFtoC);
        btnClear = findViewById(R.id.btnClear);

        // xử lí click
        btnFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double f = Double.parseDouble(edtF.getText().toString());
               edtC.setText((f-32)*5/9 + "") ;
            }
        });


    }
}