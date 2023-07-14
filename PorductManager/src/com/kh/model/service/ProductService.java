package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;

public class ProductService {
	
	public int insertProduct(Product pc) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ProductDao().insertProduct(conn, pc);
		
		if(result > 0){
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
		
	}
	
	public ArrayList<Product> selectList(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new ProductDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Product> selectByProductName(String keyword){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new ProductDao().selectByProductName(conn,keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
		
		
			}
		
		
	public int deleteProduct (String productId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ProductDao().deleteProduct(conn,productId);
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int updateProduct(Product pc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ProductDao().updateProduct(conn,pc);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public Product selectByProductId(String productId) {
		Connection conn = JDBCTemplate.getConnection();
		Product pc = new ProductDao().selectByProductId(conn, productId);
		
		JDBCTemplate.close(conn);
		
		return pc;
				
		
	}
	
	
}
