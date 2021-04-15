package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = sc.next();

		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.check(id);

		if (userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다");
			return;
		}
		
		userDAO.delete(id);
		System.out.println("데이터 삭제 완료");
	}
}
