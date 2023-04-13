package met.local.web;

import met.local.model.Cart;
import met.local.model.Game;
import met.local.model.Product;
import met.local.service.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartManager cartManager;

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Game product,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int quantity){
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, quantity);
        return "cart";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") Game product){
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Game product, @RequestParam("qty") int quantity){
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, quantity);
        return "cart";
    }
}