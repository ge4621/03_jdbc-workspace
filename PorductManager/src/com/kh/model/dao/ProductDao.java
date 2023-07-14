package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Product;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertProduct(Connection conn , Product pc) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProduct");
				//"INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pc.getProductId());
			pstmt.setString(2, pc.getProductName());
			pstmt.setInt(3, pc.getPrice());
			pstmt.setString(4, pc.getdescription());
			pstmt.setInt(5, pc.getStock());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Product> selectList (Connection conn){
		ArrayList<Product> list = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
				//"SELECT * FROM PRODUCT";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getString("PRODUCT_ID"),
									rset.getString("P_NAME"),
									rset.getInt("PRICE"),
									rset.getString("DESCRIPTION"),
									rset.getInt("STOCK")
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
	
	
	
	public ArrayList<Product> selectByProductName(Connection conn, String keyword){
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByProductName");
				//"SELECT * FROM PRODUCT WHERE P_NAME LIKE ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,"%"+keyword+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getString("PRODUCT_ID"),
										rset.getString("P_NAME"),
										rset.getInt("PRICE"),
										rset.getString("DESCRIPTION"),
										rset.getInt("STOCK")
									));
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int deleteProduct(Connection conn, String productId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
				//"DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productId);
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
			
		
	}
	public int updateProduct(Connection conn , Product pc) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct"); 
				//"UPDATE PRODUCT SET PRODUCT_ID = ?, P_NAME = ?,PRICE = ?,DESCRIPTION =?, STOCK=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pc.getProductName());
			pstmt.setInt(2, pc.getPrice());
			pstmt.setString(3, pc.getdescription());
			pstmt.setInt(4, pc.getStock());
			pstmt.setString(5, pc.getProductId());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
		
	}
	public Product selectByProductId(Connection conn, String productId) {
		Product pc = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByProductId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pc = new Product(rset.getString("PRODUCT_ID"),
										rset.getString("P_NAME"),
										rset.getInt("PRICE"),
										rset.getString("DESCRIPTION"),
										rset.getInt("STOCK"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pc;
	}
	
	
	
}

