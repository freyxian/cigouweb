package CigouDAO.CDAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.cigouweb.controller.itemForm;

import CigouDAO.cigoudb.HibernateUtil;
import CigouDAO.cigoudb.WhOrderConfirm;
import CigouDAO.cigoudb.WhOrderConfirmHome;
import CigouDAO.cigoudb.WhOrderHeader;
import CigouDAO.cigoudb.WhOrderHeaderHome;
import CigouDAO.cigoudb.WhOrderItems;
import CigouDAO.cigoudb.WhOrderItemsHome;
import CigouDAO.cigoudb.WhOrderItemsId;
import CigouDAO.cigoudb.WhOrderRecipient;
import CigouDAO.cigoudb.WhOrderRecipientHome;
import CigouDAO.cigoudb.WhRefTpl;
import CigouDAO.cigoudb.WhRefTplHome;

public class OrderFetch {
public	WholeOrder fetchWholeOrder(String orderid){
	WholeOrder wo=new WholeOrder();
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderHeaderHome whh = new WhOrderHeaderHome(); 
	WhOrderHeader wh = whh.findById(orderid);
	if (wh==null) {
		wo=null;
		return wo;
	}
	wo.setHeader(wh);
	
	WhOrderRecipientHome wrh=new WhOrderRecipientHome();
	WhOrderRecipient wr=wrh.findById(orderid);
	wo.setRecipient(wr);
	
	WhOrderItemsHome wih=new WhOrderItemsHome();
	List<WhOrderItems> lwi=wih.findByOrderID(orderid);
	wo.setItems(lwi);
	
	session.getTransaction().commit();
	
	return wo;
}

public void saveWholeOrder(WholeOrder wo){
	wo.getHeader().setWhOrderRecipient(wo.getRecipient());
	Set<WhOrderItems> mySet = new HashSet<WhOrderItems>(wo.getItems());
	wo.getHeader().setWhOrderItemses(mySet);
	mySet.addAll(wo.getItems());
	wo.getRecipient().setWhOrderHeader(wo.getHeader());
	System.out.println("############ Save Item size is: "+mySet.size()); 
//	WhOrderHeaderHome wohh = new WhOrderHeaderHome();
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
 
	session.save(wo.getHeader());
	session.save(wo.getRecipient());
	for(WhOrderItems item:mySet){
		System.out.println("############ Save Item"+item.getId().getGoodId()); 
		item.setWhOrderHeader(wo.getHeader());
		session.save(item);
	}
	
	session.getTransaction().commit();
//	session.close();
}

public void deleteItem(WhOrderItemsId woitem){
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderItemsHome home=new WhOrderItemsHome();
	System.out.println(woitem.getOrderId()+"&&&&%%%%%%%&&"+woitem.getGoodId());
	WhOrderItems me=home.findById(woitem);
	System.out.println("&&&&&&&&&&&&&&&&"+me.toString());
	home.delete(me);
	session.getTransaction().commit();
}

public void saveItem(itemForm woitem){
	WhOrderItemsId wid=new WhOrderItemsId();
	wid.setGoodId(woitem.getGoodId());
	wid.setOrderId(woitem.getOrderId());
	WhOrderItems item=new WhOrderItems();
	item.setId(wid);
	item.setAmount(woitem.getAmount());
	item.setPrice(woitem.getPrice());
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	session.save(item);
	session.getTransaction().commit();
//	session.close();
}

public Map getTPLmap(){
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhRefTplHome tplh=new WhRefTplHome();
	HashMap m = new HashMap();
	for(WhRefTpl tpl : tplh.findAll()) m.put(tpl.getTpl(), tpl.getTplName());
	session.getTransaction().commit();
//	session.close();
	
	return m;
}

public void deleteOrder(String orderid){
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderItemsHome home=new WhOrderItemsHome();
	//System.out.println(woitem.getOrderId()+"&&&&%%%%%%%&&"+woitem.getGoodId());
	for (WhOrderItems me:home.findByOrderID(orderid)) home.delete(me);
	
	WhOrderRecipientHome worh=new WhOrderRecipientHome();
	WhOrderRecipient wor=worh.findById(orderid);
	worh.delete(wor);
	
	WhOrderHeaderHome wohh = new WhOrderHeaderHome();
	WhOrderHeader woh=wohh.findById(orderid);
	wohh.delete(woh);
	
	session.getTransaction().commit();
}

public void replaceOrder(WholeOrder wo){
	String orderid=wo.getHeader().getOrderId();
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderItemsHome home=new WhOrderItemsHome();
	
	//delete old orders
	//System.out.println(woitem.getOrderId()+"&&&&%%%%%%%&&"+woitem.getGoodId());
	for (WhOrderItems me:home.findByOrderID(orderid)) home.delete(me);
	
	WhOrderRecipientHome worh=new WhOrderRecipientHome();
	WhOrderRecipient wor=worh.findById(orderid);
	worh.delete(wor);
	
	WhOrderHeaderHome wohh = new WhOrderHeaderHome();
	WhOrderHeader woh=wohh.findById(orderid);
	wohh.delete(woh);
	
	//save new order info
	session.save(wo.getHeader());
	session.save(wo.getRecipient());
	for(WhOrderItems item:wo.getItems()){
		session.save(item);
	}
	
	session.getTransaction().commit();
}
public	WhOrderHeader findOrder(String orderid){
	WhOrderHeader wo=new WhOrderHeader();
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderHeaderHome whh = new WhOrderHeaderHome(); 
	
	wo = whh.findById(orderid);
	session.getTransaction().commit();
	
	return wo;
}

public	boolean confirmedOrder(String orderid){
	WhOrderConfirm wo=new WhOrderConfirm();
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	WhOrderConfirmHome whh = new WhOrderConfirmHome(); 
	
	
	wo = whh.findById(orderid);
	session.getTransaction().commit();
	if (wo==null) {		
		return false;
	}
	
	return true;
}
}

