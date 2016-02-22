package com.example.ashutosh.customermanagementpaperdp.model.shopkeeper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashutosh on 2/12/2016.
 */
public class SignInDetailsOfShopkeeper  {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return email;
    }


    public void setPassword(String email) {
        this.email = email;
    }



}
