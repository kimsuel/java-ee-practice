function checkBoardWrite(){
	if(document.boardWriteForm.subject.value == "")
		alert("제목을 입력하세요")
	else if(document.boardWriteForm.content.value == "")
		alert("내용을 입력하세요")
	else document.boardWriteForm.submit();
}

function isLogin(id,seq,pg){
	if(id == ''){
		alert("로그인하세요");
		/*location.href='../main/index.do';*/
	}else{
		location.href='boardView.do?seq='+seq+'&pg='+pg;
	}
}

function checkBoardModify(){
	if(document.boardModifyForm.subject.value == "")
		alert("제목을 입력하세요")
	else if(document.boardModifyForm.content.value == "")
		alert("내용을 입력하세요")
	else document.boardModifyForm.submit();
}

function checkBoardReply(){
	if(document.boardReplyForm.subject.value == "")
		alert("제목을 입력하세요")
	else if(document.boardReplyForm.content.value == "")
		alert("내용을 입력하세요")
	else document.boardReplyForm.submit();
}

function checkSearch(){
	if(document.searchList.search.value == "")
		alert("찾을 내용을 입력하세요")
	else document.searchList.submit();
}