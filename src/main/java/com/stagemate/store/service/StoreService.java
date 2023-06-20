package com.stagemate.store.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stagemate.store.dao.StoreDao;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreUpfile;

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

	public Map<String, Integer> insertProduct(Product product) {
	    Connection conn = getConnection();
	    int result = dao.insertProduct(conn, product);
	    int pNo = 0; 
	    if (result > 0) {
	        pNo = dao.selectSeqCurrval(conn);
	    }
	    close(conn);
	    Map<String, Integer> resultMap = new HashMap<>();
	    resultMap.put("result", result);
	    resultMap.put("pNo", pNo);
	    return resultMap;
	}

	public int insertFileData(StoreUpfile mainImg, int pNo) {
		Connection conn=getConnection();
		int result=dao.insertFileData(conn,mainImg,pNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<StoreUpfile> selectAllFile() {
		Connection conn=getConnection();
		List<StoreUpfile> files=dao.selectAllFile(conn);
		close(conn);
		return files;
	}


}
