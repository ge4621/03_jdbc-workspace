package com.hw.controller;

import com.hw.model.service.PhoneService;
import com.hw.model.vo.Phone;
import com.hw.view.PhoneMenu;

public class PhoneController {

	public void insertPhone(String userName, String age, String address, String phone) {
		
		Phone p = new Phone(userName,Integer.parseInt(age),address,phone);
		
		int result = new PhoneService().insertPhone(p);
		
		if(result > 0) {
			new PhoneMenu().displaySuccess("등록 성공");
		}else {
			new PhoneMenu().displayFail("등록 실패");
		}
		
	}
	
}
