package fr.sorbonne.paris.nord.tpspringboot2.TeamService;

import fr.sorbonne.paris.nord.tpspringboot2.DTOs.TeamDTO;
import fr.sorbonne.paris.nord.tpspringboot2.EntitiesNotFoundException;
import fr.sorbonne.paris.nord.tpspringboot2.Mapper.TeamMapper;
import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public TeamDTO getTeamById(Long id) {
        return teamMapper.teamToTeamDTO(Collections.singletonList(teamRepository.findById(id).orElse(null)).get(0));
    }

    public TeamDTO insertteam(TeamDTO teamDTO) {
        return teamMapper.teamToTeamDTO((Team) Collections.singletonList(teamRepository.save(teamMapper.teamDTOToTeam(teamDTO))));
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