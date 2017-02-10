package com.example.orlistarlib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/12/27 0027.
 * 侧边字母滑动控件
 */

public class SlideLabelView extends View {
    private String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 未被选中的标签的画笔
     */
    private Paint unCheckedLabel;
    /**
     * 被选中的标签的画笔
     */
    private Paint checkedLabel;

    /**
     * 当前选中的字母的下标
     */
    private int currentPos = -1;

    public interface OnSelectorListener {
        void select(String text, int position);

        void eventUp();
    }

    OnSelectorListener listener;

    public void setOnSelectorListener(OnSelectorListener listener) {
        this.listener = listener;
    }

    /**
     * 当自定义控件被new的时候调用
     *
     * @param context
     */
    public SlideLabelView(Context context) {
        this(context, null, 0);
    }

    /**
     * 当自定义控件以标签的形式写到布局上时，会调用这个构造方法
     *
     * @param context
     * @param attrs
     */
    public SlideLabelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 当自定义控件以标签的形式写到布局上，并且包含style属性时，调用
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SlideLabelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int textSize = (int) (screenHeight / labels.length * 0.65f);

        unCheckedLabel = new Paint();
        unCheckedLabel.setAntiAlias(true);
        unCheckedLabel.setColor(Color.parseColor("#88888888"));
        unCheckedLabel.setTextSize(textSize);

        checkedLabel = new Paint();
        checkedLabel.setAntiAlias(true);
        checkedLabel.setColor(Color.BLUE);
        checkedLabel.setTextSize(textSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getMeasureSize(widthMeasureSpec, 0);
        int height = getMeasureSize(heightMeasureSpec, 1);

        setMeasuredDimension(width, height);
    }

    /**
     * 对高度进行测量的方法
     *
     * @param spec 高度或者宽度的空间值
     * @param type 0-宽度，1-高度
     * @return
     */
    private int getMeasureSize(int spec, int type) {
        int mode = MeasureSpec.getMode(spec);
        int size = MeasureSpec.getSize(spec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                return size;

            case MeasureSpec.UNSPECIFIED:
                break;

            case MeasureSpec.AT_MOST: {
                switch (type) {
                    case 0: {
                        return (int) unCheckedLabel.measureText(labels[0]) + getPaddingLeft() + getPaddingRight();
                    }
                    case 1: {
                        return (int) ((unCheckedLabel.descent() - unCheckedLabel.ascent()) * labels.length) + getPaddingTop() + getPaddingBottom();
                    }
                }
            }
            break;
        }
        return -1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();//控件宽度

        for (int i = 0; i < labels.length; i++) {
            if (i == currentPos) {
                canvas.drawText(labels[i],
                        width / 2 - checkedLabel.measureText(labels[i]) / 2,//文本宽度
                        (checkedLabel.descent() - checkedLabel.ascent()) * (i + 1),//文本的高度
                        checkedLabel);
            } else {
                canvas.drawText(labels[i],
                        width / 2 - unCheckedLabel.measureText(labels[i]) / 2,//文本宽度
                        (unCheckedLabel.descent() - unCheckedLabel.ascent()) * (i + 1),//文本的高度
                        unCheckedLabel);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                touchLabel(event);
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                touchLabel(event);
            }
            break;
            case MotionEvent.ACTION_UP: {
                currentPos = -1;
                invalidate();
                if (listener != null) {
                    listener.eventUp();
                }
            }
            break;
        }
        return true;
    }

    private void touchLabel(MotionEvent event) {
        float clickY = event.getY();
        //当前点击的字母下标
        int index = (int) (clickY / (unCheckedLabel.descent() - unCheckedLabel.ascent()));
        //判断触摸的范围是否越界
        if (index < 0) {
            index = 0;
        }
        if (index >= labels.length) {
            index = labels.length - 1;
        }
        //触摸同一个字母时，只重绘一次
        if (currentPos != index) {
            currentPos = index;
            invalidate();
        }

        if (listener != null) {
            listener.select(labels[currentPos], currentPos);
        }
    }
}
