package com.example.diorous.lightnovel.Model.DangNhapDangKy;

import android.os.AsyncTask;
import android.util.Log;

import com.example.diorous.lightnovel.Model.Object.TaiKhoan;
import com.example.diorous.lightnovel.Sever.DownloadJSON;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Diorous on 12/15/2017.
 */

public class DangKy {
    public String DangKyTaiKhoan(TaiKhoan taiKhoan){
        String duongdan= MainActivity.Duongdan,ketqua="";
        HashMap<String,String> tenham=new HashMap<>();
        tenham.put("ham","DangKy");
        HashMap<String,String> id=new HashMap<>();
        id.put("id",taiKhoan.getId());
        HashMap<String,String> name=new HashMap<>();
        name.put("name",taiKhoan.getName());
        HashMap<String,String> email=new HashMap<>();
        email.put("email",taiKhoan.getEmail());
        HashMap<String,String> username=new HashMap<>();
        username.put("username",taiKhoan.getUsername());
        HashMap<String,String> password=new HashMap<>();
        password.put("password",taiKhoan.getPassword());

        List<HashMap<String,String>> hashMaps=new ArrayList<>();

        hashMaps.add(tenham);
        hashMaps.add(id);
        hashMaps.add(name);
        hashMaps.add(email);
        hashMaps.add(username);
        hashMaps.add(password);

        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();
        try {
            ketqua=downloadJSON.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
