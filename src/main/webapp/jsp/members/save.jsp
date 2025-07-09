<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thdwj
  Date: 25. 7. 8.
  Time: 오후 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.hello.helloservlet.member.MemberRepository" %>
<%@ page import="org.hello.helloservlet.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  // request, response 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));
  Member member = new Member(username, age);
  System.out.println("member = " + member);
  memberRepository.save(member);
%>
<html>
<head>
  <meta charset="UTF-8">
    <title>회원 등록 결과</title>
</head>
<body>
성공
<ul>
  <li>회원 id:<%=member.getId()%> </li>
    <li>회원 이름:<%=member.getUsername()%> </li>
</ul>

<c:url var="mainUrl" value="/index.html" />
<a href="${mainUrl}">메인</a>

</body>
</html>