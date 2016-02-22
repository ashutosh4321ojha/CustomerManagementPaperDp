package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ashutosh.customermanagementpaperdp.R;


/**
 * Created by ashutosh on 2/11/2016.
 */
public class GatewayActivity extends AppCompatActivity {
    Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gateway_activity);
        btnSignUp=(Button)findViewById(R.id.btn_sign_up);
        btnSignIn=(Button)findViewById(R.id.btn_sign_in);
    }

    public void onClickSignUp(View view){
        Intent intent=new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }
    public void onClickSignIn(View view){
        Intent intent=new Intent(this,SignInActivity.class);
        startActivity(intent);


    }
}
