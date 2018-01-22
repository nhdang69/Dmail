package com.example.diorous.lightnovel.Presenter.TrangChu;

import com.example.diorous.lightnovel.Model.Object.Truyen;
import com.example.diorous.lightnovel.Model.TrangChu.XuLyFgTrangChu;
import com.example.diorous.lightnovel.Presenter.DangNhapDangKy.PresenterLogicDangNhapDangKy;

import java.util.List;

/**
 * Created by Diorous on 12/20/2017.
 */

public class PresenterLogicFgTrangChu implements PresenterIFgTrangChu {
    XuLyFgTrangChu xuLyFgTrangChu;
    public PresenterLogicFgTrangChu(){
        xuLyFgTrangChu=new XuLyFgTrangChu();
    }
    @Override
    public List<Truyen> getChuongMoi() {
        List<Truyen> chuongmoi=xuLyFgTrangChu.getChuongMoiNhat();
        return chuongmoi;
    }

    @Override
    public List<Truyen> getSangTacNoiBat() {
        List<Truyen> sangtacnoibat=xuLyFgTrangChu.getSangTacNoiBat();
        return sangtacnoibat;
    }

    @Override
    public List<Truyen> getTruyenMoi() {
        List<Truyen> truyenmoi=xuLyFgTrangChu.getTruyenMoi();
        return truyenmoi;
    }


    public String getAnh(int ma){
        return xuLyFgTrangChu.getAnh(ma);
    }

    public String getTapTruyenMoiNhat(int matruyen) {
        return xuLyFgTrangChu.getTapTruyenMoiNhat(matruyen);
    }
}
