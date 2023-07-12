package com.kh.controller;

import com.kh.model.vo.Product;

public class ProductContrpller {
	
	
	/**
	 * @param id :상품아이디
	 * @param name :상품명
	 * @param price : 가격
	 * @param dt :상세정보
	 * @param stock :재고수량
	 */
	public void insertProduct(String id,String name,String price,String dt,String stock) {
		
		Product pc = new Product(id,name,Integer.parseInt(price),dt,Integer.parseInt(stock));
		
		int result = new ProductService().insertProduct(pc);
		
		if(result > 0) {
			//성공시 화면
		}else {
			//실패시 화면
		}
		
	}
	
}
