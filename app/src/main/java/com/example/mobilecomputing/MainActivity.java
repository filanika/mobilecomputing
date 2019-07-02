package com.example.mobilecomputing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText)findViewById(R.id.edt_user);
        pwd = (EditText)findViewById(R.id.edt_pass);
        loginBtn = (Button)findViewById(R.id.btn_login);

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(MainActivity.this, Main2Activity.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
    }
    public void login(View view) {
        String username = uname.getText().toString();
        String password = pwd.getText().toString();
        if(username.equals("Filanika") &&
                password.equals("santi")){
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("username",username);
            editor.putString("password",password);
            editor.commit();
            startActivity(intent);
        }
        else
        {
            AlertDialog.Builder builder = new
                    AlertDialog.Builder(MainActivity.this);
            builder.setMessage("User Name & Password Salah").setNegativeButton("Coba Lagi",null).create().show();
        }

    }
}
