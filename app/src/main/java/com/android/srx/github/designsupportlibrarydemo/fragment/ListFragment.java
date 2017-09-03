package com.android.srx.github.designsupportlibrarydemo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.srx.github.designsupportlibrarydemo.ListAdapter;
import com.android.srx.github.designsupportlibrarydemo.R;
import com.android.srx.github.designsupportlibrarydemo.utils.StringGenerator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.Fragment {

	RecyclerView mRecyclerView;

	public ListFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_list,null);
		findView(view);
		return view;
	}

	private void findView(View view) {
		mRecyclerView = (RecyclerView) view.findViewById(R.id.list_in_frag);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		mRecyclerView.setAdapter(new ListAdapter(getContext(),new StringGenerator("Item ").generateList(50)));
	}

}
