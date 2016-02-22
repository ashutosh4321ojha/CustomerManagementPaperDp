package com.example.ashutosh.customermanagementpaperdp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.ashutosh.customermanagementpaperdp.R;
import com.example.ashutosh.customermanagementpaperdp.adapter.RecyclerAdapterUserData;
import com.example.ashutosh.customermanagementpaperdp.model.Customer.ObjectCustomerDetails;
import com.example.ashutosh.customermanagementpaperdp.model.Customer.RegistrationDetailsCustomer;
import com.example.ashutosh.customermanagementpaperdp.retrofit.RestClient;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonData;
import com.example.ashutosh.customermanagementpaperdp.utils.CommonProgressDialog;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ashutosh on 2/12/2016.
 */
public class CustomerListActivity extends AppCompatActivity {
        RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapterUserData adapter;
    List<RegistrationDetailsCustomer> customerList =new ArrayList<>();
    ProgressDialog progressDialog;
    ImageButton ibLogout;
    TextView tvListTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customers_list);

        initialise();



        if(CommonData.getCustomer()!=null && CommonData.getCustomer().getData().size()>0) {


          //  adapter.setData(CommonData.getCustomer().getData());
            adapter.setData((List<RegistrationDetailsCustomer>) Paper.book().read("customerData"));

//we have passed a false parameter here because it will help in deciding wheather to use progress dialog or not


            getDataFromServer(false);

        }
        else{

            getDataFromServer(true);
            adapter.setData(customerList);
        }






    }

    private void getDataFromServer(Boolean showLoading) {
if(showLoading)
        CommonProgressDialog.showProgressDialog(CustomerListActivity.this, "please wait");

        RestClient.getApiService().getCustomerList("bearer "+CommonData.getAppUser().getData().get(0).getAccessToken(),
                new Callback<ObjectCustomerDetails>() {

                    @Override
                    public void success(ObjectCustomerDetails objectCustomerDetails, Response response) {

                      //  Paper.book().write("customerData",objectCustomerDetails);
                        CommonData.saveCustomer(objectCustomerDetails);

                        Log.d("list", "success");
                        CommonProgressDialog.dismissProgressDialog();
                        adapter.setData(objectCustomerDetails.getData());

                      ;

                    }

                    @Override
                    public void failure(RetrofitError error) {
                        CommonProgressDialog.dismissProgressDialog();

                        Log.d("list","fail");


                    }
                });
    }

    private void initialise() {

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_customer_list);
        ibLogout=(ImageButton)findViewById(R.id.app_bar_logout);
        ibLogout.setBackgroundResource(R.drawable.logout);

        tvListTitle=(TextView)findViewById(R.id.app_bar_text_view);
        tvListTitle.setText("Customers List");
        layoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RecyclerAdapterUserData(CustomerListActivity.this,  customerList);
        recyclerView.setAdapter(adapter);
    }

    public void onClickAddNewCustomer(View view) {

        Intent intent=new Intent(this,NewCustomerDetailsEntry.class);
        startActivity(intent);
        }

    public void onClickLogout(View view) {

        //Prefs.with(getApplicationContext()).removeAll();
        Paper.book().destroy();
        Intent intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
        finish();

    }
}

