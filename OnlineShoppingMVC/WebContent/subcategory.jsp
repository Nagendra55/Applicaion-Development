<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<body>
	<ul>
		<c:forEach items="${subcategories}" var="subcategory">
			<li><c:out value="${subcategory.getSubCategoryName()}" /><br /></li>
		</c:forEach>
	</ul>
	<form method="get" action="subcategory">
		<input type="text" name="subCategoryName"
			placeholder="Sub Category Name"> <input type="submit"
			value="Add"><br /> <br /> <select name="categoryId">
			<c:forEach items="${categories}" var="category">
				<option value="${category.getCategoryId()}"><c:out value="${category.getCategoryName()}"/>
	   </option>
			</c:forEach>
		</select>
	</form>
</body>
</html>
