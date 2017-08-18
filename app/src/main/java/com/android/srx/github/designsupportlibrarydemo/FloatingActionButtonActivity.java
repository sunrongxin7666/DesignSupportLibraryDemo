package com.android.srx.github.designsupportlibrarydemo;

import android.animation.ObjectAnimator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FloatingActionButtonActivity extends AppCompatActivity {
	private FloatingActionButton btnFab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_floating_action_button);
		InitView();
	}

	private void InitView() {
		btnFab = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
		btnFab.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(FloatingActionButtonActivity.this, "Hello FAB!", Toast.LENGTH_SHORT).show();
				ObjectAnimator animator = ObjectAnimator.ofFloat(btnFab,"rotation",0f,360f);
				animator.setInterpolator(new FastOutLinearInInterpolator());
				animator.setDuration(1000).start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
