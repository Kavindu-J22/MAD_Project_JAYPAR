package com.example.car_service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentTab3 extends Fragment {

    RecyclerView recyclerView;
    ProgressAdapter progressAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTab3.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTab3 newInstance(String param1, String param2) {
        FragmentTab3 fragment = new FragmentTab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.progressRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        FirebaseRecyclerOptions<ProgressModel> options =
                new FirebaseRecyclerOptions.Builder<ProgressModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("progress"), ProgressModel.class)
                        .build();

        progressAdapter = new ProgressAdapter(options);
        recyclerView.setAdapter(progressAdapter);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        progressAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        progressAdapter.startListening();
    }

}
