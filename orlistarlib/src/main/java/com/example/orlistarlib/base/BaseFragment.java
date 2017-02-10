package com.example.orlistarlib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.orlistarlib.R;
import com.example.orlistarlib.util.ScreenUtil;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentId(), container, false);
        //沉浸式状态栏
//        Activity activity = getActivity();
//        if (activity instanceof BaseActivity) {
//            BaseActivity baseActivity = (BaseActivity) activity;
//            if (baseActivity.isOpenStatus()) {
//                View actionBar = view.findViewById(R.id.actionbar);
//                if (actionBar != null) {
//                    int statusBarHeight = ScreenUtil.getStatusBarHeight(getContext());
//                    if (statusBarHeight != -1) {
//                        view.setPadding(0, statusBarHeight, 0, 0);
//                    }
//                }
//            }
//        }
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }

    protected <T> T findViewByIds(View view, int id) {
        return (T) view.findViewById(id);
    }

    protected void init(View view) {
    }

    protected abstract int getContentId();
}
