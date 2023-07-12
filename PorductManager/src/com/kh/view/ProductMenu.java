package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductContrpller;
import com.kh.model.vo.Product;

public class ProductMenu {
		
	private Scanner sc = new Scanner(System.in);
	private ProductContrpller pc = new ProductContrpller();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("\n==상품 관련 프로그램==");
			System.out.println("1.전체조회 하기");
			System.out.println("2.상품 추가 하기");
			System.out.println("3.상품 수정 하기(상품id로 조회하고 수정) : ");
			System.out.println("4.상품 삭제 하기(상품id로 조회해서 삭제) : ");
			System.out.println("5.상품 검색해기(상품이름으로 키워드 검색) : ");
			System.out.println("0.프로그램 종료하기");
			
			System.out.print(">>메뉴 선택 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 : pc.selectList(); break;
			case 2 : inputProduct(); break;
			case 3 : updateProduct(); break;
			case 4 : pc. deleteProdcut(inputProductId());
						break;
			case 5 : pc.selectByProductName(inputProductName());
				break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못입력하였습니다. 다시 입력해 주세요"); break;
			}
			
			
			
		}
		
		
	}
	
	
	public void updateProduct() {
		System.out.println("\n==상품수정하기==");
		
		String productId = inputProductId();
		
		System.out.print("변경할 상품이름 : ");
		String productName = sc.nextLine();
		
		System.out.print("변경할 상품 가격 : ");
		String price = sc.nextLine();
		
		System.out.print("변경할 상품의 상세 정보 : ");
		String dt = sc.nextLine();
		
		System.out.print("변경할 상훔의 재고 : ");
		String stock = sc.nextLine();
		
		pc.updateProduct(productId, productName, price,dt, stock);
	}
	
	public String inputProductId() {
		System.out.print("상품 아이디 입력 : ");
		return sc.nextLine();
	}
	
	public String inputProductName() {
		System.out.print("\n상품 이름 입력 (키워드) : ");
		return sc.nextLine();
	}
	
	
	
	
	
	
	
	
	/**
	 * 상품 추가 창
	 */
	public void inputProduct() {
		
		System.out.println("\n==상품 추가 등록==");
		System.out.print("상품 아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("삼품명 : ");
		String name = sc.nextLine();
		
		System.out.print("상품가격 : ");
		String price = sc.nextLine();
		
		System.out.print("상품상세정보 : ");
		String dt = sc.nextLine();		//상세정보
		
		System.out.print("재고 : ");
		String stock = sc.nextLine();	//재고
		
		pc.insertProduct(id,name,price,dt,stock);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 서비스 요청 처리후 성공했을때 사용자가 보게될 화면
	 * @param message
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스 요청 처리후 실패 했을 때 사용자가 보게될 화면
	 * @param message
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회 서비스 요청시 조회 결과가 없을 경우 사용자가 보게될 화면
	 * @param message
	 */
	public void displayNoDate(String message) {
		System.out.println(message + "\n");
	}
	
	/**
	 * 조회서비스 요청시 조회결과가 여러행일 경우 사용자가 보게될 화면
	 * @param list
	 */
	public void displayProductList(ArrayList<Product> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		
		for(Product pc : list) {
			System.out.println(pc);
		}
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 한행 일 경우 사용자가 보게 될 화면
	 * @param pc
	 */
	public void displayProduct(Product pc) {
		System.out.println("\n 조회된 정보는 다음과 같습니다.");
		System.out.println(pc);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
