package com.stagemate.store.service;

import static com.stagemate.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import com.stagemate.store.dao.StoreDao;
import com.stagemate.store.model.vo.Product;

public class StoreService {
	
	private StoreDao dao=new StoreDao();

	public List<Product> selectAllProduct(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<Product> list=dao.selectAllProduct(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public int selectProductCount() {
		Connection conn=getConnection();
		int result=dao.selectProductCount(conn);
		close(conn);
		return result;
	}

	public int updateProductLikeCnt(int productNo, int likeCnt) {
		Connection conn=getConnection();
		int result=dao.updateProductLikeCnt(conn,productNo,likeCnt);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Product> searchProductsByKeyword(int cPage, int numPerPage, String keyword) {
		Connection conn=getConnection();
		List<Product> list=dao.searchProductsByKeyword(conn,cPage,numPerPage,keyword);
		close(conn);
		return list;
	}

	public int searchProductsByKeywordCnt(String keyword) {
		Connection conn=getConnection();
		int result=dao.searchProductsByKeywordCnt(conn, keyword);
		close(conn);
		return result;
	}

}
