package com.android.srx.github.designsupportlibrarydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void gotoFAB(View view) {
		startActivity(new Intent(this,FloatingActionButtonActivity.class));
	}

	public void gotoSnackbar(View view) {
		startActivity(new Intent(this,SnackbarActivity.class));
	}

	public void gotoNavigationView(View view) {
		startActivity(new Intent(this,NavigationViewActivity.class));
	}

	public void gotoTabLayout(View view) {
		startActivity(new Intent(this,TabLayoutActivity.class));
	}

	public void gotoCoordinatorLayout(View view) {
		startActivity(new Intent(this,CoordinatorLayoutActivity.class));
	}
}
