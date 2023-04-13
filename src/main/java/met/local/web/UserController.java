package met.local.web;


import met.local.model.User;
import met.local.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/list")
    private String getAll(Model model){
        model.addAttribute("users", repository.findAll());
        return "/admin/user_list";
    }


    @GetMapping("/delete/{id}")
    private String deleteGame(@PathVariable("id") Long id){

        Optional<User> game = repository.findById(id);
        if(game.isPresent()){
            repository.delete(game.get());
        }else{
            System.err.println("not found");
        }
        return "redirect:/admin/user/list";
    }
}
