package com.example.diorous.lightnovel.View.DangNhapDangKy.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diorous.lightnovel.Model.DangNhapDangKy.DangNhap;
import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.example.diorous.lightnovel.Presenter.DangNhapDangKy.PresenterLogicDangNhapDangKy;
import com.example.diorous.lightnovel.R;
import com.example.diorous.lightnovel.View.DangNhapDangKy.DangNhapDangKyActivity;
import com.example.diorous.lightnovel.View.DangNhapDangKy.View.ViewDangKyDangNhap;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Diorous on 12/13/2017.
 */

public class FgDangNhap extends Fragment implements View.OnClickListener,ViewDangKyDangNhap,View.OnFocusChangeListener{
    Button btndangnhapfb,btndangnhapgg,btndangnhap;
    CallbackManager callbackManager;
    GoogleSignInClient mGoogleSignInClient;
    DangNhap dangNhap;
    int RC_SIGN_IN;
    EditText edtusername,edtpassword;
    TextView txtloi;
    TextInputLayout tilusername,tilpassword;
    boolean kiemtra;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_dangnhap,container,false);

        btndangnhapfb=view.findViewById(R.id.btndangnhapfb);
        btndangnhapgg=view.findViewById(R.id.btndangnhapgg);
        btndangnhap=view.findViewById(R.id.btndangnhap);
        edtpassword=view.findViewById(R.id.passsworddn);
        edtusername=view.findViewById(R.id.usernamedn);
        tilusername=view.findViewById(R.id.tilusernamedn);
        tilpassword=view.findViewById(R.id.tilpassworddn);
        txtloi=view.findViewById(R.id.txtloi);
        edtusername.setOnFocusChangeListener(this);
        edtpassword.setOnFocusChangeListener(this);
        btndangnhapfb.setOnClickListener(this);
        btndangnhapgg.setOnClickListener(this);
        btndangnhap.setOnClickListener(this);
        callbackManager=CallbackManager.Factory.create();
        XulyDangNhapFaceBook();
        dangNhap =new DangNhap();

        mGoogleSignInClient = dangNhap.getGoogleSignInAccount(getActivity());

        return view;
    }

    private void XulyDangNhapFaceBook() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent=new Intent(getActivity(), DangNhapDangKyActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> googleSignInAccountTask=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = googleSignInAccountTask.getResult(ApiException.class);
                if(account!=null){
                    Intent intent=new Intent(getActivity(),DangNhapDangKyActivity.class);
                    intent.putExtra("accountgg",account);
                    startActivity(intent);
                }
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btndangnhapfb:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
                break;
            case R.id.btndangnhapgg:
                signInGG();
            case R.id.btndangnhap:
                dangnhap();
        }

    }

    private void dangnhap() {
        if(kiemtra){
            PresenterLogicDangNhapDangKy presenterLogicDangNhapDangKy=new PresenterLogicDangNhapDangKy(this);
            presenterLogicDangNhapDangKy.DangNhap(edtusername.getText().toString(),edtpassword.getText().toString());
            txtloi.setVisibility(View.GONE);
        }
        else {
            String text = edtusername.getText().toString();
            if (text.equals("")) {
                tilusername.setErrorEnabled(true);
                tilusername.setError("mục này không được để trống");

            } else {
                tilusername.setErrorEnabled(false);
                tilusername.setError("");

            }
            String textmk=edtpassword.getText().toString();
            if(text.equals("")){
                tilpassword.setErrorEnabled(true);
                tilpassword.setError("mục này không được để trống");

            }else {
                tilpassword.setErrorEnabled(false);
                tilpassword.setError("");

            }
            txtloi.setVisibility(View.VISIBLE);
        }
    }

    private void signInGG() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void DangKyThanhCong(TaiKhoan taiKhoan) {

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
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("dangnhap",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name);
        editor.apply();
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void DangNhapThatBai(String name) {
        txtloi.setVisibility(View.VISIBLE);
        kiemtra=false;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id=view.getId();
        String text="";
        switch (id) {
            case R.id.usernamedn:
                if (!b) {
                    text = edtusername.getText().toString();
                    if (text.equals("")) {
                        tilusername.setErrorEnabled(true);
                        tilusername.setError("mục này không được để trống");
                        kiemtra = false;
                    } else {
                        tilusername.setErrorEnabled(false);
                        tilusername.setError("");
                        kiemtra = true;
                    }
                }
                break;

            case R.id.passsworddn:
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
}
