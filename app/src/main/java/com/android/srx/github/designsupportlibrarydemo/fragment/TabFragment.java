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
public class TabFragment extends android.support.v4.app.Fragment {


	private String words;
	private TextView mTextView;

	public TabFragment() {
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
		mTextView.setText(words);
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

}
