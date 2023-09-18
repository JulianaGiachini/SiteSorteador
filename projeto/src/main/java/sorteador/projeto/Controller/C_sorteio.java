package sorteador.projeto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sorteador.projeto.Service.S_sorteio;

@Controller
public class C_sorteio {

    @GetMapping("/")
    public String pagHome() {
        return "/home.html";
    }


}
