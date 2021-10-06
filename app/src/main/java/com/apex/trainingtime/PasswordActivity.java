package com.apex.trainingtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hanks.passcodeview.PasscodeView;

public class PasswordActivity extends AppCompatActivity {

    PasscodeView passcodeView;
    ImageView fingerprintImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        passcodeView = findViewById(R.id.passcodeView);
        fingerprintImage = findViewById(R.id.fingerprintImage);

        fingerprintImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PasswordActivity.this, FingureprintActivity.class));
            }
        });

        passcodeView.setPasscodeLength(5)
                .setLocalPasscode("12345")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                    }

                    @Override
                    public void onSuccess(String number) {
                        startActivity(new Intent(PasswordActivity.this, SignInActivity.class));
                        finish();
                    }
                });

    }
}