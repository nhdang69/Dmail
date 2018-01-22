package com.example.diorous.lightnovel.View.DangNhapDangKy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.diorous.lightnovel.Adapter.AdapterPagerDangNhapDangKy;
import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.example.diorous.lightnovel.Presenter.DangNhapDangKy.PresenterLogicDangNhapDangKy;
import com.example.diorous.lightnovel.R;
import com.example.diorous.lightnovel.View.DangNhapDangKy.View.ViewDangKyDangNhap;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import org.json.JSONException;
import org.json.JSONObject;

public class DangNhapDangKyActivity extends AppCompatActivity implements ViewDangKyDangNhap{
    TabLayout tabdangnhapdangky;
    ViewPager viewPager;
    PresenterLogicDangNhapDangKy presenterLogicDangNhapDangKy;
    GoogleSignInAccount account;
    AccessToken accessToken;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_dang_ky);

        KhoiTao();
        Xuly();
    }

    private void Xuly() {
        AdapterPagerDangNhapDangKy adapterPagerDangNhapDangKy=new AdapterPagerDangNhapDangKy(getSupportFragmentManager());
        viewPager.setAdapter(adapterPagerDangNhapDangKy);
        tabdangnhapdangky.setupWithViewPager(viewPager);
        presenterLogicDangNhapDangKy.getAccess();
        googleSignInClient=presenterLogicDangNhapDangKy.getGooleSignInClient(this);
        account=getIntent().getExtras().getParcelable("accountgg");
        if(account!=null){
            presenterLogicDangNhapDangKy.getAccountGG(account);
        }
    }

    private void KhoiTao() {
        presenterLogicDangNhapDangKy=new PresenterLogicDangNhapDangKy(this);
        tabdangnhapdangky=findViewById(R.id.tabdangnhapdangky);
        viewPager=findViewById(R.id.pagerDangNhapDangKy);
    }

    @Override
    public void DangKyThanhCong(TaiKhoan taiKhoan) {
        Intent intent=new Intent(DangNhapDangKyActivity.this,MainActivity.class);
        intent.putExtra("name",taiKhoan.getName());
        startActivity(intent);
    }

    @Override
    public void DangKyThatBai(TaiKhoan taiKhoan) {
        Toast.makeText(this, "Đăng ký thông thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void XulyDangNhapFaceBookThanhCong(AccessToken accessToken) {
        this.accessToken=accessToken;
        GraphRequest graphRequest=GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String name=object.getString("name");
                    Intent intent=new Intent(DangNhapDangKyActivity.this, MainActivity.class);
                    intent.putExtra("nameFB",name);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters=new Bundle();
        parameters.putString("fields", "id,name,link");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    @Override
    public void XulyDangNhapFaceBookThatBai(AccessToken accessToken) {

    }

    @Override
    public void XuLyDangNhapGoogleThanhCong(GoogleSignInAccount googleSignInAccount) {
        String name=googleSignInAccount.getDisplayName();
        Intent intent=new Intent(DangNhapDangKyActivity.this, MainActivity.class);
        intent.putExtra("nameGG",name);
        startActivity(intent);

    }

    @Override
    public void XuLyDangNhapGoogleThatBai(GoogleSignInAccount googleSignInAccount) {

    }

    @Override
    public void DangNhapThanhCong(String name) {

    }

    @Override
    public void DangNhapThatBai(String name) {

    }
}
