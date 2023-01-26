package fr.sorbonne.paris.nord.tpspringboot2.TeamService;

import fr.sorbonne.paris.nord.tpspringboot2.DTOs.TeamDTO;
import fr.sorbonne.paris.nord.tpspringboot2.EntitiesNotFoundException;
import fr.sorbonne.paris.nord.tpspringboot2.EntityInvalidException;
import fr.sorbonne.paris.nord.tpspringboot2.Mapper.TeamMapper;
import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class TeamServiceWithDTO {



    @Autowired
    TeamMapper teamMapper;

    @Autowired
    TeamRepository teamRepository;


    public List<TeamDTO> getAllTeams() {
        List<Team> team1=new ArrayList<>();

        return null;
       // return teamMapper.teamToTeamDTO(Collections.singletonList(teamRepository.findAll()));
    }

    public TeamDTO getTeamByName(String nom) {
        return teamMapper.teamToTeamDTO(Collections.singletonList(teamRepository.findByNom(nom)).get(0).get(0));

    }

    public TeamDTO getTeamById(Long id) throws EntityNotFoundException {
        return teamMapper.teamToTeamDTO(Collections.singletonList(teamRepository.findById(id).orElseThrow(EntitiesNotFoundException::new)).get(0));
    }

    public TeamDTO insertteam(TeamDTO teamDTO) {

        return teamMapper.teamToTeamDTO((Team) Collections.singletonList(teamRepository.save(teamMapper.teamDTOToTeam(teamDTO))));
    }

    public void upadateteam(TeamDTO t) throws EntityInvalidException {

        Team m=teamMapper.teamDTOToTeam(t);

        TeamDTO existingTeam = getTeamByName(m.getNom());

        if(existingTeam==null){
                teamRepository.save(m);
        }

        else {
                existingTeam.setNom(t.getNom());
                existingTeam.setSlogan(t.getSlogan());
                teamRepository.save(teamMapper.teamDTOToTeam(existingTeam));
        }

            }


    public void deleteteam(Long id){
        try {
            Team t1 = teamRepository.findById(id).orElseThrow(EntitiesNotFoundException::new);
            teamRepository.delete(t1);
        } catch (EntitiesNotFoundException e) {
            throw e;
        }
    }
}