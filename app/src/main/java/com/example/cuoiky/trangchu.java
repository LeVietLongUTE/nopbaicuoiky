package com.example.cuoiky;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class trangchu extends Fragment {
    DoUongController doUongController_124;
    RecyclerView recyclerview_douong_124;
    ProgressBar progressBar_124;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_trangchu, container, false);
        recyclerview_douong_124=   (RecyclerView)view.findViewById(R.id.listview);
        progressBar_124=view.findViewById(R.id.progressBar);

   return view; }
    @Override
    public void onStart() {
        super.onStart();
        doUongController_124= new DoUongController(getContext());
        doUongController_124.getDanhSachQuanAnController(recyclerview_douong_124,progressBar_124);
    }
}