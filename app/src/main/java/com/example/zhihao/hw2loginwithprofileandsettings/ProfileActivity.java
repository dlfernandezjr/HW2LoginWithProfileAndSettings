package com.example.zhihao.hw2loginwithprofileandsettings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends Activity implements View.OnClickListener {
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        linkWidgets2UI();
        logoutButton.setOnClickListener(this);
    }

    private void processLogout() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm to log out?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent loginIntent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void linkWidgets2UI() {
        logoutButton = (Button) findViewById(R.id.logoutButton);
        //Toast.makeText(this, "Id of logout button is " + R.id.logoutButton, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logoutButton:
                processLogout();
            default: // do nothing
        }
    }
}
