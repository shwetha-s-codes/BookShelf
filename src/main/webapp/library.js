function openForm()
{
	document.getElementById("popupForm").style.display="block";
}

function closeForm()
{
	document.getElementById("popupForm").style.display="none";
}
function addToTable()
{
	const bookname=document.getElementById("name").value;
	const coverimage=document.getElementById("coverimage");
	const image=coverimage.files[0];
	const imageUrl=URL.createObjectURL(image);
	const author=document.getElementById("author").value;
	const rating=document.getElementById("rating").value;
	
			const table=document.getElementById("infoTable").getElementsByTagName('tbody')[0];
			const newRow=table.insertRow();
			
			const cell1=newRow.insertCell(0);
			const cell2=newRow.insertCell(1);
			const cell3=newRow.insertCell(2);
			const cell4=newRow.insertCell(3);
			const cell5=newRow.insertCell(4);
			
			cell1.textContent=bookname;
			
			const imageinput=document.createElement("img");
			imageinput.src=imageUrl;
			imageinput.width=100;
			imageinput.height=150;
			cell2.appendChild(imageinput)
			
			cell3.textContent=author;
			cell4.textContent=rating;
			
			const editbtn=document.createElement("button");
			editbtn.textContent="Edit";
			editbtn.className="edit-btn";
			editbtn.style.border="2px solid black";
			editbtn.style.marginRight="4px";
			editbtn.style.marginLeft="2px";
						
			
			const delbtn=document.createElement("button");
			delbtn.textContent="Delete";
			delbtn.className="del-btn";
			delbtn.style.border="2px solid black";
			
			
			
			
							
			
			cell5.appendChild(editbtn);
			cell5.appendChild(delbtn);
			
			
	document.getElementById("myform").reset();
		closeForm();
}