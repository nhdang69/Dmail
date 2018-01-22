package com.example.diorous.lightnovel.Helper;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by Diorous on 12/10/2017.
 */

public class BottomNaVigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void DisableShiflmode(BottomNavigationView view){
        BottomNavigationMenuView bottomNavigationMenuView= (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiflmode=bottomNavigationMenuView.getClass().getDeclaredField("mShiftingMode");
            shiflmode.setAccessible(true);
            shiflmode.setBoolean(bottomNavigationMenuView,false);
            shiflmode.setAccessible(false);
            int count=bottomNavigationMenuView.getChildCount();
            for (int i = 0; i <count ; i++) {
                BottomNavigationItemView bottomNavigationItemView= (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i);
                bottomNavigationItemView.setShiftingMode(false);
                bottomNavigationItemView.setChecked(bottomNavigationItemView.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
