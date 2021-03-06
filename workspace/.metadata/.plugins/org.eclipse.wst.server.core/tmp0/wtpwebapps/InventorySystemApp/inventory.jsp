<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Inventory</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
	<script src="https://unpkg.com/feather-icons"></script>
  </head>

  <body>
    <c:set var="user" value="${sessionScope.user}" />
    <c:set var="maxItemId" value="${sessionScope.maxItemId}" />
    <div class="inventoryHeader">
    <h1>Inventory</h1>
    <h3><b>Hello <c:out value="${user}" /></b></h3>
    	<b>What would you like to do?</b>
    </div>
    <div class="actionButtons">
	    <form action="FrontController" method="post">
	      <input type="hidden" name="action" value="LogoutUser" />
	      <input class="button" type="submit" value="Logout" />
	    </form>
	
	    <form action="FrontController" method="post">
	      <input type="hidden" name="action" value="AddItemClick" />
	      <input class="button" type="submit" value="AddItem" />
	    </form>
	</div>
	<input class="searchinput" type="text" id="myInput" onkeyup="searchFunction()" placeholder="Search for item names.." title="Type in a name">
    <!-- fill out the table with the inventory from sessionScope -->
    <table border="1" id="myTable">
      <tr>
        <th>Item ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Supplier</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${sessionScope.inventory.getInventory()}" var="item">
        <tr>
          <td>${item.itemId}</td>
          <td>${item.itemName}</td>
          <td>${item.itemDesc}</td>
          <td>${item.itemPrice} EUR</td>
          <td>${item.itemQuantity} </td>
          <td>${item.itemCategory}</td>
          <td>${item.itemSupplier}</td>
          <td >	 
          <div class="iconButtons">
	         <form action="FrontController" class="buttonForm" method="post">
	          	 <input type="hidden" name="itemid" value="${item.itemId}"/>
			     <input type="hidden" name="action" value="GetItem" />
			     <button class="iconbutton" type="submit"><i data-feather="edit"></i></button>
			  </form>
		
		    <form action="FrontController" class="buttonForm" method="post">
		      <input type="hidden" name="action" value="DeleteItem" />
		      <input type="hidden" name="itemid" value="${item.itemId}"/>
		      <button class="iconbutton" type="submit"><i data-feather="trash-2"></i></button>
		    </form>
		    
          </div>   
		  </td>
        </tr>
      </c:forEach>
      <!-- end of forEach -->
    </table>
    
    <!-- Duplicate buttons if the number of items is greater than 15 -->
        <c:if test="${maxItemId > 15 }">
	       <div class="actionButtons">
			    <form action="FrontController" method="post">
			      <input type="hidden" name="action" value="LogoutUser" />
			      <input class="button" type="submit" value="Logout" />
			    </form>
			
			    <form action="FrontController" method="post">
			      <input type="hidden" name="action" value="AddItemClick" />
			      <input class="button" type="submit" value="AddItem" />
			    </form>
			</div>
        </c:if>
	<script>
      feather.replace()
    </script>
    
    <script>
		function searchFunction() {
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
			  console.log(tr.length);
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
	</script>

  </body>
</html>
