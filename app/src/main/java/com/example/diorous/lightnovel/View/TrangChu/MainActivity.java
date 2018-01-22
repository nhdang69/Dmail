package com.example.diorous.lightnovel.View.TrangChu;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.diorous.lightnovel.Adapter.AdapterViewpagerTrangChu;
import com.example.diorous.lightnovel.Helper.BottomNaVigationViewHelper;
import com.example.diorous.lightnovel.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    public static final String Duongdan="http://10.0.2.2/lightnovel/lightnovel.php";
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        KhoiTao();
        Xuly();
    }

    private void Xuly() {


        BottomNaVigationViewHelper.DisableShiflmode(bottomNavigationView);
        AdapterViewpagerTrangChu adapterViewpagerTrangChu=new AdapterViewpagerTrangChu(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewpagerTrangChu);

        //khởi tạo sự kiện click bottomnavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void KhoiTao() {

        bottomNavigationView=findViewById(R.id.navigation_trangchu);
        viewPager=findViewById(R.id.trangchuviewpager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mhome:
                viewPager.setCurrentItem(0);
                item.setChecked(true);
                break;
            case R.id.msangtac:
                viewPager.setCurrentItem(1);
                item.setChecked(true);
                break;
            case R.id.mmaydich:
                viewPager.setCurrentItem(2);
                item.setChecked(true);
                break;
            case R.id.mdanhsach:
                viewPager.setCurrentItem(3);
                item.setChecked(true);
                break;
            case R.id.maccount:
                viewPager.setCurrentItem(4);
                item.setChecked(true);
                break;
        }
        return false;
    }
}
