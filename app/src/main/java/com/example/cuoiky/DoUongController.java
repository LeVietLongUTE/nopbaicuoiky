package com.example.cuoiky;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoUongController {
    Context context;
    DoUongModel doUongModel ;
    Adapter_DoUong adapter_doAn_124;

    public DoUongController(Context context) {
        this.context = context;
        doUongModel=new DoUongModel();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<DoUongModel> doAnModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_doAn_124=new Adapter_DoUong(doAnModelList, R.layout.chitietlistview);
        recyclerView_124.setAdapter(adapter_doAn_124);
        DoUongInterface doUongInterface= new DoUongInterface() {
            @Override
            public void getDanhSachQuanAnModel(DoUongModel doUongModel) {
                doAnModelList.add(doUongModel);
                adapter_doAn_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        doUongModel.getDanhSachQuanAn(doUongInterface);
    }
}
