package com.hw.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hw.common.JDBCTemplate;
import com.hw.model.vo.Phone;

public class PhoneDao {
	
	public int insertPhone(Connection conn, Phone p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSTER INTO PHONE VALUES(SEQ_NO.NEXTVAL,?,?,?,?)";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "homework", "homework");
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, p.getUserName());
			pstmt.setInt(2, p.getAge());
			pstmt.setString(3, p.getAddress());
			pstmt.setString(4, p.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}
	
	
	
}
