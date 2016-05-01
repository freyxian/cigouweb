<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head><meta charset="utf-8" />
</head>
<body>
<H2>新增货物，定单编号：</H2>
<form:form action="order_input" method="post" modelAttribute="itemform">
  <input type="submit" name="NewItem" value="新建">
  <input type="submit" name="drop" value="放弃">
<table>
<tr><td><label  "货物编号" /></td><td><form:input  path="goodId" /></td></tr>
<tr><td><label  "数量" /></td><td><form:input  path="amount" /></td></tr>
<tr><td><label  "价格" /></td><td><form:input  path="price" /></td></tr>
</table>
</form:form>
</body>
</html>