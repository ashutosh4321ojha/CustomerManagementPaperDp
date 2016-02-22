package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.ashutosh.customermanagementpaperdp.R;
import com.example.ashutosh.customermanagementpaperdp.model.shopkeeper.ObjectOfShopkeeperDetails;
import com.example.ashutosh.customermanagementpaperdp.retrofit.RestClient;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonAlert;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonAlertDialog;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonData;
import com.example.ashutosh.customermanagementpaperdp.utils.ErrorHandlerClass;

import io.paperdb.Paper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ashutosh on 2/11/2016.
 */
public class SignUpActivity extends AppCompatActivity {
    EditText etShopkeeperName,etShopkeeperMobile,etShopkeeperEmail,etShopkeeperPassword;
    Button btnSignUpShopkeeper;
    TextView tvAppBar;
    ImageButton ibAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        initialise();


    }

    private void initialise() {
        etShopkeeperName=(EditText)findViewById(R.id.signup_name_edit_text);
        etShopkeeperMobile=(EditText)findViewById(R.id.mobile_edit_text);
        etShopkeeperEmail=(EditText)findViewById(R.id.signup_email_edit_text);
        etShopkeeperPassword=(EditText)findViewById(R.id.password_edit_text);
        btnSignUpShopkeeper=(Button)findViewById(R.id.btn_sign_up);

        tvAppBar=(TextView)findViewById(R.id.app_bar_text_view);
        ibAppBar=(ImageButton)findViewById(R.id.app_bar_back_button);
    }
    public void onClickSignUp(View view){

        btnSignUpShopkeeper.setEnabled(false);

        if(isValid())
       setDataOnServer();




    }

    private boolean isValid() {

        if(TextUtils.isEmpty(etShopkeeperEmail.getText().toString()) &&

                android.util.Patterns.EMAIL_ADDRESS.matcher(etShopkeeperEmail.getText().toString()).matches()){
            CommonAlertDialog.setDialog(SignUpActivity.this, "enter a valid email");
            return false;
        }

        if ((etShopkeeperPassword.getText().toString().length() >5))
        {
            CommonAlertDialog.setDialog(SignUpActivity.this, "enter a valid password");
            return false;
        }
        return true;
    }

    private void setDataOnServer() {
        RestClient.getApiService().signUp(etShopkeeperName.getText().toString(),
                Integer.parseInt(etShopkeeperMobile.getText().toString()),
                etShopkeeperEmail.getText().toString(),
                Integer.parseInt(etShopkeeperPassword.getText().toString()), new Callback<ObjectOfShopkeeperDetails>() {



                    @Override
                    public void success(ObjectOfShopkeeperDetails objectOfShopkeeperDetails, Response response) {

                        btnSignUpShopkeeper.setEnabled(true);
                      //  Paper.book().write("shopkeeperData",objectOfShopkeeperDetails);

                        CommonData.saveAppUser(objectOfShopkeeperDetails);

                        CommonAlertDialog.setDialog(SignUpActivity.this, "Account Created");

                        Log.d("Tag", "success" + response);
                        Log.d("Tag","success"+objectOfShopkeeperDetails.getData().get(0).getAccessToken());

                        CommonAlert.showAlert(SignUpActivity.this, "Click Ok To Sign In",
                                new CommonAlert.OnAlertOkClickListener() {
                                    @Override
                                    public void onOkButtonClicked() {
                                        Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                                        startActivity(intent);
                                    }
                                });



                        //  CommonAlertDialog.
                      //  Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
                       // startActivity(intent);

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        btnSignUpShopkeeper.setEnabled(true);
                        ErrorHandlerClass.checkCode(SignUpActivity.this, error, true);


                        Log.d("Tag","fail"+error);

                    }
                });

    }

    public void onClickAlreadyAccount(View view) {

        Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
        startActivity(intent);
        finish();
    }

}
