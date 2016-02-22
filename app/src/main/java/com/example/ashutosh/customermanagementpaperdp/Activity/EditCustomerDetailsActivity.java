package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ashutosh.customermanagementpaperdp.R;
import com.example.ashutosh.customermanagementpaperdp.model.Customer.RegistrationDetailsCustomer;


/**
 * Created by ashutosh on 2/12/2016.
 */
public class EditCustomerDetailsActivity extends AppCompatActivity {
    EditText etEditName,etEditMobile,etEditEmail,etEditAddress;
    RegistrationDetailsCustomer customerDataObject;
    ImageButton ibBack;
    TextView tvEditTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_customer_details);
        Log.d("edit", "got it");
        initilaise();
        customerDataObject = (RegistrationDetailsCustomer)getIntent().getSerializableExtra("CustomerData");
        setData();


    }

    private void setData() {

        etEditName.setText(customerDataObject.getName());
        etEditMobile.setText(customerDataObject.getPhoneNo()+"");
        etEditEmail.setText(customerDataObject.getEmail());
        etEditAddress.setText(customerDataObject.getAddress());
        tvEditTitle.setText("Edit Customer Details Page");
        ibBack.setBackgroundResource(R.drawable.btn_nav_back_normal1);
    }

    private void initilaise() {
        etEditName= (EditText)findViewById(R.id.edit_name_edit_text);
        etEditMobile= (EditText) findViewById(R.id.edit_mobile_edit_text);
        etEditEmail= (EditText) findViewById(R.id.edit_email_edit_text);
        etEditAddress= (EditText) findViewById(R.id.edit_address_edit_text);
        ibBack=(ImageButton)findViewById(R.id.app_bar_back_button);
        tvEditTitle=(TextView)findViewById(R.id.app_bar_text_view);

    }

    public void onClickEdit(View view) {

    }

    public void onClickDelete(View view) {
    }

    public void onClickBack(View view) {

        Intent intent=new Intent(this,CustomerListActivity.class);
        startActivity(intent);
        finish();
    }
}
