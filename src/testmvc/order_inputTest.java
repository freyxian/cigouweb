package testmvc;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.cigouweb.controller.order_input;

public class order_inputTest {
@Test
public void order_inputTest() throws Exception
{
	order_input oi = new order_input();
	MockMvc mockmvc=standaloneSetup(oi).build();
	mockmvc.perform(get("/")).andExpect(view().name("order_input"));
}
}
