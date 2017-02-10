package com.orlistar.daydaycookproject.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.orlistarlib.base.BaseActivity;
import com.example.orlistarlib.util.ScreenUtil;
import com.orlistar.daydaycookproject.R;
import com.orlistar.daydaycookproject.fragment.FindFragment;
import com.orlistar.daydaycookproject.fragment.MyFragment;
import com.orlistar.daydaycookproject.fragment.RecipeFragment;
import com.orlistar.daydaycookproject.fragment.SelectedFragment;
import com.orlistar.daydaycookproject.fragment.ShopFragment;

public class MainActivity extends BaseActivity {

    private ImageView iv_selected, iv_recipe, iv_find, iv_my, iv_shop;
    LinearLayout statusBar;

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        setupViews();
        LinearLayout.LayoutParams statusParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ScreenUtil.getStatusBarHeight(this));
        statusBar.setLayoutParams(statusParams);
        iv_selected.performClick();
    }

    public void clickNewFragment(View view) {
        switch (view.getId()) {
            case R.id.iv_selected: {
                showFragment(R.id.fragmentContainer, new SelectedFragment());
                iv_selected.setImageResource(R.drawable.home_btn_selected_active);
                iv_recipe.setImageResource(R.drawable.home_btn_recipe_default);
                iv_shop.setImageResource(R.drawable.home_btn_shop_default);
                iv_find.setImageResource(R.drawable.home_btn_find_default);
                iv_my.setImageResource(R.drawable.home_btn_my_default);
            }
            break;
            case R.id.iv_recipe: {
                showFragment(R.id.fragmentContainer, new RecipeFragment());
                iv_selected.setImageResource(R.drawable.home_btn_selected_default);
                iv_recipe.setImageResource(R.drawable.home_btn_recipe_active);
                iv_shop.setImageResource(R.drawable.home_btn_shop_default);
                iv_find.setImageResource(R.drawable.home_btn_find_default);
                iv_my.setImageResource(R.drawable.home_btn_my_default);
            }
            break;
            case R.id.iv_shop: {
                showFragment(R.id.fragmentContainer, new ShopFragment());
                iv_selected.setImageResource(R.drawable.home_btn_selected_default);
                iv_recipe.setImageResource(R.drawable.home_btn_recipe_default);
                iv_shop.setImageResource(R.drawable.home_btn_shop_active);
                iv_find.setImageResource(R.drawable.home_btn_find_default);
                iv_my.setImageResource(R.drawable.home_btn_my_default);
            }
            break;
            case R.id.iv_find: {
                showFragment(R.id.fragmentContainer, new FindFragment());
                iv_selected.setImageResource(R.drawable.home_btn_selected_default);
                iv_recipe.setImageResource(R.drawable.home_btn_recipe_default);
                iv_shop.setImageResource(R.drawable.home_btn_shop_default);
                iv_find.setImageResource(R.drawable.home_btn_find_active);
                iv_my.setImageResource(R.drawable.home_btn_my_default);
            }
            break;
            case R.id.iv_my: {
                showFragment(R.id.fragmentContainer, new MyFragment());
                iv_selected.setImageResource(R.drawable.home_btn_selected_default);
                iv_recipe.setImageResource(R.drawable.home_btn_recipe_default);
                iv_shop.setImageResource(R.drawable.home_btn_shop_default);
                iv_find.setImageResource(R.drawable.home_btn_find_default);
                iv_my.setImageResource(R.drawable.home_btn_my_activepng);
            }
            break;
        }
    }

    private void setupViews() {
        statusBar = findViewByIds(R.id.my_status_bar);
        iv_selected = findViewByIds(R.id.iv_selected);
        iv_recipe = findViewByIds(R.id.iv_recipe);
        iv_shop = findViewByIds(R.id.iv_shop);
        iv_find = findViewByIds(R.id.iv_find);
        iv_my = findViewByIds(R.id.iv_my);
    }

    long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 3000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
