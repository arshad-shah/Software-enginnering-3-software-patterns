<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Edit Item</title>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
	<script
	  src="https://code.jquery.com/jquery-3.4.1.min.js"
	  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	  crossorigin="anonymous"></script>
	<script type="text/javascript"
	    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
  </head>
  <body>
    <c:set var="item" value="${sessionScope.item}" />
    <div class="signUpContainer">
      <h1>Inventory management System</h1>
      <form class="signUpForm" id="editItem" action="FrontController" method="post">
        <h1 class="formHeading">Edit Item</h1>
        <input type="hidden" name="itemid" value="${item.itemId}" />
        <input
          class="input"
          name="itemName"
          size="18"
          type="text"
          value="${item.itemName}"
          placeholder="Item name"
        />
        <input
          class="input"
          name="itemDesc"
          size="18"
          type="text"
          value="${item.itemDesc}"
          placeholder="Item Description"
        />
        <input
          class="input"
          name="itemPrice"
          size="18"
          type="number"
          value="${item.itemPrice}"
          placeholder="Item Price"
        />
        <input
          class="input"
          name="itemQuantity"
          size="18"
          type="number"
          value="${item.itemQuantity}"
          placeholder="Item Quantity"
        />
        <input
          class="input"
          name="itemCategory"
          size="18"
          type="text"
          value="${item.itemCategory}"
          placeholder="Item Category"
        />
        <input
          class="input"
          name="itemSupplier"
          size="18"
          type="text"
          value="${item.itemSupplier}"
          placeholder="Item Supplier"
        />

        <div class="loginFormButtons">
          <input type="hidden" name="action" value="UpdateItem" />
          <input class="button" type="submit" value="Update" />
        </div>
      </form>
    </div>
    
    
      <script type="text/javascript">
 
    $(document).ready(function() {
        $("#editItem").validate({
            rules: {
            	itemName: "required",
                itemDesc: "required",
                itemPrice: "required",
                itemQuantity: "required",
                itemCategory: "required",
                itemSupplier: "required",
            },
             
            messages: {
            	itemName: "Name of the Item is required",
                itemDesc: "Description of item is required",
                itemPrice: "Price of item is required",
                itemQuantity: "Quantity of item is required",
                itemCategory: "Category of item is required",
                itemSupplier: "Supplier of item is required",
            }
        });
 
    });
</script>
  </body>
</html>
