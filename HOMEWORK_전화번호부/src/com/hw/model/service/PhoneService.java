package com.hw.model.service;

import java.sql.Connection;

import com.hw.common.JDBCTemplate;
import com.hw.model.dao.PhoneDao;
import com.hw.model.vo.Phone;

public class PhoneService {
	
	public int insertPhone(Phone p) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new PhoneDao().insertPhone(conn,p);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}
