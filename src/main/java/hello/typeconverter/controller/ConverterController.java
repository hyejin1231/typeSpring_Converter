package hello.typeconverter.controller;

import hello.typeconverter.type.ipPort;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    @GetMapping("/converter-view")
    public String converterView(Model model) {
        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", new ipPort("127.0.0.1", 8080));
        return "converter-view";
    }

    @GetMapping("/converter/edit")
    public String converterForm(Model model) {
        ipPort port = new ipPort("127.0.0.1", 8080);
        Form form = new Form(port);
        model.addAttribute("form", form);
        return "converter-form";
    }

    @PostMapping("/converter/edit")
    public String converterEdit(@ModelAttribute Form form, Model model) {
        ipPort port = form.getPort();
        model.addAttribute("ipPort", port);
        return "converter-view";
    }

    @Data
    static class Form {
        private ipPort port;

        public Form(ipPort port) {
            this.port = port;
        }
    }
}
