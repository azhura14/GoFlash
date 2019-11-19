package com.example.goflash.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by PSB-BROO on 10/23/2017.
 */

public class MaterialDesignIconsTextView extends android.support.v7.widget.AppCompatTextView  {
    private static Typeface sMaterialDesignIcons;

    public MaterialDesignIconsTextView(Context context) {
        this(context, null);
    }

    public MaterialDesignIconsTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialDesignIconsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode()) return;//Won't work in Eclipse graphical layout
        setTypeface();
    }

    private void setTypeface() {
        if (sMaterialDesignIcons == null) {
//            sMaterialDesignIcons = Typeface.createFromAsset(getContext().getAssets(), "fonts/MaterialDesignIcons.ttf"); //old
            sMaterialDesignIcons = Typeface.createFromAsset(getContext().getAssets(), "fonts/MaterialIcons-Regular.ttf"); //new
        }
        setTypeface(sMaterialDesignIcons);
    }
}
