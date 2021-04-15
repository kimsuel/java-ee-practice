function checkLogin() {
	if (document.loginForm.id.value == "")
		alert("아이디를 입력하세요")
		else if (document.loginForm.pwd.value == "")
			alert("비밀번호를 입력하세요")
			else
				document.loginForm.submit()
}

function checkWrite() {
	if (document.writeForm.name.value == "")
		alert("이름을 입력하세요")
	else if (document.writeForm.id.value == "")
		alert("아이디를 입력하세요")
	else if (document.writeForm.pwd.value == "")
		alert("비밀번호를 입력하세요")
	else if (document.writeForm.pwd.value != document.writeForm.repwd.value)
		alert("비밀번호가 맞지 않습니다")
	else if(document.writeForm.id.value != document.writeForm.idChk.value )
		alert("아이디 중복체크 하세요")
	else
		document.writeForm.submit()
}

function checkId() {
	var sId = document.writeForm.id.value;
	if (sId == "")
		alert("먼저 아이디를 입력하세요");
	else
		window.open("checkId.jsp?id=" + sId, "",
				"width=300 height=100 location=yes");
}

function checkIdClose(id){
	opener.writeForm.id.value=id; // 아이디 전달
	// 열려있는 창 중에서 : opener
	opener.writeForm.idChk.value=id; // 아이디 중복체크 값에도 아이디 값 전달
	window.close(); // 창 닫기
	opener.writeForm.pwd.focus() // 비밀번호 창에 focus()
}


function checkModify() {
	if (document.modifyForm.name.value == ""){
		alert("이름을 입력하세요")
		document.modifyForm.name.focus()
	}else if(document.modifyForm.pwd.value == ""){
		alert("비밀번호를 입력하세요")
		document.modifyForm.pwd.focus()
	}else if (document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("비밀번호가 맞지 않습니다")
		document.modifyForm.pwd.value = ""
		document.modifyForm.repwd.value = ""
		document.modifyForm.pwd.focus()

	}else document.modifyForm.submit()
}

function checkPost(){
	window.open("checkPost.jsp","","width=400 height=400 scrollbars=yes");
}

function checkPostClose(zipcode,address){
		opener.document.getElementById('zipcode').value = zipcode; 
		opener.document.getElementById('addr1').value = address;
		window.close(); 
		opener.document.getElementById('addr2').focus() 
/*		
		opener.document.forms[0].zipcode.value = zipcode; 
		opener.document.forms[0].addr1.value = address;
		window.close(); 
		opener.document.forms[0].addr2.focus() 
*/
}
