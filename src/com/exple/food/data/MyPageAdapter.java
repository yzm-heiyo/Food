package com.exple.food.data;

import android.support.v4.view.PagerAdapter;
import android.view.View;

public class MyPageAdapter extends PagerAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	// 滑动切换的时候销毁当前的组件
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
	// 每次滑动的时候生成的组件
	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		return super.instantiateItem(container, position);
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
