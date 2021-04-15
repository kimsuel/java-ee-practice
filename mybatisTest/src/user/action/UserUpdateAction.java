package user.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 아이디 입력 : ");
		String id = sc.next();

		// DB
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.check(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다");
			return;
		}
		
		System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		//userDTO.setName(name);
		System.out.print("수정할 비밀번호 입력 : ");
		String pwd = sc.next();
		//userDTO.setPwd(pwd);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);

		//int su = userDAO.update(userDTO);
		userDAO.update(map);
		System.out.println("데이터 수정 완료");
	}

}
