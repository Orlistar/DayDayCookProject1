package com.example.orlistarlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.orlistarlib.R;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class LetterSlidingView extends FrameLayout {

    private SlideLabelView slideLabelView;
    private LabelView labelView;

    public LetterSlidingView(Context context) {
        this(context, null, 0);
    }

    public LetterSlidingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterSlidingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     * inflate(R.layout.xxx, null)
     * -> 直接将 R.layout.xxx 所对应的布局文件转换成为一个布局对象，该布局对象不会保留layout_开头的属性
     * <p>
     * .inflate(R.layout.xxx, this, false)
     * -> 直接将 R.layout.xxx 所对应的布局文件转换成为一个布局对象，该布局对象会保留layout_开头的属性
     * <p>
     * .inflate(R.layout.xxx, this, true)
     * ->将 R.layout.xxx 所对应的布局文件转化成一个布局对象，并且将该布局对象添加到第二个参数所表示的容器中
     */
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.letter_sliding_view, this, true);
        slideLabelView = (SlideLabelView) findViewById(R.id.slideLabelView);
        labelView = (LabelView) findViewById(R.id.labelView);

        slideLabelView.setOnSelectorListener(new SlideLabelView.OnSelectorListener() {
            @Override
            public void select(String text, int position) {
                labelView.setText(text);
                if (onSelectorListener != null) {
                    onSelectorListener.select(text, position);
                }
            }

            @Override
            public void eventUp() {
                labelView.setText(null);
            }
        });
    }

    public interface OnSelectorListener {
        void select(String text, int position);
    }

    private OnSelectorListener onSelectorListener;

    public OnSelectorListener getOnSelectorListener() {
        return onSelectorListener;
    }

    public void setOnSelectorListener(OnSelectorListener onSelectorListener) {
        this.onSelectorListener = onSelectorListener;
    }
}
