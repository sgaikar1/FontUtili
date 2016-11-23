package com.appnirman.fontutils;

import android.content.Context;
import android.util.AttributeSet;

import com.appnirman.fontutils.fonts.FontUtils;


public class AutoCompleteTextView extends android.widget.AutoCompleteTextView {

    public AutoCompleteTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public AutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public AutoCompleteTextView init(AttributeSet attrs, int defStyle) {
        setWillNotDraw(false);

        FontUtils.getInstance(getContext())
                .load(this, attrs, defStyle);

        return this;
    }

    public void setFont(int fontFamilyResId, int style) {
        setFont(getResources().getString(fontFamilyResId), style);
    }

    public void setFont(String fontFamily, int style) {
        FontUtils.getInstance(getContext())
                .setTypeface(this, fontFamily, style);
    }

}
