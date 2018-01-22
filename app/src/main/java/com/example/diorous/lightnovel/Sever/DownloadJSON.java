package com.example.diorous.lightnovel.Sever;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Diorous on 12/15/2017.
 */

public class DownloadJSON extends AsyncTask<String,Void,String>{
    private String duongdan;
    private List<HashMap<String,String>> hashMaps;
    private boolean method=true;
    public DownloadJSON(String duongdan){
        this.duongdan=duongdan;
        method=false;
    }

    public DownloadJSON(String duongdan,List<HashMap<String,String>> hashMaps){
        method=true;
        this.duongdan=duongdan;
        this.hashMaps=hashMaps;
    }
    @Override
    protected String doInBackground(String... strings) {
        String dulieu="";

        URL url= null;
        try {
            url = new URL(duongdan);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            if(method){
                dulieu=PhuongThucPost(httpURLConnection);
            }else {
                dulieu=PhuongThucGet(httpURLConnection);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dulieu;
    }


    private String PhuongThucPost(HttpURLConnection httpURLConnection) {
        String key="",value="",dulieu="";
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            OutputStream outputStream=httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            Uri.Builder builder=new Uri.Builder();
            int count=hashMaps.size();

            for (int i=0;i<count;i++){
                for(Map.Entry<String,String> stringStringMap:hashMaps.get(i).entrySet()){
                    key=stringStringMap.getKey();
                    value=stringStringMap.getValue();
                }
                builder.appendQueryParameter(key,value);
            }

            String ketqua=builder.build().getEncodedQuery();
            bufferedWriter.write(ketqua);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

            dulieu=PhuongThucGet(httpURLConnection);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dulieu;
    }

    private String PhuongThucGet(HttpURLConnection httpURLConnection){
        String dulieu="";
        try {
            httpURLConnection.connect();
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            String lane="";
            StringBuilder stringBuilder=new StringBuilder();
            while ((lane=bufferedReader.readLine())!=null){
                stringBuilder.append(lane);
            }

            dulieu=stringBuilder.toString();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dulieu;
    }
}
