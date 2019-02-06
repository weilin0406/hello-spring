package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller

public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String Index(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name == null) {
            name = "world";
        }
        return "hello " + name;
    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>"+
                "<input type='text' name='name' />" +
                    "<select name='Language'>" +
                        "<option value='Language'>Language</option>"+
                        "<option value='Chinese'>Chinese</option>" +
                        "<option value='French'>French</option>" +
                        "<option value='Korean'>Korean</option>" +
                        "<option value='English'>English</option>" +
                        "<option value='Spanish'>Spanish</option>" +
                    "</select>" +
                "<input type='submit' value='Great Me!' />"+
         "</form>";

        return html;
    }


    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("Language");
        String greeting = "hello ";


        switch (language) {
            case "Chinese":
                greeting = "学程序他妈的太难了 ";
                break;
            case "Korean":
                greeting = "코딩 좃나힘드네 ";
                break;
            case "French":
                greeting = "Bonjour ";
                break;
            case "English":
                greeting = "Hello ";
                break;
            case "Spanish":
                greeting = "Chico guapo ";
                break;

        }
        String message = greeting + name;
        return message;

    }


    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "hello " + name;

    }

    @RequestMapping(value ="goodbye")

    public String goodby(){
        return "redirect:/";
    }
}
