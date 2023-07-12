package com.kh.view;

import java.util.Scanner;

import com.kh.controller.ProductContrpller;

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
			case 1 : inputProduct(); break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못입력하였습니다. 다시 입력해 주세요"); break;
			}
			
			
			
		}
		
		
	}
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
	
	
}
