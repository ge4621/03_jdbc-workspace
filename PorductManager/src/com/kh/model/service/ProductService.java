package com.kh.model.service;

import java.sql.Connection;

import com.kh.model.vo.Product;

public class ProductService {
	
	public void insertProduct(Product pc) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
	}
	
}
