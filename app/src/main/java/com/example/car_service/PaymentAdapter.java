package com.example.car_service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PaymentAdapter extends FirebaseRecyclerAdapter<PaymentModel,PaymentAdapter.myViewHolder>{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PaymentAdapter(@NonNull FirebaseRecyclerOptions<PaymentModel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull PaymentModel model) {
        holder.BookingId.setText(model.getBookingId());
        holder.CarNo.setText(model.getCarNo());
        holder.OwnerName.setText(model.getOwnerName());
        holder.Date.setText(model.getDate());
        holder.FullAmount.setText(model.getFullAmount());

    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView CarNo,BookingId,Date,OwnerName,FullAmount;
        Button paymentBtn;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            BookingId=(TextView)itemView.findViewById(R.id.BookingID1);
            CarNo=(TextView)itemView.findViewById(R.id.carNo);
            OwnerName=(TextView)itemView.findViewById(R.id.OwnerNameID1);
            Date=(TextView)itemView.findViewById(R.id.DateID1);
            FullAmount=(TextView)itemView.findViewById(R.id.FullCostID1);

            paymentBtn = (Button)itemView.findViewById(R.id.paymentBtn);

        }
    }
}