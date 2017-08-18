package com.android.srx.github.designsupportlibrarydemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SnackbarActivity extends AppCompatActivity {

	private FloatingActionButton btnFab;
	private CoordinatorLayout layoutRoot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snackber);
		setupUI();
	}

	private void setupUI() {

		layoutRoot = (CoordinatorLayout) findViewById(R.id.layoutRoot);
		btnFab = (FloatingActionButton) findViewById(R.id.btnFloatingAction);
		btnFab.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Snackbar.make(layoutRoot, "Hello SnackBar!", Snackbar.LENGTH_SHORT)
						.setAction("Undo", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								// Perform anything for the action selected
							}
						})
						.show();
			}
		});
	}
}
