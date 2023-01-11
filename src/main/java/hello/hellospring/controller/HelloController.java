package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")//http URL이 hello라면 (현재는 http://localhost8080/hello)
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";// resources/templates/{hello}.html에 렌더링
    }
}
