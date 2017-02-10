package com.example.orlistarlib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/27 0027.
 * <p>
 * 显示选中的字母的标签的控件
 */

public class LabelView extends View {

    private Paint backgroundPaint;
    private Paint labelPaint;

    private int radius = 60;
    private String text;

    public LabelView(Context context) {
        this(context, null, 0);
    }

    public LabelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        backgroundPaint = new Paint();//绘制背景圆圈
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setColor(Color.parseColor("#88888888"));

        labelPaint = new Paint();//绘制选中的字母
        labelPaint.setAntiAlias(true);
        labelPaint.setTextSize(80);
        labelPaint.setColor(Color.WHITE);
    }

    public void setText(String text) {
        this.text = text;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (text != null) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, backgroundPaint);
            canvas.drawText(text,
                    getWidth() / 2 - labelPaint.measureText(text) / 2,
                    getHeight() / 2 + (labelPaint.descent() - labelPaint.ascent()) / 2 - labelPaint.descent(),
                    labelPaint);
        }

    }
}
