<%-- 
    Document   : interceptador para adm
    Created on : 14/05/2014, 14:54:19
    Author     : Rafael Kozar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:choose>
    <c:when test="${sessionScope.user == null}">
        <jsp:forward page="index.jsp"/>         
    </c:when>  
    <c:when test="${sessionScope.user.tipo == 'user'}">
        <jsp:forward page="index.jsp"/>         
    </c:when> 
    <c:otherwise>
        
    </c:otherwise>                   
</c:choose> 