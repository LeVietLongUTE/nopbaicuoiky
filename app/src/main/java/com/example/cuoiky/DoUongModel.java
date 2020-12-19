package com.example.cuoiky;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoUongModel {
    String anh,ten,gia,madouong;
    DatabaseReference nodeRoot;
    public DoUongModel(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public DoUongModel(String anh, String ten, String gia) {
        this.anh = anh;
        this.ten = ten;
        this.gia = gia;

    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMadouong() {
        return madouong;
    }

    public void setMadouong(String madouong) {
        this.madouong = madouong;
    }
    public DatabaseReference getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(DatabaseReference nodeRoot) {
        this.nodeRoot = nodeRoot;
    }



    public void getDanhSachQuanAn(DoUongInterface doAnInterface_124) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("douong").getChildren()){
                    DoUongModel doAnModel=i.getValue(DoUongModel.class);
                    doAnModel.setMadouong(i.getKey());
                    doAnInterface_124.getDanhSachQuanAnModel(doAnModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}

