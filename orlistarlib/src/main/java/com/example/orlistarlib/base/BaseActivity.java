package com.example.orlistarlib.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.orlistarlib.R;
import com.example.orlistarlib.util.ScreenUtil;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment existedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());
        fragmentManager = getSupportFragmentManager();
        existedFragment = new Fragment();
        //开启沉浸式状态栏
        if (isOpenStatus()) {
            //沉浸式状态栏
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }

            View view = findViewByIds(R.id.actionbar);
            if (view != null) {
                int statusBarHeight = ScreenUtil.getStatusBarHeight(this);
                if (statusBarHeight != -1) {
                    view.setPadding(0, statusBarHeight, 0, 0);
                }
            }
        }
        init();
        loadDatas();
    }

    /**
     * 显示Fragment
     *
     * @param frameLayoutId
     * @param fragment
     */
    protected void showFragment(int frameLayoutId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //检测当前是否有显示的Fragment，如果有，则隐藏
        if (existedFragment != null) {
            transaction.hide(existedFragment);
        }
        //判断需要显示的Fragment是否已经创建过，如果有，则显示
        Fragment fragmentByTag = fragmentManager.findFragmentByTag(fragment.getClass().getName());
        if (fragmentByTag != null) {
            transaction.show(fragmentByTag);
        } else {
            //如果没有，则add
            fragmentByTag = fragment;
            transaction.add(frameLayoutId, fragmentByTag, fragment.getClass().getName());
        }
        existedFragment = fragmentByTag;
        transaction.commit();
    }

    protected void loadDatas() {
    }

    protected void init() {
    }

    protected abstract int getContentId();

    protected <T> T findViewByIds(int id) {
        return (T) findViewById(id);
    }

    /**
     * 是否开启沉浸式状态栏
     *
     * @return
     */
    protected boolean isOpenStatus() {
        return true;
    }
}
