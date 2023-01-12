package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")//http URL이 hello라면 (현재는 http://localhost8080/hello)
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";// resources/templates/{hello}.html에 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        //@RequestParam() -> GET방식으로 받는 parameter(쿼리스트링)
        //@RequestParam(key값) String value값
        //addAtribute(view 단의 변수명 ${}, 출력될 값)
        model.addAttribute("name", name);
        return "hello-template";
        //랜더링 페이지로 가는 주소 : hello-mvc?name={name}
    }

}
