var xhrObject;
function startMethod(){
	xhrObject = new XMLHttpRequest();
	xhrObject.onreadystatechange = resultProcess;
	xhrObject.open("GET","ajaxExam02.xml",true);
	xhrObject.send(null);
}

function processXML(){
	var xmlDoc = xhrObject.responseXML;
	var subject="";
	var trTag = "";
	var tdTag = "";
	var subjects = xmlDoc.getElementsByTagName("subject");
	
	for(var i=0; i<subjects.length;i++){
		trTag = document.createElement("tr");
		subject = subjects[i];
		var child = subject.childNodes;
		
		for(var j=0; j<child.length;j++){
			tdTag = document.createElement("td");
			if(child[j].firstChild.nodeValue != null){
				// 공백도 자식노드로 인식하기 때문에 null이 아닌 값만 출력
				var text = document.createTextNode(child[j].firstChild.nodeValue);
			}
			
			tdTag.appendChild(text);
			trTag.appendChild(tdTag);
		} // for j
		document.getElementById("resultDisplay").appendChild(trTag);
	} // for i 
}

function resultProcess(){
	if(xhrObject.readyState == 4){
		if(xhrObject.status == 200){
			processXML();
		}
	}
}