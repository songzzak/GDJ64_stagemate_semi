package com.stagemate.store.service;

import static com.stagemate.common.JDBCTemplate.close;
import static com.stagemate.common.JDBCTemplate.commit;
import static com.stagemate.common.JDBCTemplate.getConnection;
import static com.stagemate.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stagemate.common.JDBCTemplate;
import com.stagemate.store.dao.StoreDao;
import com.stagemate.store.model.vo.Cart;
import com.stagemate.store.model.vo.Product;
import com.stagemate.store.model.vo.StoreLike;
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
	        commit(conn);
	    }else {
	    	rollback(conn);
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

	public Product selectProductByProductNo(int pNo) {
		Connection conn= getConnection();
		Product p=dao.selectProductByProductNo(conn,pNo);
		close(conn);
		return p;
	}

	public List<StoreUpfile> selectFileByProductNo(int pNo) {
		Connection conn=getConnection();
		List<StoreUpfile> fileList=dao.selectFileByProductNo(conn,pNo);
		close(conn);
		return fileList;
	}

	public int updateProduct(Product product) {
		Connection conn=getConnection();
		int result=dao.updateProduct(conn, product);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int updateFileData(StoreUpfile mainImg, int productNo) {
		Connection conn=getConnection();
		int result=dao.updateFileData(conn, mainImg,productNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteProductByNo(int pNo) {
		Connection conn=getConnection();
		int result=dao.deleteProductByNo(conn, pNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int insertStoreLike(StoreLike sl) {
		Connection conn=getConnection();
		int result=dao.insertStoreLike(conn,sl);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteStoreLike(int productNo, String userId) {
		Connection conn=getConnection();
		int result=dao.deleteStoreLike(conn,productNo,userId);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<StoreLike> selectAllLike() {
		Connection conn=getConnection();
		List<StoreLike> fileList=dao.selectAllLike(conn);
		close(conn);
		return fileList;
	}

	public int insertCart(Cart c) {
		Connection conn=getConnection();
		int result=dao.insertCart(conn,c);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Cart> selectCartByUserId(String id) {
		Connection conn=getConnection();
		List<Cart> cartList=dao.selectCartByUserId(conn,id);
		close(conn);
		return cartList;
	}

	public List<Product> selectAllProductOrderBySort(int cPage, int numPerPage, String sort) {
		Connection conn=getConnection();
		List<Product> list=dao.selectAllProductOrderBySort(conn,cPage,numPerPage,sort);
		close(conn);
		return list;
	}

	public int deleteCart(int pNo, String id) {
		Connection conn=getConnection();
		int result=dao.deleteCart(conn, pNo,id);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<StoreLike> selectLikeById(String userId) {
		Connection conn=getConnection();
		List<StoreLike> list=dao.selectLikeById(conn,userId);
		close(conn);
		return list;
	}

	public int selectStoreLikeCountById(String userId) {
		Connection conn=getConnection();
		int result=dao.selectStoreLikeCountById(conn,userId);
		close(conn);
		return result;
	}
		
	// --------------------- jaehun ---------------------
	public Map<Product, String> selectProductAndFile() {
		Connection conn = JDBCTemplate.getConnection();
		Map<Product, String> products = dao.selectProductAndFile(conn);
		JDBCTemplate.close(conn);
		return products;
	}

}
