package com.android.srx.github.designsupportlibrarydemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.android.srx.github.designsupportlibrarydemo.R;
import com.android.srx.github.designsupportlibrarydemo.databinding.ActivityCoordinatorLayoutBinding;
import com.android.srx.github.designsupportlibrarydemo.utils.StringGenerator;

public class CoordinatorLayoutActivity extends AppCompatActivity {
	private ActivityCoordinatorLayoutBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this,R.layout.activity_coordinator_layout);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		initView();
	}

	private void initView() {
		mBinding.collapsingToolbar.setTitle("Design");
		mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
		mBinding.recyclerView.setAdapter(
				new ListAdapter(this, new StringGenerator("Item ").generateList(50)));
	}


}
