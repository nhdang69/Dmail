package com.example.diorous.lightnovel.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.example.diorous.lightnovel.R;

/**
 * Created by Diorous on 12/15/2017.
 */

public class CustomVisibleEdittext extends android.support.v7.widget.AppCompatEditText {

    Drawable dravisible,drainvisible,drawable;
    boolean kiemtra=false;
    boolean kiemtravalidate;

    public CustomVisibleEdittext(Context context) {
        super(context);
        khoitao(null);
    }

    public CustomVisibleEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoitao(attrs);
    }

    public CustomVisibleEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoitao(attrs);
    }

    private void khoitao(AttributeSet attributeSet) {
        if(attributeSet!=null){
            TypedArray typedArray=getContext().getTheme().obtainStyledAttributes(attributeSet,R.styleable.CustomVisibleEdittext,0,0);
            kiemtravalidate=typedArray.getBoolean(R.styleable.CustomVisibleEdittext_validatePassword,false);
        }
        dravisible=getContext().getDrawable(R.drawable.ic_visibility_black_24dp);
        drainvisible=getContext().getDrawable(R.drawable.ic_visibility_off_black_24dp);
        if(kiemtravalidate){
            this.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b){
                        String text=getText().toString();
                        if(text.toString().length()<6){
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setErrorEnabled(true);
                            textInputLayout.setError("Mật khẩu phải lớn hơn 5 ký tự");
                        }else {
                            TextInputLayout textInputLayout= (TextInputLayout) view.getParentForAccessibility();
                            textInputLayout.setError("");
                            textInputLayout.setErrorEnabled(false);
                        }
                    }
                }
            });
        }
        Caidat();
    }

    private void Caidat() {
        setInputType(InputType.TYPE_CLASS_TEXT|(kiemtra?InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable[] drawables=getCompoundDrawables();
        drawable=kiemtra?drainvisible:dravisible;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN &&getWidth()-event.getX()<=drawable.getBounds().width()){
            kiemtra=!kiemtra;
            Caidat();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(lengthAfter==0&&start==0){
            drawable=getContext().getDrawable(android.R.drawable.screen_background_light_transparent);
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }
}
