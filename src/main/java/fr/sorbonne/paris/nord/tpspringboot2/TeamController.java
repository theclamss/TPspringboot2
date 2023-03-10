/*package fr.sorbonne.paris.nord.tpspringboot2;

import fr.sorbonne.paris.nord.tpspringboot2.TeamService.TeamService;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
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
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeams(@PathVariable Long id) {
        Team teams = teamService.getTeamById(id);
        return new ResponseEntity(teams, HttpStatus.OK);
    }
    @GetMapping("/{nom}/{slogan}")
    public ResponseEntity<Team> getTeams(@PathVariable String nom, @PathVariable String slogan) {
        Team t1=new Team(nom,slogan);
        Team teams = teamService.insertteam(t1);
        return new ResponseEntity(teams, HttpStatus.OK);
    }

    @PutMapping
    public Team updateTeam(@RequestParam String name, @RequestParam String slogan) {


        Team existingTeam = teamService.getTeamByName(name);
        if (existingTeam == null) {
            Team t2=new Team(name,slogan);
            return teamService.insertteam(t2);
        } else {
            Long id=existingTeam.getId();

           return teamService.upadateteam(id,name,slogan);
        }
    }
    @PutMapping("/delete")
    public void deleteTeam( @RequestParam Long id) {

        teamService.deleteteam(id);

    }



    
}
*/