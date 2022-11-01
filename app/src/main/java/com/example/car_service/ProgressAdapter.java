package com.example.car_service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ProgressAdapter extends FirebaseRecyclerAdapter<ProgressModel,ProgressAdapter.myProgressViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProgressAdapter(@NonNull FirebaseRecyclerOptions<ProgressModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myProgressViewHolder holder, int position, @NonNull ProgressModel model) {

        holder.carNo.setText(model.getCarNo());
        holder.bookId.setText(model.getBookingId());
    }

    @NonNull
    @Override
    public myProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item,parent,false);
        return new myProgressViewHolder(view);
    }

    class myProgressViewHolder extends RecyclerView.ViewHolder{

        TextView carNo,bookId;

        public myProgressViewHolder(@NonNull View itemView) {
            super(itemView);

            carNo = (TextView)itemView.findViewById(R.id.progressBikeNoText);
            bookId = (TextView)itemView.findViewById(R.id.progressBookIdText);
        }
    }
}