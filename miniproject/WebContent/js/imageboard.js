function checkAll() {
	var chk = document.getElementsByName("seq");
	// document.getElementsByName("seq").length 
	// : 현재 페이지에 있는 name의 개수만큼 숫자가 나옴
	if (document.getElementById("all").checked) {
		for (var i = 0; i < chk.length; i++)
			chk[i].checked = true; // 모두 체크
	} else {
		for (var i = 0; i < chk.length; i++)
			chk[i].checked = false; // 모두 해제
	}
}

function checkDelete(){
	//체크박스 체크여부 확인 [동일 이름을 가진 체크박스 여러개일 경우]
    var isChk = false;
    var arr = document.getElementsByName("seq");
    for(var i=0;i<arr.length;i++){
        if(arr[i].checked) {
            isChk = true;
            break;
        }
    }
    if(!isChk){
        alert("한개 이상 선택해주세요.");
        return false;
    }else{
    	document.imageboardList.submit();
    }
}

//AJax의 DOM 문법
function imgBigView(src){
	var newWindow = window.open("","","width=500, height=500");
	var img = newWindow.document.createElement("img");
	img.setAttribute("src",src)
	img.setAttribute("height","500");
	img.setAttribute("width","500");
	// img라는 태그를 만들고 그 안에 src,height,width를 넣어달라는 것
	// <img src="" height="500" width="500">
	newWindow.document.body.appendChild(img);
}

