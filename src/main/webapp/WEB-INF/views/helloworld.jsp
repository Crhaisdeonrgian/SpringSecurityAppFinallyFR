<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false" %><html>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>Title</title>
</head>
<body>
<h1>HELLO, ${username}!</h1>
<h4>You've got roles: ${roles}</h4>
<p>Here you'll be able to buy stuff soon</p>
<br/>
<sec:authorize access='hasAuthority("ADMIN")'>
    Since you've got permission for it, you can go to:
<a href="/SpringSecurityAppFinallyFR_war_exploded/admin">ADMIN PAGE</a>
</sec:authorize>
<form:form action="logout" method = "POST">

    <input type="submit" value="logout(((">
</form:form>
</body>
</html>
