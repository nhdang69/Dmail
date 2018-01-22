package com.example.diorous.lightnovel.Model.DangNhapDangKy;

import android.content.Context;
import android.util.Log;

import com.example.diorous.lightnovel.Sever.DownloadJSON;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Diorous on 12/14/2017.
 */

public class DangNhap {
    AccessToken accessToken;
    GoogleSignInClient googleSignInClient;
    private GoogleSignInAccount googleSignInAccount;
    public AccessToken getAcccessToken(){
        AccessTokenTracker accessTokenTracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        accessToken=AccessToken.getCurrentAccessToken();
        return accessToken;
    }

    public GoogleSignInClient getGoogleSignInAccount(Context context) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(context, gso);

        return googleSignInClient;
    }

    public String DangNhap(String username,String password){
        String duongdan= MainActivity.Duongdan,kq="false";
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","DangNhap");
        HashMap<String,String> hmusername=new HashMap<>();
        hmusername.put("username",username);
        HashMap<String,String> hmpassword=new HashMap<>();
        hmpassword.put("password",password);

        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);
        hashMaps.add(hmusername);
        hashMaps.add(hmpassword);

        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            kq=downloadJSON.get();
            Log.d("dangnhap", kq);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return kq;
    }


}
