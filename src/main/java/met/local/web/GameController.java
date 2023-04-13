package met.local.web;

import met.local.model.Game;
import met.local.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin/game")
public class GameController {

    @Autowired
    private GameRepository repository;

    @GetMapping("/list")
    private String getAll(Model model){
        model.addAttribute("games", repository.findAll());
        return "/admin/game_list";
    }
    @GetMapping(path = {"/add", "edit/{idGame}"})
    private String addForm(@PathVariable("idGame") Optional<Long> idGame, Model model){
        if(idGame.isPresent()){
            model.addAttribute("game", repository.findById(idGame.get()));
        }else{
            model.addAttribute("game", new Game());
        }
        return "/admin/add_edit_game";
    }
    @PostMapping("/addEdit")
    private String insertOrUpdate(Game game){
        if(game.getIdGame() == null){
            repository.save(game);
        }else{
            Optional<Game> gameOptional = repository.findById(game.getIdGame());
            if(gameOptional.isPresent()){
                Game editGame = gameOptional.get();
                editGame.setTitle(game.getTitle());
                editGame.setReleaseYear(game.getReleaseYear());
                editGame.setGenre(game.getGenre());
                editGame.setQuantity(game.getQuantity());
                editGame.setPrice(game.getPrice());
                repository.save(editGame);
            }
        }
        return "redirect:/admin/game/list";
    }
    @GetMapping("/delete/{idGame}")
    private String deleteGame(@PathVariable("idGame") Long idGame){
        Optional<Game> game = repository.findById(idGame);
        if(game.isPresent()){
            repository.delete(game.get());
        }else{
            System.err.println("not found");
        }
        return "redirect:/admin/game/list";
    }
}