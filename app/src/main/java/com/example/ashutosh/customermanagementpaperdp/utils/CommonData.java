package com.example.ashutosh.customermanagementpaperdp.utils;

import com.example.ashutosh.customermanagementpaperdp.model.Customer.ObjectCustomerDetails;
import com.example.ashutosh.customermanagementpaperdp.model.shopkeeper.ObjectOfShopkeeperDetails;
import com.example.ashutosh.customermanagementpaperdp.paperdp.PaperDpNames;

import io.paperdb.Paper;


public class CommonData {

    private static ObjectOfShopkeeperDetails AppUser = null;
    private static ObjectCustomerDetails Customer = null;


    public static ObjectOfShopkeeperDetails getAppUser() {
        if (AppUser == null) {
           // AppUser = Prefs.with(context).getObject(PaperDpNames.APP_USER, ObjectOfShopkeeperDetails.class);
            AppUser= Paper.book().read(PaperDpNames.APP_USER);
        }


        return AppUser;

    }

    public static ObjectCustomerDetails getCustomer() {

        return Customer;
    }



    public static void saveAppUser(ObjectOfShopkeeperDetails appUser) {
        AppUser = appUser;
       // Prefs.with(context).save(PaperDpNames.APP_USER, appUser);
        Paper.book().write(PaperDpNames.APP_USER,appUser);

    }
    public static void saveCustomer(ObjectCustomerDetails customer) {
       Customer=customer;
       //  Prefs.with(context).save(PaperDpNames.USERS_CUSTOMER, customer);
        Paper.book().write(PaperDpNames.USERS_CUSTOMER,customer);

    }



}
