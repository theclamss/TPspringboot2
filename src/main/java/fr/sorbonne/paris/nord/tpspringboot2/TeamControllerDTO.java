package fr.sorbonne.paris.nord.tpspringboot2;

import fr.sorbonne.paris.nord.tpspringboot2.DTOs.TeamDTO;
import fr.sorbonne.paris.nord.tpspringboot2.TeamService.TeamServiceWithDTO;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamControllerDTO {

    @Autowired
    private TeamServiceWithDTO teamService;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        System.out.println("hhhhh");
        List<TeamDTO> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeams(@PathVariable Long id) {
        TeamDTO teams = teamService.getTeamById(id);
        return new ResponseEntity(teams, HttpStatus.OK);
    }
    @GetMapping("/{nom}/{slogan}")
    public ResponseEntity<Team> getTeams(@PathVariable String nom, @PathVariable String slogan) {
        TeamDTO t1=new TeamDTO(nom,slogan);
        TeamDTO teams = teamService.insertteam(t1);
        return new ResponseEntity(teams, HttpStatus.OK);
    }
        /*
    @PutMapping
    public TeamDTO updateTeam(@RequestParam String name, @RequestParam String slogan) {


        TeamDTO existingTeam = teamService.getTeamByName(name);
        if (existingTeam == null) {
            TeamDTO t2=new TeamDTO(name,slogan);
            return teamService.insertteam(t2);
        } else {
            Long id=existingTeam.getId();

            return teamService.updateteam(id,name,slogan);
        }
    }
    */

    @PutMapping("/delete")
    public void deleteTeam( @RequestParam Long id) {

        teamService.deleteteam(id);

    }




}

