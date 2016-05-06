<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head><meta charset="utf-8" />
<script src="/CigouWeb/js/jquery-1.12.3.min.js"></script>
<script src="/CigouWeb/js/jquery.leanModal.min.js"></script>
<style type="text/css">
	 #lean_overlay {
    position: fixed;
    z-index:100;
    top: 0px;
    left: 0px;
    height:100%;
    width:100%;
    background: #000;
    display: none;
}

#popupform {
  width: 300px;
  padding: 15px 20px;
  background: #f3f6fa;
  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;
  -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
  -moz-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.5);
}
       td.hidden {display: none;}
        .row-highlight
        {
            background-color: Yellow;
        }
</style>
<script type="text/javascript">
var pickedup;
$(document).ready(function(){
	$(function() {
    
        var tr = $('#itemTable tbody').find('tr');
        tr.bind('click', function(event) {
            var values = '';
            tr.removeClass('row-highlight');
            var tds = $(this).addClass('row-highlight').find('td');

                values = $(this).find("td.hidden").html();
                document.getElementById('deleteItemIndex').value =values;
        });
    });

	   $("#show_popup").leanModal({ top : 200, overlay : 0.4, closeButton: ".modal_close" });
	   
	   if(document.getElementById('confirmed').value=="true"){
		   $("#ModifyOrder").prop("disabled",true);
		   $("#DeleteOrder").prop("disabled",true);
		   $("#DeleteItems").prop("disabled",true);
		   $("#show_popup").prop("disabled",true);
	   }
	   
});
 </script>
</head>
<body>
<h2>报关订单查询修改</h2><br>

<div class="message" style="color:#ff4500">
<c:out value="${message}"/>
</div>

<form:form action="order_input" method="post" modelAttribute="oiform">
<input type="hidden" value="" id="deleteItemIndex" name="deleteItemIndex"/>
<form:input type="hidden" id="confirmed" path="confirmed"/>
  定单号:<form:input  path="orderId" /> 
  <input type="submit" name="OrderSearch" value="查询">
  <input type="submit" name="NewOrder" value="新建">
    <input type="submit" name="ModifyOrder" id="ModifyOrder" value="修改">
      <input type="submit" name="DeleteOrder" id="DeleteOrder" value="删除">
  <table style="width:80%"><tr>
  <td>日期：<form:input path="orderDate"/></td>
  <td>定货人：<form:input path="customerId"/></td>
   <td>包装材料:<form:input path="packingMaterial" /></td>
  </tr>
  <tr>
   <td>入货仓库:<form:input path="warehouseId"/></td>
  <td>物流商：  <form:select path="whRefTpl">
  <option disabled selected value> -- select an option -- </option>
    <form:options items="${tplList}" />
</form:select>
  </td>
  <td>定单类型：<form:input path="orderType"/></td>
  </tr>
  <tr><td>电商企业备案号:<form:input path="electriccode"/></td>
  <td>运单号:<form:input path="deliveryCode"/></td>
  <td>电商平台备案号:<form:input path="cbepcomcode"/></td>
  </tr>
  <tr>
  <td rowspan="2">备注：<form:input path="notes"/></td>
  </tr>
  </table>
  	<br>
收货人地址：<br>
<table style="width:80%">
<tr><td>姓名：<form:input path="name"/></td>
<td>收货方式：<form:input path="receiveType"/></td>
<td>收货号码：<form:input path="receiveNo"/></td>
</tr>

<tr><td>手机号：<form:input path="mobilePhone"/></td>
<td>电话：<form:input path="phone"/></td>
<td>国家：<form:input path="country"/></td></tr>

<tr><td>省份：<form:input path="province"/></td>
<td>城市：<form:input path="city"/></td>
<td>地区：<form:input path="district"/></td>
</tr>

<tr>
<td>地址：<form:input path="address"/></td>
<td>邮编：<form:input path="postcode"/></td></tr>
</table>
 
<br>货物目录：     
  <input type="submit" name="DeleteItems" id="DeleteItems" value="删除货物">
 <input type="button" href="#popupform" id="show_popup" value="新增货物">
<br>
<table id="itemTable" style="width:80%" border="1"> 
  <thead><tr>
    <th>货物编号</th>
    <th >数量</th>
        <th >价格</th>
 </tr> </thead>
  <tbody>
  <c:forEach items="${oiform.orderItemList}" var="item" varStatus="status">
<tr>


<td class="hidden" id="itemIndex">${status.index}</td>
<td><input type="text" name="orderItemList[${status.index}].goodId" value="${item.goodId}" ></td>
<td><input type="text" name="orderItemList[${status.index}].amount" value="${item.amount}" ></td>
<td><input type="text" name="orderItemList[${status.index}].price" value="${item.price}" ></td>

</tr>
</c:forEach>
</tbody>
</table>

</form:form> 
   <div id = "popupform" style="display:none;">
 		<div id="signup-ct"> 
				<div id="signup-header">
					
					<p>报关订单${oiform.orderId}增加报关货物</p>
					<a class="modal_close" href="#"></a>
				</div>
				
				<form action="aaAddNewItem" method="post">
     <input type="hidden" value="${oiform.orderId}" id="orderId" name="orderId"/>
				    <label for="">货物编号</label>
				    <input id="goodId" class="good_input" name="goodId" type="text" />
					<br>
				    <label for="">数量</label>
				    <input id="amount" name="amount" type="text" />
				    <br>
				    <label for="">价格</label>
				    <input id="price" name="price" type="text" />
					<br>
				  <div class="btn-fld">
				  <button type="submit">提交 &raquo;</button>
					</div>
				 </form>
			</div>
        </div>
</body>
</html>