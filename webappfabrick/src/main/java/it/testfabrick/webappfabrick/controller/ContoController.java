package it.testfabrick.webappfabrick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContoController {

    /*

    @RequestMapping("/")//, method = RequestMethod.GET) //sostituire con l’annotazione @GetMapping
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Dettagli") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }*/
/*
    private List<User> getFakeUsers() {
        User user1 = new User("daniele", "daniele", getAvatar(), "Via tiburtina");
        User user2 = new User("francesca", "daniele", getAvatar(), "Via aurelia");
        User user3 = new User("marco", "marco", getAvatar(), "Via aurelia");
        return Arrays.asList(user1, user2, user3);
    }

    private String getAvatar(){
        return "https://robohash.org/"+ new Random().nextInt() +".png?size=100x100";
    }

    @PostMapping("/login")
    public Object login(@ModelAttribute User user, Model model) {
        String userName = "daniele";
        String password ="1234";
        if(userName.equals(user.getUsername()) && password.equals(user.getPassword())){
            model.addAttribute("user", user);
            model.addAttribute("users", getFakeUsers());
            return "result";
        } else{
            return "error";
        }


    }


}*/

}