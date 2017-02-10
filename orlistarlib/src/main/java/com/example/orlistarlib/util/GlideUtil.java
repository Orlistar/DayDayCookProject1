package com.example.orlistarlib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class GlideUtil {
    /**
     * 封装 Glide加载图片
     *
     * @param imgUrl
     * @param iv
     */
    public static void setImgByGlide(Context context, String imgUrl, ImageView iv) {
        Glide.with(context.getApplicationContext())
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(iv);
    }

    /**
     * 封装Glide加载圆形图片
     *
     * @param context
     * @param imgUrl
     * @param iv
     */
    public static void setRoundImgByGlide(final Context context, String imgUrl, final ImageView iv) {
        Glide.with(context.getApplicationContext().getApplicationContext())
                .load(imgUrl)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }
}
