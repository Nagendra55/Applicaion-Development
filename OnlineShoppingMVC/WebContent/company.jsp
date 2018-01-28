<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Document</title>
</head>
<body>
	<form method="get" action="company">
		<ul>
			<c:forEach items="${companies}" var="company">
				<li><c:out value="${company.getCompanyName()}"/></li>
				<br/>
			</c:forEach>
		</ul>
		<input type="text" name="companyName" placeholder="Company name">
		<input type="submit" value="Add">
	</form>
</body>
</html>
