package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.ashutosh.customermanagementpaperdp.R;
import com.example.ashutosh.customermanagementpaperdp.model.Customer.ObjectCustomerDetails;
import com.example.ashutosh.customermanagementpaperdp.retrofit.RestClient;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonData;
import com.example.ashutosh.customermanagementpaperdp.utils.ErrorHandlerClass;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ashutosh on 2/12/2016.
 */
public class NewCustomerDetailsEntry extends AppCompatActivity {
    EditText etCustomerName,etCustomerMobile,etCustomerEmail,etCustomerAddress;
    Button btnAddCustomer;
    ImageButton ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_new_customer_details);
      //Log.d("new", CommonData.getAppUser().getData().get(0).getAccessToken());

        initialise();

    }

    private void initialise() {

        etCustomerName=(EditText)findViewById(R.id.customer_name_edit_text);
        etCustomerMobile=(EditText)findViewById(R.id.customer_mobile_edit_text);
        etCustomerEmail=(EditText)findViewById(R.id.customer_email_edit_text);
        etCustomerAddress=(EditText)findViewById(R.id.customer_address_edit_text);
        btnAddCustomer=(Button)findViewById(R.id.customer_add_btn);
        ibBack=(ImageButton)findViewById(R.id.app_bar_back_button);
        ibBack.setBackgroundResource(R.drawable.btn_nav_back_normal1);
    }

    public void onClickAddCustomer(View view){
        Log.d("new",CommonData.getAppUser().getData().get(0).getAccessToken());

        RestClient.getApiService().addCustomer("bearer "+ CommonData.getAppUser().getData().get(0).getAccessToken(),
                etCustomerName.getText().toString(),
                Integer.parseInt(etCustomerMobile.getText().toString()),
                etCustomerEmail.getText().toString(),
                etCustomerAddress.getText().toString(),
                new Callback<ObjectCustomerDetails>() {
                    @Override
                    public void success(ObjectCustomerDetails objectCustomerDetails, Response response) {

                        Log.d("new", "added");

                        Intent intent = new Intent(getApplication(), CustomerListActivity.class);
                        startActivity(intent);

                        Toast.makeText(getApplication(),"added",Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("new", "not added");

                        ErrorHandlerClass.checkCode(NewCustomerDetailsEntry.this, error, true);


                    }
                });



    }

    public void onClickBack(View view) {
        Intent intent=new Intent(NewCustomerDetailsEntry.this,CustomerListActivity.class);
        startActivity(intent);
    }
}
