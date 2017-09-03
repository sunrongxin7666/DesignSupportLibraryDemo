package com.android.srx.github.designsupportlibrarydemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.srx.github.designsupportlibrarydemo.fragment.ListFragment;
import com.android.srx.github.designsupportlibrarydemo.fragment.TabFragment;
import com.android.srx.github.designsupportlibrarydemo.utils.StringGenerator;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

	private ViewPager mViewPager;
	private TabLayout mTabLayout;
	private FloatingActionButton mActionButton;
	private final int mSize = 8;
	private List<String> mTitles;
	private List<String> mWords;
	private List<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		initView();
	}

	//初始Activity中的各种View
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabLayout = (TabLayout) findViewById(R.id.tabs);
		mActionButton = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
		mActionButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Snackbar.make(v, "Hello SnackBar!", Snackbar.LENGTH_SHORT)
						.setAction("Undo", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								// Perform anything for the action selected
							}
						})
						.show();
			}
		});
		initViewPager();
	}

	//初始化ViewPager
	private void initViewPager() {
		initData();

		//预加载
		mViewPager.setOffscreenPageLimit(mTitles.size()/2);

		//ViewPager滑动监听
		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				if(position==0){
					mActionButton.setVisibility(View.GONE);
				} else {
					mActionButton.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		//为ViewPager设置配置器,设定Fragment和title的关系
		//设置不同Fragment对应不同的Title
		mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return mFragments.get(position);
			}

			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return mTitles.get(position);
			}
		});

		//将ViewPage绑定到TabLayout
		mTabLayout.setupWithViewPager(mViewPager);

		//去掉ActionBar的渐进阴影
		//noinspection ConstantConditions
		getSupportActionBar().setElevation(0);
	}

	//初始化待显示的数据
	private void initData() {
		//初始化Tab标签
		mTitles = new StringGenerator("title").generateList(mSize);
		//初始化Fragment中显示提示词
		mWords = new StringGenerator("Fragment").generateList(mSize);

		//初始化待放入View中的Fragment
		mFragments = new ArrayList<>();
		for (int i = 0; i < mSize; i++) {
			if(i==0){
				mFragments.add(new ListFragment());
				continue;
			}
			TabFragment fragment = new TabFragment();
			fragment.setWords(mWords.get(i));
			mFragments.add(fragment);
		}
	}
}
