package user.main;

import java.util.Scanner;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSearchAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;

public class UserMain {
	public void menu() {
		Scanner sc = new Scanner(System.in);
		UserAction action = null;
		int num;

		while(true) {
			System.out.println("********");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 검색");
			System.out.println("6. 종료");
			System.out.println("********");
			
			System.out.print("번호입력 : ");
			num = sc.nextInt();
			
			if(num==6) break;
			if(num==1) action = new UserInsertAction();
			else if(num==2) action = new UserSelectAction();
			else if(num==3) action = new UserUpdateAction();
			else if(num==4) action = new UserDeleteAction();
			else if(num==5) action = new UserSearchAction();
			
			action.execute(); // 호출
		}
	}
	
	public static void main(String[] args) {
		new UserMain().menu();
		System.out.println("프로그램을 종료합니다");
	}
}
