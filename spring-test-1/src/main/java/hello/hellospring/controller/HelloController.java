package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; 
        
        // 컨트롤러의 리턴값에 '문자'가 들어가면 resources > templates 에 있는 "문자.html"을 찾는다.
    }

    // ■ MVC와 템플릿 엔진 예시
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("e", name);
        return "hello-template";
    }



    //-------------------------------------------------------------------------------------
    // ■ API 예시 1 (return값이 문자)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }
    // localhost:8080/hello-string?name="임의의 문자"


    // ■ API 예시 2 (return값이 객체)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // '(' 친 상태에서 ctrl + shift + enter 하면 '();'까지 완성됨
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        // getter setter 단축키 : alt + insert

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
