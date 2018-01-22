package com.example.diorous.lightnovel.View.DangNhapDangKy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.example.diorous.lightnovel.Presenter.DangNhapDangKy.PresenterLogicDangNhapDangKy;
import com.example.diorous.lightnovel.R;
import com.example.diorous.lightnovel.View.DangNhapDangKy.View.ViewDangKyDangNhap;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diorous on 12/13/2017.
 */

public class FgDangKy extends Fragment implements View.OnClickListener,View.OnFocusChangeListener,ViewDangKyDangNhap{
    Button btndangky;
    EditText edthoten,edtemail,edtusername,edtpassword;
    TextInputLayout tilhoten,tilemail,tilusername,tilpassword;
    boolean kiemtra=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_dangky,container,false);

        btndangky=view.findViewById(R.id.btndangky);
        edthoten=view.findViewById(R.id.edthoten);
        edtemail=view.findViewById(R.id.edtemail);
        edtpassword=view.findViewById(R.id.edtpassword);
        edtusername=view.findViewById(R.id.edtusername);
        edtusername.setOnFocusChangeListener(this);
        edtpassword.setOnFocusChangeListener(this);
        edthoten.setOnFocusChangeListener(this);
        edtemail.setOnFocusChangeListener(this);


        tilhoten=view.findViewById(R.id.tilhoten);
        tilemail=view.findViewById(R.id.tilemail);
        tilusername=view.findViewById(R.id.tilusername);
        tilpassword=view.findViewById(R.id.tilpassword);



        btndangky.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(!kiemtra){
            Toast.makeText(getActivity(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
        }else {
            TaiKhoan taiKhoan=new TaiKhoan();
            taiKhoan.setEmail(edtemail.getText().toString());
            taiKhoan.setName(edthoten.getText().toString());
            taiKhoan.setUsername(edtusername.getText().toString());
            taiKhoan.setPassword(edtpassword.getText().toString());

            PresenterLogicDangNhapDangKy presenterLogicDangNhapDangKy=new PresenterLogicDangNhapDangKy(this);
            presenterLogicDangNhapDangKy.DangKyTaiKhoan(taiKhoan);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id=view.getId();
        String text="";
        switch (id){
            case R.id.edthoten:
                if(!b){
                    text=edthoten.getText().toString();
                    if(text.equals("")){
                        tilhoten.setErrorEnabled(true);
                        tilhoten.setError("mục này không được để trống");
                        kiemtra=false;
                    }else {
                        tilhoten.setErrorEnabled(false);
                        tilhoten.setError("");
                        kiemtra=true;
                    }
                }

                break;
            case R.id.edtemail:
                if(!b){
                    text=edtemail.getText().toString();
                    Pattern pattern= Patterns.EMAIL_ADDRESS;
                    Matcher matcher=pattern.matcher(text);
                    if(!matcher.matches()){
                        tilemail.setErrorEnabled(true);
                        tilemail.setError("Không đúng định dạng email");
                        kiemtra=false;
                    }else {
                        tilemail.setError("");
                        tilemail.setErrorEnabled(false);
                        kiemtra=true;
                    }
                }

                break;
            case R.id.edtusername:
                if(!b){
                    text=edtusername.getText().toString();
                    if(text.equals("")){
                        tilusername.setErrorEnabled(true);
                        tilusername.setError("mục này không được để trống");
                        kiemtra=false;
                    }else {
                        tilusername.setErrorEnabled(false);
                        tilusername.setError("");
                        kiemtra=true;
                    }
                }

                break;
            case R.id.edtpassword:
                if(!b){
                    text=edtpassword.getText().toString();
                    if(text.equals("")){
                        tilpassword.setErrorEnabled(true);
                        tilpassword.setError("mục này không được để trống");
                        kiemtra=false;
                    }else {
                        tilpassword.setErrorEnabled(false);
                        tilpassword.setError("");
                        kiemtra=true;
                    }
                }

                break;
        }
    }

    @Override
    public void DangKyThanhCong(TaiKhoan taiKhoan) {
        Intent intent=new Intent(getActivity(), MainActivity.class);
        intent.putExtra("name",taiKhoan.getName());
        startActivity(intent);
    }

    @Override
    public void DangKyThatBai(TaiKhoan taiKhoan) {

    }

    @Override
    public void XulyDangNhapFaceBookThanhCong(AccessToken accessToken) {

    }

    @Override
    public void XulyDangNhapFaceBookThatBai(AccessToken accessToken) {

    }

    @Override
    public void XuLyDangNhapGoogleThanhCong(GoogleSignInAccount googleSignInAccount) {

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
