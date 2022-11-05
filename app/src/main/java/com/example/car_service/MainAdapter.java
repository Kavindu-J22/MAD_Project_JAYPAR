package com.example.car_service;

import android.app.AlertDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder,final int position, @NonNull MainModel model) {
        holder.carNo.setText(model.getCarNo());
        holder.bookingId.setText(model.getBookingId());
        holder.date.setText(model.getDate());
        holder.problem.setText(model.getProblem());
        holder.totalCost.setText(model.getTotalCost());

        holder.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.carNo.getContext());
                builder.setTitle("Are You Sure To Cancel Your Booking?");
                builder.setMessage("Deleted data can't be undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("services")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.carNo.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();

            }
        });


        holder.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<>();
                map.put("CarNo",holder.carNo.getText().toString());
                map.put("BookingId",holder.bookingId.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("approved_services").push()
                        .setValue(map);

                FirebaseDatabase.getInstance().getReference().child("services")
                        .child(getRef(position).getKey()).removeValue();

            }
        });



    }

    TextView bookingId,carNo;

    private void insertData(){


    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView carNo,bookingId,date,problem,totalCost;

        Button okBtn,cancelBtn;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            carNo = (TextView)itemView.findViewById(R.id.bikeNoText);
            bookingId = (TextView)itemView.findViewById(R.id.bookingIdText);
            date = (TextView)itemView.findViewById(R.id.dateText);
            problem = (TextView)itemView.findViewById(R.id.problemText);
            totalCost = (TextView)itemView.findViewById(R.id.totalCostText);

            okBtn = (Button)itemView.findViewById(R.id.okBtn);
            cancelBtn = (Button)itemView.findViewById(R.id.cancelBtn);


        }
    }


}