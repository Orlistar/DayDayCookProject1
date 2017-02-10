package com.orlistar.daydaycookproject.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.orlistar.daydaycookproject.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by Administrator on 2017/2/4 0004.
 */

public class PullToRefreshHeadView extends FrameLayout implements PtrUIHandler {

    private ImageView img;
    private AnimationDrawable anim;

    public PullToRefreshHeadView(Context context) {
        this(context, null, 0);
    }

    public PullToRefreshHeadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullToRefreshHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        img = new ImageView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 20, 20);
        params.gravity = Gravity.CENTER;
        this.addView(img, params);
        img.setImageResource(R.drawable.loading_anim);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        anim = (AnimationDrawable) img.getDrawable();
        anim.start();
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        anim.stop();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

    }
}
