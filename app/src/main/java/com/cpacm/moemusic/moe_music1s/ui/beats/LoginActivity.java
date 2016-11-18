package com.cpacm.moemusic.moe_music1s.ui.beats;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpacm.moemusic.moe_music1s.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayout=(TextInputLayout)findViewById(R.id.user_editlayout);
        textInputEditText=(TextInputEditText)findViewById(R.id.user_edittext);
        textInputLayout.setHint(getString(R.string.app_name));
    }
}
