package gateway.com.payment.razorpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SimpleController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value={"/payment"}, method = RequestMethod.GET)
	public String payment(Model model) {
		
		model.addAttribute("rzp_key_id", env.getProperty("rzp_key_id"));
		model.addAttribute("rzp_currency",env.getProperty("rzp_currency"));
		model.addAttribute("rzp_company_name",env.getProperty("rzp_company_name"));
		
	return 	"payment";
	}
	
	
	@GetMapping("/pay")
	public String pay(Model model) {
		
		model.addAttribute("rzp_key_id", env.getProperty("rzp_key_id"));
		model.addAttribute("rzp_currency",env.getProperty("rzp_currency"));
		model.addAttribute("rzp_company_name",env.getProperty("rzp_company_name"));
		
		return "pay";
	}


	@PostMapping("/done")
	public String done(Model model) {
		
		model.addAttribute("message" , "payment successfully done ");
		
		return "done";
		
	}
	

}
