package com.cigouweb.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CigouDAO.CDAO.OrderFetch;
import CigouDAO.CDAO.WholeOrder;
import CigouDAO.cigoudb.HibernateUtil;
import CigouDAO.cigoudb.WhOrderItems;
import CigouDAO.cigoudb.WhOrderItemsHome;
import CigouDAO.cigoudb.WhOrderItemsId;
import CigouDAO.cigoudb.WhRefTplHome;

@Controller
@RequestMapping("/order_input")
public class order_input {

	@RequestMapping(method=GET)
	public String HomeController(Map<String, Object> model){
		//initial empty form
		OrderInputForm myform=new OrderInputForm();
		model.put("oiform", myform);
		OrderFetch of=new OrderFetch();
		HashMap tplList=new HashMap();
		tplList = (HashMap) of.getTPLmap();
		model.put("tplList",tplList);
		return "order_input";
	}
	
	//value="OrderSearch",method=POST
	//@RequestMapping(method=POST)
	@RequestMapping(method=POST, params = { "OrderSearch" })
	public ModelAndView processOrderSearch(@ModelAttribute("oiform") OrderInputForm myform) {
		String orderId=myform.getOrderId();
		String message=null;
		HashMap tplList=null;
		if(orderId==null||orderId.isEmpty()){
			message="请输入订单编号!";
		}else {
		OrderFetch ordf=new OrderFetch();
		WholeOrder wo =ordf.fetchWholeOrder(myform.getOrderId());
		
		if (wo==null){
			message="没有找到订单"+orderId+"!";
		}
		//after search, flash web page
		myform.BindOrder(wo);
		tplList=(HashMap) ordf.getTPLmap();
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("order_input");
		mv.addObject("oiform", myform);
		mv.addObject("tplList",tplList);
		mv.addObject("message",message);
		//return "order_input";
		return mv;
	}
	
	@RequestMapping(method=POST, params = { "NewOrder" })
	public ModelAndView processNewOrder(@ModelAttribute("oiform") OrderInputForm myform) {
		HashMap tplList=null;
		WholeOrder wo=myform.Form2Order();
		OrderFetch ordf=new OrderFetch();
		ordf.saveWholeOrder(wo);
		String message = "新订单"+myform.getOrderId()+"加入系统！";
		tplList=(HashMap) ordf.getTPLmap();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order_input");
		mv.addObject("oiform", myform);
		mv.addObject("tplList",tplList);
		mv.addObject("message",message);
		return mv;
	}

	@RequestMapping(method=POST, params = { "ModifyOrder" })
	public ModelAndView processModifyOrder(@ModelAttribute("oiform") OrderInputForm myform) {
		HashMap tplList=null;
		WholeOrder wo=myform.Form2Order();
		
		//first check if order exist
		//second check, if order confirmed
		
		OrderFetch of=new OrderFetch();
		of.replaceOrder(wo);

		//刷新订单数据，确认结果
		wo =of.fetchWholeOrder(myform.getOrderId());
		myform.BindOrder(wo);
		
		String message = "订单更改成功！";
		tplList=(HashMap) of.getTPLmap();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order_input");
		mv.addObject("oiform", myform);
		mv.addObject("tplList",tplList);
		mv.addObject("message",message);
		return mv;
	}

	@RequestMapping(method=POST, params = { "DeleteOrder" })
	public ModelAndView processDeleteOrder(@ModelAttribute("oiform") OrderInputForm myform) {

		OrderFetch of=new OrderFetch();
		of.deleteOrder(myform.getOrderId());
		
		String message = "订单"+myform.getOrderId()+"成功删除！";
		myform=new OrderInputForm();
		ModelAndView mv = new ModelAndView();
		HashMap tplList=new HashMap();
		tplList = (HashMap) of.getTPLmap();
		mv.setViewName("order_input");
		mv.addObject("oiform", myform);
		mv.addObject("tplList",tplList);
		mv.addObject("message",message);
		return mv;
	}
	
	@RequestMapping(method=POST, params = { "DeleteItems" })
	public ModelAndView processDeleteItems(@RequestParam("deleteItemIndex") String deleteItem,@ModelAttribute("oiform") OrderInputForm myform) {
		HashMap tplList=null;

		int index=Integer.parseInt(deleteItem);

		WhOrderItemsId item_id=new WhOrderItemsId();
		item_id.setGoodId(myform.getOrderItemList().get(index).getGoodId());
		item_id.setOrderId(myform.getOrderId());

		
		OrderFetch ordf=new OrderFetch();
		ordf.deleteItem(item_id);
		String message = "成功删除一条货物！";
		
		WholeOrder wo =ordf.fetchWholeOrder(myform.getOrderId());
		//after search, flash web page
		myform.BindOrder(wo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("oiform", myform);
		mv.setViewName("order_input");
		tplList = (HashMap) ordf.getTPLmap();
		mv.addObject("tplList",tplList);
		mv.addObject("message",message);

		return mv;
	}
	
}