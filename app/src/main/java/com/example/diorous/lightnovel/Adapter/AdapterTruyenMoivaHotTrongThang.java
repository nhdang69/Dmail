package com.example.diorous.lightnovel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diorous.lightnovel.Model.Object.Truyen;
import com.example.diorous.lightnovel.Presenter.TrangChu.PresenterLogicFgTrangChu;
import com.example.diorous.lightnovel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Diorous on 12/21/2017.
 */

class AdapterTruyenMoivaHotTrongThang extends RecyclerView.Adapter<AdapterTruyenMoivaHotTrongThang.ViewHolDer>{
    private Context context;
    private List<Truyen> truyenmoi;
    public AdapterTruyenMoivaHotTrongThang(Context context, PresenterLogicFgTrangChu presenterLogicFgTrangChu, List<Truyen> truyenmoi) {
        this.context=context;
        this.truyenmoi=truyenmoi;
        int count=this.truyenmoi.size();
        for (int i = 0; i <count ; i++) {
            truyenmoi.get(i).setChuongtruyenmoinhat(presenterLogicFgTrangChu.getTapTruyenMoiNhat(truyenmoi.get(i).getMatruyen()));
        }
    }

    @Override
    public AdapterTruyenMoivaHotTrongThang.ViewHolDer onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_item_truyenmoi_hottrongthang,parent,false);
        ViewHolDer viewHolder=new ViewHolDer(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterTruyenMoivaHotTrongThang.ViewHolDer holder, int position) {
        Picasso.with(context).load(truyenmoi.get(position).getAnh()).into(holder.imgHinh);
        holder.txttentruyen.setText(truyenmoi.get(position).getTentruyen());
        holder.txtnoidungtruyen.setText(truyenmoi.get(position).getNoidung());
        Log.d("txtnoidungtruyen", holder.txtnoidungtruyen.getText().toString());
        holder.txtchuongtruyen.setText(truyenmoi.get(position).getChuongtruyenmoinhat());
    }

    @Override
    public int getItemCount() {
        return truyenmoi.size();
    }

    public class ViewHolDer extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txttentruyen,txtnoidungtruyen,txtchuongtruyen;
        public ViewHolDer(View itemView){
            super(itemView);
            imgHinh=itemView.findViewById(R.id.imgHinh);
            txttentruyen=itemView.findViewById(R.id.txttentruyen);
            txtnoidungtruyen=itemView.findViewById(R.id.txtnoidungtruyen);
            txtchuongtruyen=itemView.findViewById(R.id.txtchuongtruyen);
        }
    }
}
