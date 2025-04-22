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
	const revrate=document.getElementById("revrate").value;
	
			const table=document.getElementById("infoTable").getElementsByTagName('tbody')[0];
			const newRow=table.insertRow();
			
			const cell1=newRow.insertCell(0);
			const cell2=newRow.insertCell(1);
			const cell3=newRow.insertCell(2);
			const cell4=newRow.insertCell(3);
			
			cell1.textContent=bookname;
			const imageinput=document.createElement("img");
			imageinput.src=imageUrl;
			imageinput.width=100;
			imageinput.height=150;
			cell2.appendChild(imageinput)
			cell3.textContent=revrate;
			
			
	document.getElementById("myform").reset();
		closeForm();
}