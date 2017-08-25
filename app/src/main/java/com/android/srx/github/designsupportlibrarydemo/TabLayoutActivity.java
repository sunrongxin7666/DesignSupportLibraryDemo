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
import android.util.Log;
import android.view.View;

import com.android.srx.github.designsupportlibrarydemo.fragment.TabBlankFragment;
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
				//Log.e(TAG, "onPageSelected: "+position);
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

		//设置配置器 ViewPager是ViewGroup
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

		//绑定
		mTabLayout.setupWithViewPager(mViewPager);

		//去掉ActionBar的渐进阴影
		//noinspection ConstantConditions
		getSupportActionBar().setElevation(0);
	}

	private void initData() {
		mTitles = new StringGenerator("title").generate(mSize);
		mWords = new StringGenerator("Fragment").generate(mSize);

		mFragments = new ArrayList<>();
		for (int i = 0; i < mSize; i++) {
			TabBlankFragment fragment = new TabBlankFragment();
			fragment.setTitle(mWords.get(i));
			mFragments.add(fragment);
		}
	}
}
