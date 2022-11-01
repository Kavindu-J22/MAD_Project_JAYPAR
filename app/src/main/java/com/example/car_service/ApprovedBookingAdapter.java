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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ApprovedBookingAdapter extends FirebaseRecyclerAdapter<ApprovedBookingModel,ApprovedBookingAdapter.myApprovedViewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ApprovedBookingAdapter(@NonNull FirebaseRecyclerOptions<ApprovedBookingModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myApprovedViewholder holder, int position, @NonNull ApprovedBookingModel model) {
        holder.carNo.setText(model.CarNo);
        holder.bookId.setText(model.BookingId);

        holder.acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<>();
                map.put("CarNo",holder.carNo.getText().toString());
                map.put("BookingId",holder.bookId.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("progress").push()
                        .setValue(map);
                FirebaseDatabase.getInstance().getReference().child("approved_services")
                        .child(getRef(position).getKey()).removeValue();
            }
        });
    }

    @NonNull
    @Override
    public myApprovedViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approved_items,parent,false);
        return new myApprovedViewholder(view);
    }

    class myApprovedViewholder extends RecyclerView.ViewHolder{

        TextView carNo,bookId;
        Button acceptBtn;

        public myApprovedViewholder(@NonNull View itemView){
            super(itemView);

            carNo = (TextView)itemView.findViewById(R.id.approvedBikeNoText);
            bookId = (TextView)itemView.findViewById(R.id.approvedBookingIdText);

            acceptBtn = (Button)itemView.findViewById(R.id.acceptBtn);
        }
    }

}
