package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	//추상메소드
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
	// servlet이 가지고 있는 request,response를 받는데
	// jsp 파일명이 필요하기 때문에 문자열로 받아옴
	
	// 에러가 많이 나기 때문에 Exception보다 위에 있는 Throwable을 걸어줌
}
