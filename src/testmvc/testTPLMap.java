package testmvc;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import CigouDAO.CDAO.OrderFetch;

public class testTPLMap {

	@Test
	public void test() {
		OrderFetch of=new OrderFetch();
		Map m=of.getTPLmap();
		System.out.println("Testing TPL &&&&&&&&&&&&&"+m.toString());
		fail("Not yet implemented");
	}

}
