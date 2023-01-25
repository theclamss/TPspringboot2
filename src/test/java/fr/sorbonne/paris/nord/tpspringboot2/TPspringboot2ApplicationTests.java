package fr.sorbonne.paris.nord.tpspringboot2;

import fr.sorbonne.paris.nord.tpspringboot2.Repository.TeamRepository;
import fr.sorbonne.paris.nord.tpspringboot2.TeamService.TeamService;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class TPspringboot2ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamService teamService;
    @org.junit.Test
    public void getTeamById_shouldReturnTeamWithMatchingId() {
        // Arrange
        Team teamA = new Team("Team A", "Slogan A");

        System.out.println(teamRepository);
        teamRepository.save(teamA);
        Long teamAId = teamA.getId();

        // Act
        Team result = teamService.getTeamById(teamAId);

        // Assert
        assertEquals(teamA, result);



    }
    @Test
    public void insertteam_shouldInsertNewTeam() {
        // Arrange
        Team teamA = new Team("Team A", "Slogan A");

        // Act
        teamService.insertteam(teamA);

        // Assert
        Team result = teamRepository.findByNom("Team A").get(0);
        assertEquals(teamA, result);
    }
    @Test
    public void upadateteam_shouldUpdateTeamWithMatchingId() {
        // Arrange
        Team teamA = new Team("Team A", "Slogan A");
        teamRepository.save(teamA);
        Long teamAId = teamA.getId();

        // Act
        teamService.upadateteam(teamAId,"Team B","Slogan B");

        // Assert
        Team result = teamRepository.findById(teamAId).orElse(null);
        assertEquals("Team B", result.getNom());
        assertEquals("Slogan B", result.getSlogan());
    }

    @Test
    public void deleteteam_shouldDeleteTeamWithMatchingId() {
        // Arrange
        Team teamA = new Team("Team A", "Slogan A");
        teamRepository.save(teamA);
        Long teamAId = teamA.getId();

        // Act
        teamService.deleteteam(teamAId);

        // Assert
        Team result = teamRepository.findById(teamAId).orElse(null);
        assertEquals(null, result);
    }



}
