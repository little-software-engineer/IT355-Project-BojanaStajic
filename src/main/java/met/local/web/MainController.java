package met.local.web;

import met.local.model.Game;
import met.local.model.Product;
import met.local.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
public class MainController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model){
		model.addAttribute("products", productRepository.findAll());
		return "shop";
	}

	@RequestMapping("/cart")
	public String cart(){
		return "cart";
	}

	@RequestMapping("/product/{id}")
	public String product(@PathVariable("id") Game product, Model model){
		model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping("/buy")
	public String buy(){
		return "buy_success";
	}


}
