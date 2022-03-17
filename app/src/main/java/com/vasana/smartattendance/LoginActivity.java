package com.vasana.smartattendance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.number)
    EditText numberEt;
    @BindView(R.id.password)
    EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_btn)
    void login() {
//        if (numberEt.getText().toString().isEmpty() || passwordEt.getText().toString().isEmpty()) {
//            //validation failed
//            shout("Please enter a valid, user name and password...");
//        }else {
            // validation success
            Intent switcher = new Intent(this, ProfessorDashBoard.class);
            startActivity(switcher);
//        }
    }
}