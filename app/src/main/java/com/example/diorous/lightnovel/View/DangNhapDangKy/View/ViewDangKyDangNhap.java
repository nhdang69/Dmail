package com.example.diorous.lightnovel.View.DangNhapDangKy.View;

import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by Diorous on 12/15/2017.
 */

public interface ViewDangKyDangNhap {
    void DangKyThanhCong(TaiKhoan taiKhoan);
    void DangKyThatBai(TaiKhoan taiKhoan);
    void XulyDangNhapFaceBookThanhCong(AccessToken accessToken);
    void XulyDangNhapFaceBookThatBai(AccessToken accessToken);
    void XuLyDangNhapGoogleThanhCong(GoogleSignInAccount googleSignInAccount);
    void XuLyDangNhapGoogleThatBai(GoogleSignInAccount googleSignInAccount);
    void DangNhapThanhCong(String name);
    void DangNhapThatBai(String name);
}
