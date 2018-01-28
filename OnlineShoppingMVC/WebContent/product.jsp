<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
 <body>
 <ul>
		<c:forEach items="${products}" var="product">
			<li><c:out value="${product.getProductName()}" /><br /></li>
		</c:forEach>
	</ul>
  <form method="get" action="product">
    <input type="text" name="productName" placeholder="Product Name"><br/>
	<input type="text" name="productPrice" placeholder="Product Price"><br/>
	<input type="text" name="productQuantity" placeholder="Product Quantity"><br/>
    <select name="companyId">
			<c:forEach items="${companies}" var="company">
				<option value="${company.getCompanyId()}"><c:out value="${company.getCompanyName()}"/>
	            </option>
			</c:forEach>
    </select><br/>
	<select name="categoryId">
			<c:forEach items="${categories}" var="category">
				<option value="${category.getCategoryId()}"><c:out value="${category.getCategoryName()}"/>
	            </option>
			</c:forEach>
	</select><br/>
    <select name="subCategoryId">
			<c:forEach items="${subcategories}" var="subcategory">
				<option value="${subcategory.getSubCategoryId()}"><c:out value="${subcategory.getSubCategoryName()}"/>
	            </option>
			</c:forEach>
	</select><br/>
	<input type="text" name="productDescription" placeholder="Product Description">
	<input type="submit" value="Add">
  </form>
 </body>
</html>
