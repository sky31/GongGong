package com.sky31.gonggong.module.grade;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rey.material.widget.ProgressView;
import com.sky31.gonggong.R;
import com.sky31.gonggong.base.BaseActivity;
import com.sky31.gonggong.module.grade.details.DetailsFragment;
import com.sky31.gonggong.module.grade.rank.RankFragment;
import com.sky31.gonggong.module.grade.report.GradeReportFragment;
import com.sky31.gonggong.module.main.HomeViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GradeActivity extends BaseActivity {

    @Bind(R.id.pv_refresh)
    ProgressView pvRefresh;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tab_layout_grade)
    TabLayout tabLayoutGrade;
    @Bind(R.id.vp_grade)
    ViewPager vpGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //Fragment
        List<Fragment> mFragmentList = new ArrayList<>();
        GradeReportFragment gradeReportFragment = new GradeReportFragment();
        DetailsFragment detailsFragment = new DetailsFragment();
        RankFragment rankFragment = new RankFragment();
        mFragmentList.add(gradeReportFragment);
        mFragmentList.add(detailsFragment);
        mFragmentList.add(rankFragment);
        //ViewPager
        vpGrade.setOffscreenPageLimit(mFragmentList.size());
        HomeViewPagerAdapter mAdapter = new HomeViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpGrade.setAdapter(mAdapter);
        //TabLayout
        tabLayoutGrade.setupWithViewPager(vpGrade);
        tabLayoutGrade.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        //设置toolbar返回按钮
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //设置toolbar标题
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }
}
