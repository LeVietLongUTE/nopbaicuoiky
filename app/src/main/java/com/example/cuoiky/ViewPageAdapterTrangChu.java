package com.example.cuoiky;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapterTrangChu  extends FragmentStatePagerAdapter {
    public ViewPageAdapterTrangChu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new trangchu();

            default:
                return new trangchu();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
