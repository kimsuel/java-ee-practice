package user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();

		String columnName = null;
		String value = null;
		
		if (num == 1) {
			System.out.print("찾고자 하는 이름 입력 : ");
			value = sc.next();
			columnName = "name";
		} else if (num == 2) {
			System.out.print("찾고자 하는 아이디 입력 : ");
			value = sc.next();
			columnName = "id";
		}
		// DB
		Map<String,String> map = new HashMap<String,String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);

		// 응답
		System.out.println("이름\t아이디\t비밀번호\t");
		for (UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());

		}

		// 메소드 search() 1개만 사용
		// userMapper.xml에서도 <select> 하나만 사용
	}

}
