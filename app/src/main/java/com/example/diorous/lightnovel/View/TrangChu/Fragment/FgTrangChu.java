package com.example.diorous.lightnovel.View.TrangChu.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diorous.lightnovel.Adapter.AdapterFgTrangChu;
import com.example.diorous.lightnovel.Presenter.TrangChu.PresenterLogicFgTrangChu;
import com.example.diorous.lightnovel.R;

/**
 * Created by Diorous on 12/10/2017.
 */

public class FgTrangChu extends Fragment{
    RecyclerView recyclerTrangChu;
    PresenterLogicFgTrangChu presenterLogicFgTrangChu;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_trangchu,container,false);

        presenterLogicFgTrangChu=new PresenterLogicFgTrangChu();

        recyclerTrangChu=view.findViewById(R.id.recyclertrangchu);

        LinearLayoutManager lineartrangchu=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerTrangChu.setLayoutManager(lineartrangchu);
        recyclerTrangChu.setHasFixedSize(true);

        AdapterFgTrangChu adapterFgTrangChu=new AdapterFgTrangChu(getActivity(),presenterLogicFgTrangChu);
        recyclerTrangChu.setAdapter(adapterFgTrangChu);
        adapterFgTrangChu.notifyDataSetChanged();
        return view;
    }
}
