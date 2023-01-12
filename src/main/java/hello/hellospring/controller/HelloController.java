package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //@ResponseBody를 들어가기전에
    //기본적으로는 viewresolver가 작동하여 resources폴더의 templates폴더 -> static폴더 순으로 파일을 찾아서 리턴.
    //@ResponseBody 어노테이션이 들어가면 HttpMessageConverter가 작동하여 html의 body부에 return값을 넣는다.
    @GetMapping("hello-string")
    @ResponseBody
    //생성된 타입에 따라 화면 출력이 다른데 아래 타입은 String이므로 StringConverter가 동작하여 문자열 리턴
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    //이번 타입은 객체이므로 JsonConverter가 동작하여 json형태로 리턴
    //getter()로 호출된 값을 "key":"value"형태로 돌려줌
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("test") String test){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setTest(test);
        return hello;
    }

    static class Hello{
        private String name;
        private String test = "test";

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
