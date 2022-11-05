package com.example.car_service;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CarAdapter extends  FirebaseRecyclerAdapter<CarModel,CarAdapter.myCarViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CarAdapter(@NonNull FirebaseRecyclerOptions<CarModel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myCarViewHolder holder, int position, @NonNull CarModel model) {
        holder.brand.setText(model.getBrand());
        holder.ccAmount.setText(model.getCcAmount());
        holder.modelYear.setText(model.getModelYear());
        holder.mileage.setText(model.getMileage());

        holder.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.brand.getContext());
                builder.setTitle("Are You Sure To Remove Your Car Details?");
                builder.setMessage("Deleted data can't be undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("car_details")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.brand.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_items,parent,false);
        return new myCarViewHolder(view);
    }

    class myCarViewHolder extends RecyclerView.ViewHolder{

        TextView brand,ccAmount,modelYear,mileage;
        Button cancelBtn;


        public myCarViewHolder(@NonNull View itemView) {
            super(itemView);

            brand = (TextView)itemView.findViewById(R.id.brandNameText);
            ccAmount = (TextView)itemView.findViewById(R.id.CCAmountText);
            modelYear = (TextView)itemView.findViewById(R.id.modelYearText);
            mileage = (TextView)itemView.findViewById(R.id.mileageText);

            cancelBtn = (Button)itemView.findViewById(R.id.bikeRemoveBtn);
        }
    }

}
