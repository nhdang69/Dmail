package com.example.diorous.lightnovel.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.diorous.lightnovel.View.TrangChu.Fragment.FgAccount;
import com.example.diorous.lightnovel.View.TrangChu.Fragment.FgConvert;
import com.example.diorous.lightnovel.View.TrangChu.Fragment.FgDanhSach;
import com.example.diorous.lightnovel.View.TrangChu.Fragment.FgSangTac;
import com.example.diorous.lightnovel.View.TrangChu.Fragment.FgTrangChu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diorous on 12/10/2017.
 */

public class AdapterViewpagerTrangChu extends FragmentPagerAdapter{
    private List<Fragment> fragments;

    private void KhoitaoFragment(){
        fragments=new ArrayList<>();
        FgTrangChu fgTrangChu=new FgTrangChu();
        FgSangTac fgSangTac=new FgSangTac();
        FgConvert fgConvert=new FgConvert();
        FgDanhSach fgDanhSach=new FgDanhSach();
        FgAccount fgDangNhap=new FgAccount();
        fragments.add(fgTrangChu);
        fragments.add(fgSangTac);
        fragments.add(fgConvert);
        fragments.add(fgDanhSach);
        fragments.add(fgDangNhap);
    }

    public AdapterViewpagerTrangChu(FragmentManager fm) {
        super(fm);
        KhoitaoFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
