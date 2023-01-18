package fr.sorbonne.paris.nord.tpspringboot2;

import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.TeamService.TeamService;
import fr.sorbonne.paris.nord.tpspringboot2.models.team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

   @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<team>> getAllTeams() {
        List<team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<team> getTeams(@PathVariable Long id) {
        team teams = teamService.getTeamById(id);
        return new ResponseEntity(teams, HttpStatus.OK);
    }
    @GetMapping("/{nom}/{slogan}")
    public ResponseEntity<team> getTeams(@PathVariable String nom,@PathVariable String slogan) {
        team t1=new team(nom,slogan);
        team teams = teamService.insertteam(t1);
        return new ResponseEntity(teams, HttpStatus.OK);
    }

    @PutMapping
    public team updateTeam( @RequestParam String name,@RequestParam String slogan) {


        team existingTeam = teamService.getTeamByName(name);
        if (existingTeam == null) {
            team t2=new team(name,slogan);
            return teamService.insertteam(t2);
        } else {
            Long id=existingTeam.getId();

           return teamService.upadateteam(id,name,slogan);
        }
    }



    
}
