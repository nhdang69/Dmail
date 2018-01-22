package com.example.diorous.lightnovel.Model.TrangChu;

import android.util.Log;

import com.example.diorous.lightnovel.Model.Object.Truyen;
import com.example.diorous.lightnovel.Sever.DownloadJSON;
import com.example.diorous.lightnovel.View.TrangChu.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Diorous on 12/20/2017.
 */

public class XuLyFgTrangChu {
    public List<Truyen> getChuongMoiNhat(){
        List<Truyen> truyens=new ArrayList<>();
        String duongdan= MainActivity.Duongdan;
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","ChuongMoiNhat");
        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);

        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            String chuongmoinhat=downloadJSON.get();
            Log.d("ChuongMoiNhat", chuongmoinhat);

            JSONObject Jsonchuongmoinhat=new JSONObject(chuongmoinhat);
            JSONArray data=Jsonchuongmoinhat.getJSONArray("chuongmoinhat");
            int count=data.length();
            for (int i = 0; i < count; i++) {
                JSONObject truyen=data.getJSONObject(i);

                Truyen truyenmoinhat=new Truyen();
                truyenmoinhat.setTentruyen(truyen.getString("TenT"));
                truyenmoinhat.setMatruyen(truyen.getInt("MaT"));
                truyens.add(truyenmoinhat);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return truyens;
    }
    public String getAnh(int ma){
        String anh="";
        String duongdan= MainActivity.Duongdan;
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","getAnhTap");
        HashMap<String,String> matruyen=new HashMap<>();
        matruyen.put("matruyen",String.valueOf(ma));
        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);
        hashMaps.add(matruyen);
        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            anh=downloadJSON.get();
            Log.d("hinhanh", downloadJSON.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return anh;
    }

    public List<Truyen> getSangTacNoiBat() {
        List<Truyen> truyens=new ArrayList<>();
        String duongdan= MainActivity.Duongdan;
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","SangTacNoiBat");
        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);

        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            String sangtacnoibat=downloadJSON.get();
            Log.d("SangTacNoiBat", sangtacnoibat);

            JSONObject Jsonchuongmoinhat=new JSONObject(sangtacnoibat);
            JSONArray data=Jsonchuongmoinhat.getJSONArray("sangtacnoibat");
            int count=data.length();
            for (int i = 0; i < count; i++) {
                JSONObject truyen=data.getJSONObject(i);

                Truyen truyenmoinhat=new Truyen();
                truyenmoinhat.setTentruyen(truyen.getString("TenT"));
                truyenmoinhat.setMatruyen(truyen.getInt("MaT"));
                truyens.add(truyenmoinhat);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return truyens;
    }

    public List<Truyen> getTruyenMoi() {
        List<Truyen> truyens=new ArrayList<>();
        String duongdan= MainActivity.Duongdan;
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","TruyenMoi");
        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);

        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            String truyenmoi=downloadJSON.get();
            Log.d("TruyenMoi", truyenmoi);

            JSONObject Jsonchuongmoinhat=new JSONObject(truyenmoi);
            JSONArray data=Jsonchuongmoinhat.getJSONArray("truyenmoi");
            int count=data.length();
            for (int i = 0; i < count; i++) {
                JSONObject truyen=data.getJSONObject(i);

                Truyen truyenmoinhat=new Truyen();
                truyenmoinhat.setTentruyen(truyen.getString("TenT"));
                truyenmoinhat.setMatruyen(truyen.getInt("MaT"));
                truyenmoinhat.setNoidung(truyen.getString("NoiDung"));
                truyenmoinhat.setAnh(truyen.getString("HinhTruyen"));
                truyens.add(truyenmoinhat);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return truyens;
    }

    public String getTapTruyenMoiNhat(int ma) {
        String taptruyenmoinhat="";
        String duongdan= MainActivity.Duongdan;
        HashMap<String,String> ham=new HashMap<>();
        ham.put("ham","getTapTruyenMoiNhat");
        HashMap<String,String> matruyen=new HashMap<>();
        matruyen.put("matruyen",String.valueOf(ma));
        List<HashMap<String,String>> hashMaps=new ArrayList<>();
        hashMaps.add(ham);
        hashMaps.add(matruyen);
        DownloadJSON downloadJSON=new DownloadJSON(duongdan,hashMaps);
        downloadJSON.execute();

        try {
            taptruyenmoinhat=downloadJSON.get();
            Log.d("TapTruyenMoiNhat", downloadJSON.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return taptruyenmoinhat;
    }
}
