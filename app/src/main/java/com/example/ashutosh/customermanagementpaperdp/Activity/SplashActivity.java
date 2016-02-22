package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.ashutosh.customermanagementpaperdp.R;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonData;


/**
 * Created by ashutosh on 2/16/2016.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Handler handlerTimer = new Handler();
        handlerTimer.postDelayed(new Runnable() {
            public void run() {

                if(CommonData.getAppUser()==null){
                    Intent intent = new Intent(SplashActivity.this, GatewayActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashActivity.this, CustomerListActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);



    }
}
