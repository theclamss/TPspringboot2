package fr.sorbonne.paris.nord.tpspringboot2;


import fr.sorbonne.paris.nord.tpspringboot2.TeamService.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    TeamService myservice;
    @GetMapping("/hello")
    public String hello(){
        return "Hello World"+ myservice.getAllTeams();
    }


}
