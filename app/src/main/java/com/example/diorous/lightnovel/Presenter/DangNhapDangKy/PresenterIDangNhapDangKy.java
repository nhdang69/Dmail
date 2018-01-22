package com.example.diorous.lightnovel.Presenter.DangNhapDangKy;

import android.content.Context;

import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.SignInAccount;

/**
 * Created by Diorous on 12/14/2017.
 */

public interface PresenterIDangNhapDangKy {
    void getAccess();
    void getAccountGG(GoogleSignInAccount googleSignInAccount);
    GoogleSignInClient getGooleSignInClient(Context context);
    void DangKyTaiKhoan(TaiKhoan taiKhoan);
    void DangNhap(String username,String password);
}
