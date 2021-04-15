package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {
	private int seq;
	private String name, email, homepage, subject, content, logtime;
	
}
