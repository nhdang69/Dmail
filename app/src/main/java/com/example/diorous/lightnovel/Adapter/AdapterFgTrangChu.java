package com.example.diorous.lightnovel.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diorous.lightnovel.Model.Object.Truyen;
import com.example.diorous.lightnovel.Presenter.TrangChu.PresenterLogicFgTrangChu;
import com.example.diorous.lightnovel.R;

import java.util.List;

/**
 * Created by Diorous on 12/20/2017.
 */

public class AdapterFgTrangChu extends RecyclerView.Adapter<AdapterFgTrangChu.ViewHolder>{
    private List<Truyen> chuongmoinhat;
    private List<Truyen> sangtacnoibat;
    private List<Truyen> truyenmoi;
    private Context context;
    private PresenterLogicFgTrangChu presenterLogicFgTrangChu;
    public AdapterFgTrangChu(Context context, PresenterLogicFgTrangChu presenterLogicFgTrangChu){
        this.context=context;
        this.presenterLogicFgTrangChu=presenterLogicFgTrangChu;
        chuongmoinhat=presenterLogicFgTrangChu.getChuongMoi();
        sangtacnoibat=presenterLogicFgTrangChu.getSangTacNoiBat();
        truyenmoi=presenterLogicFgTrangChu.getTruyenMoi();
    }
    @Override
    public AdapterFgTrangChu.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.recycler_fg_trangchu,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterFgTrangChu.ViewHolder holder, int position) {

        GridLayoutManager gridchuongmoinhat=new GridLayoutManager(context,2, GridLayoutManager.HORIZONTAL,false);
        holder.recyclerChuongMoiNhat.setLayoutManager(gridchuongmoinhat);
        holder.recyclerChuongMoiNhat.setHasFixedSize(true);

        AdapterChuongMoiNhatvaNoiBat adapterChuongMoiNhatvaNoiBat=new AdapterChuongMoiNhatvaNoiBat(context,presenterLogicFgTrangChu,chuongmoinhat);
        holder.recyclerChuongMoiNhat.setAdapter(adapterChuongMoiNhatvaNoiBat);
        adapterChuongMoiNhatvaNoiBat.notifyDataSetChanged();

        LinearLayoutManager linersangtacnoibat=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerSangTacNoiBat.setLayoutManager(linersangtacnoibat);
        holder.recyclerSangTacNoiBat.setHasFixedSize(true);

        AdapterChuongMoiNhatvaNoiBat adapterSangTacNoiBat=new AdapterChuongMoiNhatvaNoiBat(context,presenterLogicFgTrangChu,sangtacnoibat);
        holder.recyclerSangTacNoiBat.setAdapter(adapterSangTacNoiBat);
        adapterSangTacNoiBat.notifyDataSetChanged();

        LinearLayoutManager lineartruyenmoi=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        holder.recyclerTruyenMoi.setLayoutManager(lineartruyenmoi);
        holder.recyclerTruyenMoi.setHasFixedSize(true);

        AdapterTruyenMoivaHotTrongThang adapterTruyenMoivaHotTrongThang=new AdapterTruyenMoivaHotTrongThang(context,presenterLogicFgTrangChu,truyenmoi);
        holder.recyclerTruyenMoi.setAdapter(adapterTruyenMoivaHotTrongThang);
        adapterTruyenMoivaHotTrongThang.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerChuongMoiNhat;
        private RecyclerView recyclerSangTacNoiBat;
        private RecyclerView recyclerTruyenMoi;
        public ViewHolder(View itemView) {
            super(itemView);
            recyclerChuongMoiNhat=itemView.findViewById(R.id.chuongmoinhat);
            recyclerSangTacNoiBat=itemView.findViewById(R.id.sangtacnoibat);
            recyclerTruyenMoi=itemView.findViewById(R.id.truyenmoi);
        }
    }
}
