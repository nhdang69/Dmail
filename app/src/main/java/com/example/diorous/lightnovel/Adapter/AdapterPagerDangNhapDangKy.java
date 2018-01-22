package com.example.diorous.lightnovel.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.diorous.lightnovel.View.DangNhapDangKy.Fragment.FgDangKy;
import com.example.diorous.lightnovel.View.DangNhapDangKy.Fragment.FgDangNhap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diorous on 12/13/2017.
 */

public class AdapterPagerDangNhapDangKy extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public AdapterPagerDangNhapDangKy(FragmentManager fm) {
        super(fm);
        KhoitaoFragment();
    }

    private void KhoitaoFragment() {
        fragments=new ArrayList<>();
        FgDangNhap fgDangNhap=new FgDangNhap();
        fragments.add(fgDangNhap);
        FgDangKy fgDangKy=new FgDangKy();
        fragments.add(fgDangKy);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String tittle="";
        switch (position){
            case 0:
                tittle="Đăng nhập";
                break;
            case 1:
                tittle="Đăng ký";
                break;
        }
        return tittle;
    }
}
