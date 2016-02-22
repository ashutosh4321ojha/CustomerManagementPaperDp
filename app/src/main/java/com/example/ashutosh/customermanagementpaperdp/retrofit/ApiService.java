package com.example.ashutosh.customermanagementpaperdp.retrofit;



import com.example.ashutosh.customermanagementpaperdp.model.Customer.ObjectCustomerDetails;
import com.example.ashutosh.customermanagementpaperdp.model.shopkeeper.ObjectOfShopkeeperDetails;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 *Define all server calls here
 */
public interface ApiService {



    @FormUrlEncoded
    @POST("/api/admin/createSupplier ")
    public void signUp(@Field("name") String name, @Field("phoneNo") int phoneNo,
                       @Field("email") String email, @Field("password") int password, Callback<ObjectOfShopkeeperDetails> callback);

    @FormUrlEncoded
    @POST("/api/admin/supplierLogin")
    public void signIn(@Field("email") String email,
                       @Field("password") String password, Callback<ObjectOfShopkeeperDetails> callback);

    @FormUrlEncoded
    @POST("/api/admin/registerDriver")
    public void addCustomer(@Header("authorization") String accessToken, @Field("name") String name,
                            @Field("phoneNo") int phoneNo, @Field("email") String email,
                            @Field("address") String address, Callback<ObjectCustomerDetails> callback);

    @GET("/api/admin/getAlldriver")
    public void getCustomerList(@Header("authorization") String accessToken, Callback<ObjectCustomerDetails> callback);

}

