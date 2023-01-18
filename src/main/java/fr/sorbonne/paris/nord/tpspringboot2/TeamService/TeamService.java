package fr.sorbonne.paris.nord.tpspringboot2.TeamService;

import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.models.team;
import fr.sorbonne.paris.nord.tpspringboot2.models.team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<team> getAllTeams() {
        return teamRepository.findAll();
    }

    public team getTeamByName(String nom) {
        return teamRepository.findByNom(nom).get(0);
    }
    public team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
    public team insertteam(team t1) {
        return teamRepository.save(t1);
    }
    public team upadateteam(Long id,String Name,String Slogan) {
        team entity = teamRepository.findById(id).orElseThrow();
        entity.setNom(Name);
        entity.setSlogan(Slogan);

        return teamRepository.save(entity);
    }


}
