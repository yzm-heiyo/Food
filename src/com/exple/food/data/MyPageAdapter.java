package com.exple.food.data;

import android.support.v4.view.PagerAdapter;
import android.view.View;

public class MyPageAdapter extends PagerAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	// �����л���ʱ�����ٵ�ǰ�����
	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
	// ÿ�λ�����ʱ�����ɵ����
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
