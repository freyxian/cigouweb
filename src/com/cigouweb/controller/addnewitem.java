package com.cigouweb.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import CigouDAO.CDAO.OrderFetch;
import CigouDAO.CDAO.WholeOrder;

@Controller
@RequestMapping("/aaAddNewItem")
public class addnewitem {
	@RequestMapping(method=GET)
	public String HomeController(Map<String, Object> model){
		//initial empty form

		return "order_input";
	}
	
	@RequestMapping(method=POST)
	public String AddNewItem(Map<String, Object> model,HttpServletRequest request, 
	        HttpServletResponse response){
		//initial empty form
		itemForm item= new itemForm();
		item.setOrderId(request.getParameter("orderId"));
		item.setGoodId(request.getParameter("goodId"));
		item.setAmount(Integer.parseInt(request.getParameter("amount")));
		item.setPrice(Float.parseFloat(request.getParameter("price")));
		
		OrderFetch of=new OrderFetch();
		of.saveItem(item);
		
		WholeOrder wo =of.fetchWholeOrder(item.getOrderId());
		OrderInputForm myform=new OrderInputForm();
		myform.BindOrder(wo);
		
		String message="新货物成功加入！";
		model.put("message", message);

		model.put("oiform", myform);
		HashMap tplList=null;
		tplList=(HashMap) of.getTPLmap();
		model.put("tplList", tplList);
		return "order_input";
	}
}
