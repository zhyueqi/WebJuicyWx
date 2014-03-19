package com.juicywx.service;

import java.sql.SQLException;
import java.util.List;

import com.juicywx.beans.Goods;
import com.juicywx.dao.GoodsDao;

public class GoodsService {
	private double mPageSize;// ÿҳ��ʾ����
	private int mPageCount;// ��ҳ��
	private GoodsDao mDao;

	public GoodsService(int pageSize) {
		mDao = new GoodsDao();
		mPageSize = pageSize;
	}

	// һ���ж�������¼
	public int pageCount() {

		try {
			mPageCount = mDao.goodsSize(GoodsDao.SALE_ON);

			double temp = mPageCount / mPageSize;

			mPageCount = (int) Math.ceil(temp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mPageCount;
	}

	/**
	 * 
	 * @param pageIndex
	 *            ��1��ʼ
	 * @return
	 */
	public List<Goods> page(int pageIndex) {
		List<Goods> list = null;
		int start = (int) ((pageIndex - 1) * mPageSize);
		int length = (int) mPageSize;
		try {
			list = mDao.goodsList(GoodsDao.SALE_ON, start, length);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public void addGoods(Goods goods){
		try {
			mDao.addGoods(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
