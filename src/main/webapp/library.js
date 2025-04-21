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
	const coverimage=document.getElementById("coverimage").value;
	const revrate=document.getElementById("revrate").files[0];
}