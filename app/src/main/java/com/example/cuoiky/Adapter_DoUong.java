package com.example.cuoiky;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Adapter_DoUong extends RecyclerView.Adapter<Adapter_DoUong.ViewHolder> {
    List<DoUongModel> doUongModelList;
    int resource;


    public Adapter_DoUong(List<DoUongModel>doanModelList, int resource){
        this.doUongModelList=doanModelList;
        this.resource=resource;
    }
    @NonNull
    @Override
    public Adapter_DoUong.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        Adapter_DoUong.ViewHolder viewHolder=new Adapter_DoUong.ViewHolder(view);

        return viewHolder  ;
    }



    @Override
    public int getItemCount() {
        return doUongModelList.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView txtimage_124;
        TextView tenmonan_124,money_124;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtimage_124=itemView.findViewById(R.id.image);
            tenmonan_124=itemView.findViewById(R.id.ten);
            money_124=itemView.findViewById(R.id.gia);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter_DoUong.ViewHolder holder, int position) {
        DoUongModel doUongModel=doUongModelList.get(position);
        holder.tenmonan_124.setText(doUongModel.getTen());
        holder.money_124.setText(doUongModel.getGia());

        StorageReference storageHinhAnh  = FirebaseStorage.getInstance().getReference().child("hinhanh").child(doUongModel.getAnh());

        final long ONE_MEGABYTE=1024*1024;
        storageHinhAnh.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.txtimage_124.setImageBitmap(bitmap);

            }
        });
    }

}
