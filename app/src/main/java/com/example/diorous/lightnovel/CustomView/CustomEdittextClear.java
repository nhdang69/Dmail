package com.example.diorous.lightnovel.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.example.diorous.lightnovel.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diorous on 12/15/2017.
 */

public class CustomEdittextClear extends android.support.v7.widget.AppCompatEditText{
    Drawable imgclear,imgnoneclear,drawable;
    boolean kiemtra=false;
    boolean kiemtraemail=false;
    boolean kiemtratext=false;
    public CustomEdittextClear(Context context) {
        super(context);
        KhoiTao(null);
    }

    public CustomEdittextClear(Context context, AttributeSet attrs) {
        super(context, attrs);
        KhoiTao(attrs);
    }

    public CustomEdittextClear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        KhoiTao(attrs);
    }

    private void KhoiTao(AttributeSet attributeSet){
        setInputType(InputType.TYPE_CLASS_TEXT);
        if(attributeSet!=null){
            TypedArray typedArray=getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomEdittextClear,0,0);
            kiemtraemail=typedArray.getBoolean(R.styleable.CustomEdittextClear_validateEmail,false);
            kiemtratext=typedArray.getBoolean(R.styleable.CustomEdittextClear_validateText,false);
        }

        imgclear= getContext().getDrawable(R.drawable.ic_clear_black_24dp);
        imgnoneclear=getContext().getDrawable(android.R.drawable.screen_background_light_transparent);
        if(kiemtratext){
            this.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b){
                        String text= getText().toString();
                        if(text.equals("")){
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setErrorEnabled(true);
                            textInputLayout.setError("mục này không được để trống");
                        }else {
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setError("");
                            textInputLayout.setErrorEnabled(false);
                        }

                    }
                }
            });
        }

        if(kiemtraemail){
            this.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b){
                        String text= getText().toString();
                        Pattern pattern= Patterns.EMAIL_ADDRESS;
                        Matcher matcher=pattern.matcher(text);
                        if(!matcher.matches()){
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setErrorEnabled(true);
                            textInputLayout.setError("Không đúng định dạng email");
                        }else {
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setError("");
                            textInputLayout.setErrorEnabled(false);
                        }
                    }
                }
            });
        }
        caidat();
    }

    private void caidat() {

        Drawable[] drawables=getCompoundDrawables();
        drawable=kiemtra?imgclear:imgnoneclear;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1], drawable,drawables[3]);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP && event.getX()>=(getRight()-drawable.getBounds().width())){
            setText("");
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(lengthAfter==0&&start==0){
            kiemtra=false;
            caidat();
        }else {
            kiemtra=true;
            caidat();
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

}
