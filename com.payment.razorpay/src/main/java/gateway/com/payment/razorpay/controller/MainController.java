package gateway.com.payment.razorpay.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@RestController
public class MainController {

	@Autowired
	private Environment env;
	
	@GetMapping("/payment/createOrderId/{amount}")
	public String createOrderId(@PathVariable String amount) {
		String orderid = null;
		
		try {
		RazorpayClient razorpay = new RazorpayClient(env.getProperty("rzp_key_id"), env.getProperty("rzp_key_secret"));
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("amount", amount);
		jobj.put("currency",env.getProperty("rzp_currency") );
		jobj.put("receipt","order_rcptid_11" );
		
		Order order = razorpay.orders.create(jobj);
		
		orderid = order.get("id");
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return orderid;
	}
	
	
	
}
