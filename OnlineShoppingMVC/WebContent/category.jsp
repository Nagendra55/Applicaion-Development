<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<body>
	<form method="get" action="category">
		<ul>
			<c:forEach items="${categories}" var="category">
				<li><c:out value="${category.getCategoryName()}" /></li>
			</c:forEach>
		</ul>
		<input type="text" name="categoryName" placeholder="Category Name">
		<input type="submit" value="Add">
	</form>
</body>
</html>
