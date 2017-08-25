package com.android.srx.github.designsupportlibrarydemo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DesignSupportLibraryDemo
 * Packege: com.android.srx.github.designsupportlibrarydemo.utils
 * File: StringGenerator
 * Created by sunrongxin on 2017/8/24 下午6:36.
 * Description: String Generator
 */

public class StringGenerator implements Generator<String> {

	private String preString;
	private int index = 0;

	public StringGenerator(String preString){
		this.preString = preString;
	}
	@Override
	public String next() {
		return preString+(index++);
	}

	public List<String> generate(int size){
		if(size<1){
			return null;
		}
		List<String> list = new ArrayList<>();
		for (int i=0;i<size;i++){
			list.add(next());
		}
		return list;
	}
}
