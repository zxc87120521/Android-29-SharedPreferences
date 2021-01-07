package com.example.android_num_29_sharedpreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, phone, sex;
    Button save, clear, read, clean;
    String Name = "Name ";
    String Phone = "Phone ";
    String Sex = "Sex ";

    SharedPreferences data;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditView
        name = findViewById(R.id.input_name);
        phone = findViewById(R.id.input_phone);
        sex = findViewById(R.id.input_sex);
        //Button
        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);
        read = findViewById(R.id.read);
        clean = findViewById(R.id.clean);

        data = getSharedPreferences("userData", Context.MODE_PRIVATE);

        //儲存單元
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = data.edit();
                editor.putString(Name, name.getText().toString());
                editor.putString(Phone, phone.getText().toString());
                editor.putString(Sex, sex.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Data Save", Toast.LENGTH_SHORT).show();
            }
        });
        //讀取單元
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.contains(Name)){
                    name.setText(data.getString(Name, ""));
                }
                if (data.contains(Phone)){
                    phone.setText(data.getString(Phone, ""));
                }
                if (data.contains(Sex)){
                    sex.setText(data.getString(Sex, ""));
                }
                Toast.makeText(MainActivity.this, "Data Read", Toast.LENGTH_SHORT).show();
            }
        });
        //清除單元
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove(Name);
                editor.remove(Phone);
                editor.remove(Sex);
                editor.apply();
                Toast.makeText(MainActivity.this, "Data Clear", Toast.LENGTH_SHORT).show();

            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                sex.setText("");
            }
        });
    }
}