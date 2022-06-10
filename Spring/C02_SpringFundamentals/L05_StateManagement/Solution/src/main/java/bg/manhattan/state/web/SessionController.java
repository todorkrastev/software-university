package bg.manhattan.state.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private static final String LANG_SESSION_ATTRIBUTE = "lang";
    private static final String DEFAULT_LANG = "en";


    @GetMapping("/session")
    public String session(HttpSession session, Model model) {
        Object sessionLang = session.getAttribute(LANG_SESSION_ATTRIBUTE);
        model.addAttribute("lang",
                sessionLang != null ?
                        sessionLang : DEFAULT_LANG);
        return "session";
    }

    @PostMapping("/session")
    public String session(
            @RequestParam(
                    value = "language",
                    required = false,
                    defaultValue = "en") String language,
                    HttpSession session) {

        session.setAttribute("lang", language);
        return "redirect:/session";
    }
}
