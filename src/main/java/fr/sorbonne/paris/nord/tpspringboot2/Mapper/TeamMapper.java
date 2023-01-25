package fr.sorbonne.paris.nord.tpspringboot2.Mapper;



import fr.sorbonne.paris.nord.tpspringboot2.DTOs.TeamDTO;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamMapper {
    public TeamDTO teamToTeamDTO(Team team) {
        return new TeamDTO(team.getId(), team.getNom(), team.getSlogan());
    }
    public Team teamDTOToTeam(TeamDTO teamDTO) {
        return new Team(teamDTO.getId(), teamDTO.getNom(), teamDTO.getSlogan());
    }
}

