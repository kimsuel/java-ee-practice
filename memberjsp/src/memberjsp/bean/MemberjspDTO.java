package memberjsp.bean;

import lombok.Data;

@Data
public class MemberjspDTO {
	private String name, id, pwd, gender, email1, email2;
	private String tel1, tel2 ,tel3, zipcode, addr1, addr2;
}
