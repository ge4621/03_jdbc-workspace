package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductContrpller {
	
	
	/**
	 * @param id :상품아이디
	 * @param name :상품명
	 * @param price : 가격
	 * @param dt :상세정보
	 * @param stock :재고수량
	 */
	public void insertProduct(String productId,String productName,String price,String dt,String stock) {
		
		Product pc = new Product(productId,productName,Integer.parseInt(price),dt,Integer.parseInt(stock));
		
		int result = new ProductService().insertProduct(pc);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공");
		}else {
			new ProductMenu().displayFail("실패");
		}
		
	}
	public void selectList() {
		
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoDate("조회된 정보가 없습니다.");
		}else {
			new ProductMenu().displayProductList(list);
		}
	}
	
	public void selectByProductName(String keyword) {
		ArrayList<Product> list = new ProductService().selectByProductName(keyword);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoDate(keyword+"에 해당하는 상품이 없습니다.");
		}else {
			new ProductMenu().displayProductList(list);
		}
		
	}
	
	public void deleteProdcut(String productId) {
		int result = new ProductService().deleteProduct(productId);
		
		if(result > 0) {
			new ProductMenu().displaySuccess(productId + "삭제완료");
		}else {
			new ProductMenu().displayFail("삭제 실패");
		}
	}
	
	public void updateProduct(String productId, String productName,String price,String dt,String  stock ) {
		
		Product pc = new Product(productId,productName,Integer.parseInt(price),dt,Integer.parseInt(stock));
//		pc.setProductId(productId);
//		pc.setProductName(productName);
//		pc.setPrice(price);
//		pc.setdescription(dt);
//		pc.setStock(stock);
		
		
		
		int result = new ProductService().updateProduct(pc);
		
		
		if(result > 0) {
			new ProductMenu().displaySuccess("상품정보 수정 성고");
		}else {
			new ProductMenu().displayFail("수정 실패");
		}
		
		
	}
	
}
