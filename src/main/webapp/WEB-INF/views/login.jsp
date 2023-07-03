<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="pl">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>--%>
<%--    <title>Document</title>--%>
<%--    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="header-form.jsp"/>--%>


<%--<section class="login-page">--%>
<%--    <h2>Zaloguj się</h2>--%>
<%--    <form:form action="/login" modelAttribute="loginForm" method="post" class="padding-small text-center">--%>
<%--        <div class="form-group">--%>
<%--            <form:input class="form-control" path="email" id="email" placeholder="Email"/><br/>--%>
<%--            <form:errors path="email"/><br/>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <form:input class="form-control" path="password" id="password" type="Password" placeholder="Hasło"/><br/>--%>
<%--            <form:errors path="password"/><br/>--%>
<%--            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>--%>
<%--        </div>--%>
<%--        <div class="form-group form-group--buttons">--%>
<%--            <a href="/register" class="btn btn--without-border">Załóż konto</a>--%>
<%--            <button class="btn" type="submit">Zaloguj się</button>--%>
<%--        </div>--%>
<%--    </form:form>--%>
<%--</section>--%>
<%--<jsp:include page="footer.jsp"/>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header-form.jsp" %>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <c:if test="${not empty param.error}">
        <h3 style="color:red">
            Nie udało się zalogować, Spróbuj ponownie.<br /> Powód: <c:out
                value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
        </h3>
    </c:if>
    <form method="post" action="/login">
        <div class="form-group">
            <input type="email" name="username" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
            <a href="#" class="btn btn--small btn--without-border reset-password">Resetuj hasło</a> <%-- TODO href --%>
        </div>

        <div class="form-group form-group--checkbox">
            <label>
                <input type="checkbox" name="remember-me"/>
                <span class="checkbox"></span>
                <span class="description">Zapamiętaj mnie</span>
            </label>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</section>
<%@include file="footer.jsp" %>

<script src="/resources/js/app.js"></script>
</body>
</html>