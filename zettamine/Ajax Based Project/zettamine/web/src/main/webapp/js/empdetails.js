var xhr;
function getEmployeeDetails(empno){
	//alert(empno);
	xhr = new XMLHttpRequest();
	xhr.open("GET", "search?eno="+empno, true);
	xhr.onreadystatechange = stateChanged;
	xhr.send();
}

function stateChanged(){
	//alert(xhr.readyState);
	var ename = 'NO MATCH';
	var esal = 'NO MATCH';
	
	if(xhr.readyState == 4 && xhr.status==200){
		//get the response Text/ XML
		var respText = xhr.responseText;
		//alert(respText + "\n" + respText.length);
		if(respText.length > 0){
			var obj = JSON.parse(respText);
			//console.log(obj); 	
			ename = obj.ename;
			esal = obj.esal;
			
			//alert(ename+"\n"+esal);			
		}		
	}
	document.getElementById("empname").innerHTML = ename;
	document.getElementById("empsal").innerText = esal;
}