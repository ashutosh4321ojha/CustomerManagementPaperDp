 package com.example.ashutosh.customermanagementpaperdp.adapter;

/**
 * Created by ashutosh on 1/28/2016.
 */

 import android.app.Activity;
 import android.content.Intent;
 import android.support.v7.widget.RecyclerView;
 import android.util.Log;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;

 import com.example.ashutosh.customermanagementpaperdp.Activity.EditCustomerDetailsActivity;
 import com.example.ashutosh.customermanagementpaperdp.R;
 import com.example.ashutosh.customermanagementpaperdp.model.Customer.RegistrationDetailsCustomer;

 import java.util.List;


 public class RecyclerAdapterUserData extends RecyclerView.Adapter<RecyclerAdapterUserData.ViewHolder> {
     Activity context;
     List<RegistrationDetailsCustomer> customersList;



     public RecyclerAdapterUserData(Activity context, List<RegistrationDetailsCustomer> data) {

         this.context=context;
         customersList=data;
     }


     @Override
     public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_custom_list, null);


         ViewHolder viewHolder = new ViewHolder(itemLayoutView);
         return viewHolder;
     }

     @Override
     public void onBindViewHolder(ViewHolder viewHolder, int position) {


         Log.d("adapter",String.valueOf(customersList.get(position).getName()));

         viewHolder.tvCustomName.setText(String.valueOf(customersList.get(position).getName()));
         viewHolder.tvCustomEmail.setText(String.valueOf(customersList.get(position).getEmail()));
         viewHolder.tvCustomMobile.setText(String.valueOf(customersList.get(position).getPhoneNo()));
         viewHolder.tvCustomAddress.setText(String.valueOf(customersList.get(position).getAddress()));

         viewHolder.pos=position;
         viewHolder.itemView.setTag(viewHolder);
         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 ViewHolder holder=(ViewHolder) v.getTag();
                 RegistrationDetailsCustomer registrationDetailsCustomer=customersList.get(holder.pos);
                 Intent intent=new Intent(context,EditCustomerDetailsActivity.class);
                 intent.putExtra("CustomerData",registrationDetailsCustomer);
                 context.startActivity(intent);
             }
         });






     }

     public class ViewHolder extends RecyclerView.ViewHolder {

        int pos;
         TextView tvCustomName,tvCustomMobile,tvCustomEmail,tvCustomAddress;


         public ViewHolder(View itemLayoutView) {
             super(itemLayoutView);

             tvCustomName= (TextView) itemLayoutView.findViewById(R.id.custom_list_name);
             tvCustomMobile= (TextView) itemLayoutView.findViewById(R.id.custom_list_mobile);
             tvCustomEmail= (TextView) itemLayoutView.findViewById(R.id.custom_list_email);
             tvCustomAddress= (TextView) itemLayoutView.findViewById(R.id.custom_list_address);


         }
     }

     public void setData( List<RegistrationDetailsCustomer> list){
         customersList=list;
         notifyDataSetChanged();


     }


     // Return the size of your itemsData (invoked by the layout manager)
     @Override
     public int getItemCount() {
         return customersList.size() ;
     }

 }
