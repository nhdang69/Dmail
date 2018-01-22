package com.example.diorous.lightnovel.Presenter.DangNhapDangKy;

import android.content.Context;
import android.view.View;

import com.example.diorous.lightnovel.Model.DangNhapDangKy.DangKy;
import com.example.diorous.lightnovel.Model.DangNhapDangKy.DangNhap;
import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.example.diorous.lightnovel.View.DangNhapDangKy.View.ViewDangKyDangNhap;
import com.example.diorous.lightnovel.View.TrangChu.View.ViewXuLyMainActivity;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

/**
 * Created by Diorous on 12/14/2017.
 */

public class PresenterLogicDangNhapDangKy implements PresenterIDangNhapDangKy {
    DangNhap dangNhap;
    DangKy dangKy;
    ViewXuLyMainActivity viewXuLyMainActivity;
    ViewDangKyDangNhap viewDangKyDangNhap;

    public PresenterLogicDangNhapDangKy(ViewDangKyDangNhap viewDangKyDangNhap){
        this.viewDangKyDangNhap=viewDangKyDangNhap;
        dangNhap=new DangNhap();
        dangKy=new DangKy();
    }
    @Override
    public void getAccess() {
        AccessToken accessToken=dangNhap.getAcccessToken();
        if(accessToken!=null){
            viewDangKyDangNhap.XulyDangNhapFaceBookThanhCong(accessToken);
        }else {
            viewDangKyDangNhap.XulyDangNhapFaceBookThatBai(accessToken);
        }
    }

    @Override
    public void getAccountGG(GoogleSignInAccount googleSignInAccount) {
        if(googleSignInAccount!=null){
            viewDangKyDangNhap.XuLyDangNhapGoogleThanhCong(googleSignInAccount);
        }else {
            viewDangKyDangNhap.XuLyDangNhapGoogleThatBai(googleSignInAccount);
        }
    }

    @Override
    public GoogleSignInClient getGooleSignInClient(Context context) {
        return dangNhap.getGoogleSignInAccount(context);
    }

    @Override
    public void DangKyTaiKhoan(TaiKhoan taiKhoan) {
        String ketqua="";
        ketqua=dangKy.DangKyTaiKhoan(taiKhoan);
        if(ketqua.equals("true")){
            viewDangKyDangNhap.DangKyThanhCong(taiKhoan);
        }else {
            viewDangKyDangNhap.DangKyThatBai(taiKhoan);
        }
    }

    @Override
    public void DangNhap(String username, String password) {
        String ketqua="";
        ketqua=dangNhap.DangNhap(username,password);
        if(!ketqua.equals("")){
            String name=ketqua;
            viewDangKyDangNhap.DangNhapThanhCong(name);
        }else {
            viewDangKyDangNhap.DangNhapThatBai("");
        }
    }


}
