package com.example.ashutosh.customermanagementpaperdp.model.shopkeeper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashutosh on 2/12/2016.
 */
public class ObjectOfShopkeeperDetails {


    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<SignUpDetailsOfShopkeeper> data = new ArrayList<SignUpDetailsOfShopkeeper>();

    /**
     *
     * @return
     * The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param statusCode
     * The statusCode
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The data
     */
    public List<SignUpDetailsOfShopkeeper> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<SignUpDetailsOfShopkeeper> data) {
        this.data = data;
    }
}
