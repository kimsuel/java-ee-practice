function checkBoardWrite(){
	if(document.boardWriteForm.subject.value == "")
		alert("제목을 입력하세요")
	else if(document.boardWriteForm.content.value == "")
		alert("내용을 입력하세요")
	else document.boardWriteForm.submit();
}

function isLogin(id,seq,pg){
	if(id == 'null'){
		alert("로그인하세요");
		location.href='../member/loginForm.jsp';
	}else{
		location.href='boardView.jsp?seq='+seq+'&pg='+pg;
	}
}
