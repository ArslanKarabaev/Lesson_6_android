package com.example.lesson_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCustomUI();

        MaterialButton bt_enter = findViewById(R.id.bt_enter);
        EditText enter_email = findViewById(R.id.enter_email);
        EditText enter_password = findViewById(R.id.enter_password);
        TextView sign_in = findViewById(R.id.sign_in);
        TextView enter = findViewById(R.id.enter);
        TextView forget_password = findViewById(R.id.forget_password);



        enter_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!enter_email.getText().toString().isEmpty()){
                    bt_enter.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }else{
                    bt_enter.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white3));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        enter_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!enter_password.getText().toString().isEmpty()){
                    bt_enter.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }else{
                    bt_enter.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white3));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });


        bt_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enter_email.getText().toString().equals("admin") && enter_password.getText().toString().equals("admin")){
                    sign_in.setVisibility(View.GONE);
                    enter_email.setVisibility(View.GONE);
                    enter_password.setVisibility(View.GONE);
                    enter.setVisibility(View.GONE);
                    forget_password.setVisibility(View.GONE);
                    bt_enter.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void showCustomUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}