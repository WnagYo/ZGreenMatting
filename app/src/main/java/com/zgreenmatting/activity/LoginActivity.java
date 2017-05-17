package com.zgreenmatting.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.zgreenmatting.BaseFragmentActivity;
import com.zgreenmatting.R;
import com.zgreenmatting.fragment.LoginFragment;
import com.zgreenmatting.fragment.RegisterFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseFragmentActivity {

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rg_login_register)
    RadioGroup rg_login_register;
    @BindView(R.id.rbtn_login)
    RadioButton rbtn_login;
    @BindView(R.id.rbtn_register)
    RadioButton rbtn_register;

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Fragment loginFragment;
    Fragment registerFragment;


    @Override
    protected int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void preInitData() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();
        fragments.add(loginFragment);
        fragments.add(registerFragment);
        viewpager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewpager.setAdapter(new LoginPagerAdapter(getSupportFragmentManager(), fragments));
        rg_login_register.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbtn_login.isChecked()){
                    tv_title.setText("登录");
                }else {
                    tv_title.setText("注册");
                }
            }
        });
    }

    @Override
    protected int getContentId() {
        return 0;
    }

    @Override
    protected void showFragment(String tag) {

    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageSelected(int arg0) {
            if (arg0==0){
                rbtn_login.setChecked(true);
            }else{
                rbtn_register.setChecked(true);
            }
        }
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageScrollStateChanged(int arg0) {
        }
    }

    public class LoginPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;
        public LoginPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }
    }
}