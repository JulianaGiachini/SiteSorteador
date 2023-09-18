package sorteador.projeto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sorteador.projeto.Service.S_sorteio;

import java.util.Date;
import java.util.stream.Collectors;

@Controller
public class C_resultado {

    @GetMapping("/resultado")
    public String pagResult() {
        return "/resultado";
    }

    @PostMapping("/")
    public String postDados(@RequestParam("quantidade") int quantidade,
                            @RequestParam("inicio") int inicio,
                            @RequestParam("fim") int fim,
                            @RequestParam(value = "check1", required = false) boolean check1,
                            @RequestParam(value = "check2", required = false) boolean check2,
                            Model model) {

        model.addAttribute("quantidade", quantidade);
        model.addAttribute("data", new Date().toLocaleString());
        model.addAttribute("faixanumeros", inicio + " e " + fim);

        if (check2 == true) {
            int[] vetorSorteadoNum = S_sorteio.sorteador(quantidade, inicio, fim);

            if (check1 == true) {
                vetorSorteadoNum = S_sorteio.ordenaNumero(vetorSorteadoNum)
                        .boxed()
                        .collect(Collectors.toList())
                        .stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
            }

            model.addAttribute("resultado", vetorSorteadoNum);
            return "/resultado";
        } else {
            int[] vNumbers = S_sorteio.sortearNumerosRepetidos(quantidade, inicio, fim);
            if (check1 == true) {
                vNumbers = S_sorteio.ordenaNumero(vNumbers)
                        .boxed()
                        .collect(Collectors.toList())
                        .stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
            }
            model.addAttribute("resultado", vNumbers);
            return "/resultado";
        }
    }
}
