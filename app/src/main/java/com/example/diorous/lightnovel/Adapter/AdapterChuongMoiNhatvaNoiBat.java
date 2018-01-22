package com.example.diorous.lightnovel.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diorous.lightnovel.Model.Object.Truyen;
import com.example.diorous.lightnovel.Presenter.TrangChu.PresenterLogicFgTrangChu;
import com.example.diorous.lightnovel.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Diorous on 12/20/2017.
 */

public class AdapterChuongMoiNhatvaNoiBat extends RecyclerView.Adapter<AdapterChuongMoiNhatvaNoiBat.ViewHolder>{

    private List<Truyen> truyens;
    private Context context;
    public AdapterChuongMoiNhatvaNoiBat(Context context, PresenterLogicFgTrangChu presenterLogicFgTrangChu, List<Truyen> truyens){

        this.context=context;
        this.truyens=truyens;
        int count=this.truyens.size();
        for (int i = 0; i <count ; i++) {
             truyens.get(i).setAnh(presenterLogicFgTrangChu.getAnh(truyens.get(i).getMatruyen()));
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_item_chuongmoinhat_noibat,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txttentruyen.setText(truyens.get(position).getTentruyen());
        if(!truyens.get(position).getAnh().equals(""))
        {
            Picasso.with(context).load(truyens.get(position).getAnh()).into(holder.imgHinh);
        }
    }

    @Override
    public int getItemCount() {
        return truyens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txttentruyen;
        ImageView imgHinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txttentruyen=itemView.findViewById(R.id.txttentruyen);
            imgHinh=itemView.findViewById(R.id.imgHinh);
        }
    }
}
