package com.android.srx.github.designsupportlibrarydemo.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.srx.github.designsupportlibrarydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabBlankFragment extends android.support.v4.app.Fragment {


	private String title;
	private TextView mTextView;

	public TabBlankFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tab,null);
		findView(view);
		return view;
	}

	private void findView(View view) {
		mTextView = (TextView) view.findViewById(R.id.tv_in_tab_fragment);
		mTextView.setText(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
