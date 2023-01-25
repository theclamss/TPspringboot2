package fr.sorbonne.paris.nord.tpspringboot2.TeamService;

import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamByName(String nom) {
        return teamRepository.findByNom(nom).get(0);
    }
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
    public Team insertteam(Team t1) {
        return teamRepository.save(t1);
    }
    public Team upadateteam(Long id, String Name, String Slogan) {
        Team entity = teamRepository.findById(id).orElseThrow();
        entity.setNom(Name);
        entity.setSlogan(Slogan);

        return teamRepository.save(entity);
    }
    public void deleteteam(Long id){
        Team t1 = teamRepository.findById(id).orElseThrow();
        teamRepository.delete(t1);
    }


}
