package com.powernode.quickweb.controller;

import com.powernode.quickweb.vo.Person;
import com.powernode.quickweb.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParameterController {


    @GetMapping("/param/p1")
    public String p1(String name, Integer age, String sex) {

        return "接收参数有：" + name + ", "  + age + ", " + sex;
    }

    @GetMapping("/param/p2")
    public String p2(Person person) {
        return "接收参数有：" + person.toString();
    }


    @GetMapping("/param/p3")
    public String p3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        return (name + " " + age + " " + sex);
    }

    @GetMapping("/param/p4")
    public String p4(@RequestParam(value = "name", required = true) String name,
                     @RequestParam(value = "age", required = false, defaultValue = "20") Integer age) {


        return "p4: " + name + " " + age;
    }


    @GetMapping("/param/p5")
    public String p5(@RequestParam(value = "name", required = true) String name,
                     @RequestParam(value = "age", required = false, defaultValue = "20") Integer age,
                     @RequestHeader("Accept") String accept) {


        return "p4: " + name + " " + age + " " + accept;
    }


    @PostMapping("/param/json")
    public String p6(@RequestBody User user) {

        return "p6, json " + user.toString();
    }


    @PostMapping("/param/json2")
    public String p7(Reader reader) {
        StringBuffer content = new StringBuffer("");
        try {
            BufferedReader buf = new BufferedReader(reader);
            var line = "";
            while ((line = buf.readLine()) != null) {
                content.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return content.toString();
    }


    @GetMapping("/param/vals")
    public String getMultiVal(Integer[] ids) {
        List<Integer> arr = Arrays.stream(ids).toList();
        return arr.toString();
    }
}
