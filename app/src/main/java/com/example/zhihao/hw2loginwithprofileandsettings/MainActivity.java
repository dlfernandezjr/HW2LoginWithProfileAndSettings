package com.example.zhihao.hw2loginwithprofileandsettings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    // declare all widgets
    private EditText nameEditText;
    private EditText pwdEditText;
    private RadioGroup gotoRadioGroup; // just a placeholder, not used in HW2
    private RadioButton profileRadioButton;
    private RadioButton settingsRadioButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkWidgets2UI();
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                processLogin();
            default: // do nothing
        }
    }

    private void processLogin() {
        if(isCorrectUsernameAndPwd()) {
            if(profileRadioButton.isChecked()) {
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                startActivity(profileIntent);
            } else if(settingsRadioButton.isChecked()) {
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
            } else {
                // do nothing
            }
        } else {
            // clear text of two widgets
            nameEditText.getText().clear();
            pwdEditText.getText().clear();

            Toast.makeText(this, "Login Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isCorrectUsernameAndPwd() {
        return nameEditText.getText().toString().equals("user") && pwdEditText.getText().toString().equals("1234");
    }

    private void linkWidgets2UI() {
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        pwdEditText = (EditText) findViewById(R.id.pwdEditText);
        gotoRadioGroup = (RadioGroup) findViewById(R.id.gotoRadioGroup);
        profileRadioButton = (RadioButton) findViewById(R.id.profileRadioButton);
        settingsRadioButton = (RadioButton) findViewById(R.id.settingsRadioButton);
        loginButton = (Button) findViewById(R.id.loginButton);
    }
}
