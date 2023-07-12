package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Product;

public class ProductDao {
	
	public int insertProduct(Connection conn , Product pc) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		
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
		
		String sql = "SELECT * FROM PRODUCT";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getString("productId"),
									rset.getString("productName"),
									rset.getInt("price"),
									rset.getString("description"),
									rset.getInt("stock")
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
		
		String sql = "SELECT * FROM PRODUCT WHERE P_NAME LIKE ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,"%"+keyword+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getString("productId"),
									rset.getString("productName"),
									rset.getInt("price"),
									rset.getString("description"),
									rset.getInt("stock")
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
		
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productId);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
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
		
		String sql = "UPDATE PRODUCT SET PRODUCT_ID = ?, P_NAME = ?,PRICE = ?,DESCRIPTION =?, STOCK=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pc.getProductId());
			pstmt.setString(2, pc.getProductName());
			pstmt.setInt(3, pc.getPrice());
			pstmt.setString(4, pc.getdescription());
			pstmt.setInt(5, pc.getStock());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
		
	}
	
	
	
}

