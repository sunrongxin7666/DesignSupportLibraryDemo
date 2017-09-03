package com.android.srx.github.designsupportlibrarydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Project: DesignSupportLibraryDemo
 * Packege: com.android.srx.github.designsupportlibrarydemo
 * File: ListAdapter
 * Created by sunrongxin on 2017/9/2 下午5:05.
 * Description: TODO
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
	private List<String> mList;
	private LayoutInflater mInflater;

	public ListAdapter(Context context, List<String> stringList){
		mList = stringList;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.list_item,parent,false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTextView.setText(mList.get(position));
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		public TextView mTextView;
		public ViewHolder(View itemView) {
			super(itemView);
			mTextView = (TextView) itemView.findViewById(R.id.textView);
		}
	}

}
