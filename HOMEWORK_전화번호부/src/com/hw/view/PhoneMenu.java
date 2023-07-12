package com.hw.view;

import java.util.Scanner;

import com.hw.controller.PhoneController;

public class PhoneMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private PhoneController pc = new PhoneController();
	
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("\n == 전화번호부 프로그램 v1.0==");
			System.out.println("1.전화번호등록");
			System.out.println("2.전화번호검색");
			System.out.println("3.전화번호 모두 보기");
			System.out.println("4.종류");
			System.out.println("======================");
			
			System.out.print("메뉴 > ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: inputPhone();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: System.out.println("프로그램을 종료합니다.");
				break;
			default : System.out.println("메뉴를 잘못입력하였습니다. 다시 입력해주세요");
			}
			
		}
	}
	
	/**
	 * 전화번호를 추가하는 창
	 * 정보를 입력받아 회원 추가하는 창
	 */
	public void inputPhone() {
		System.out.println("\n==전화번호등록==");
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		pc.insertPhone(userName,age,address,phone);
	}
	
	//-------------------응답화면----------------------
	
	
	public void displaySuccess(String message) {
		System.out.println("\n 서비스 요청 성공 : "+message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : "+message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
