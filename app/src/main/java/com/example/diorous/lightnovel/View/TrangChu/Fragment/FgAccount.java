package com.example.diorous.lightnovel.View.TrangChu.Fragment;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.example.diorous.lightnovel.Presenter.DangNhapDangKy.PresenterLogicDangNhapDangKy;
import com.example.diorous.lightnovel.R;
import com.example.diorous.lightnovel.View.DangNhapDangKy.DangNhapDangKyActivity;
import com.example.diorous.lightnovel.View.TrangChu.View.ViewXuLyMainActivity;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diorous on 12/10/2017.
 */

public class FgAccount extends Fragment implements View.OnClickListener{
    RelativeLayout reladangnhap,reldangxuat;
    TextView txtdangnhap;
    ImageView imageView;
    GoogleSignInClient googleSignInClient;
    String nameFB="",nameGG="",name="";
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_account,container,false);
        reladangnhap=view.findViewById(R.id.reldangnhap);
        reldangxuat=view.findViewById(R.id.reldangxuat);
        txtdangnhap=view.findViewById(R.id.txtdangnhap);
        imageView=view.findViewById(R.id.imgArrowWhile);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        nameFB=getActivity().getIntent().getStringExtra("nameFB");
        if(nameFB==null){
            nameFB="";
        }
        nameGG=getActivity().getIntent().getStringExtra("nameGG");
        if(nameGG==null){
            nameGG="";
        }
        name=getActivity().getIntent().getStringExtra("name");
        if(name==null)
        {
            sharedPreferences=getActivity().getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
            name=sharedPreferences.getString("name","");
        }
        if (!nameGG.equals("")) {
            txtdangnhap.setText(nameGG);
            imageView.setVisibility(View.INVISIBLE);
            reldangxuat.setVisibility(View.VISIBLE);
        }
        if(!nameFB.equals("")){
            txtdangnhap.setText(nameFB);
            imageView.setVisibility(View.INVISIBLE);
            reldangxuat.setVisibility(View.VISIBLE);
        }
        if(!name.equals("")){
            txtdangnhap.setText(name);
            imageView.setVisibility(View.INVISIBLE);
            reldangxuat.setVisibility(View.VISIBLE);
        }
        reladangnhap.setOnClickListener(this);
        reldangxuat.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.reldangnhap:
                if(txtdangnhap.getText().toString().equals("Đăng nhập")){
                    Intent intent=new Intent(getActivity(), DangNhapDangKyActivity.class);
                    startActivity(intent);
                    return;
                }
                break;
            case R.id.reldangxuat:
                if(!nameFB.equals("")&&nameGG.equals("")&&name.equals("")){
                    LoginManager.getInstance().logOut();
                    nameFB="";
                    txtdangnhap.setText(R.string.dangnhap);
                    imageView.setVisibility(View.VISIBLE);
                    reldangxuat.setVisibility(View.INVISIBLE);
                }else  if(nameFB.equals("")&&!nameGG.equals("")&&name.equals("")){
                    googleSignInClient.signOut();
                    nameGG="";
                    txtdangnhap.setText(R.string.dangnhap);
                    imageView.setVisibility(View.VISIBLE);
                    reldangxuat.setVisibility(View.INVISIBLE);
                }else if(nameFB.equals("")&&nameGG.equals("")&&!name.equals("")){
                    name="";
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                txtdangnhap.setText(R.string.dangnhap);
                imageView.setVisibility(View.VISIBLE);
                reldangxuat.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }


}
