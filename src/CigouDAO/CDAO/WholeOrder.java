package CigouDAO.CDAO;

import java.util.ArrayList;
import java.util.List;

import CigouDAO.cigoudb.WhOrderHeader;
import CigouDAO.cigoudb.WhOrderItems;
import CigouDAO.cigoudb.WhOrderRecipient;

public class WholeOrder {
private	WhOrderHeader header;
private	WhOrderRecipient recipient;
private	List<WhOrderItems> items;

public WholeOrder(){
	this.header=new WhOrderHeader();
	this.recipient=new WhOrderRecipient();
	this.items=new ArrayList<WhOrderItems>();
}

public WhOrderHeader getHeader() {
	return header;
}
public void setHeader(WhOrderHeader header) {
	this.header = header;
}
public WhOrderRecipient getRecipient() {
	return recipient;
}
public void setRecipient(WhOrderRecipient recipient) {
	this.recipient = recipient;
	}
public List<WhOrderItems> getItems() {
	return items;
}
public void setItems(List<WhOrderItems> items) {
	this.items = items;
}

}
