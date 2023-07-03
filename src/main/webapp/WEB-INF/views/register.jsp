<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="header-form.jsp"/>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" modelAttribute="registerForm" method="post" class="padding-small text-center">
    <div class="form-group">
        <form:input class="form-group" path="email" id="email" placeholder="Email"/><br/>
        <form:errors path="email"/>
    </div>
        <div class="form-group">
            <form:input class="form-group" path="firstName" id="firstName" placeholder="Imię"/><br/>
            <form:errors path="firstName"/>
        </div>
        <div class="form-group">
            <form:input class="form-group" path="lastName" id="lastName" placeholder="Nazwisko"/><br/>
            <form:errors path="lastName"/>
        </div>
        <div class="form-group">
            <form:password class="form-group" path="password" id="password" placeholder="Hasło"/><br/>
            <form:errors path="password"/>
        </div>
        <div class="form-group">
            <form:password class="form-group" path="confirmedPassword" id="confirmedPassword" placeholder="Powtórz hasło"/><br/>
            <form:errors path="confirmedPassword"/>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>