package com.bestswlkh0310.album.web.login;

import com.bestswlkh0310.album.domain.login.LoginRequest;
import com.bestswlkh0310.album.domain.login.AuthService;
import com.bestswlkh0310.album.domain.login.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sign")
public class AuthController {

    private final AuthService loginService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/in")
    public String loginForm(Model model) {
        model.addAttribute("req", new LoginRequest());
        return "sign/loginForm";
    }

    @PostMapping("/in")
    public String login() {
        return "redirect:/home";
    }

    @GetMapping("/up")
    public String signUpForm(Model model) {
        model.addAttribute("req", new SignUpRequest());
        return "sign/signUpForm";
    }

    @PostMapping("/up")
    public String signUp(@ModelAttribute("req") SignUpRequest signUpRequest,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign/signUpForm";
        }

        signUpRequest.setPw(passwordEncoder.encode(signUpRequest.getPw()));
        System.out.println(signUpRequest);
        loginService.signUp(signUpRequest);

        return "redirect:/sign/in";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/sign/in";
    }
}
