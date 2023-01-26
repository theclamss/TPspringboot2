package fr.sorbonne.paris.nord.tpspringboot2.TeamService;

import fr.sorbonne.paris.nord.tpspringboot2.DTOs.PlayerDTO;
import fr.sorbonne.paris.nord.tpspringboot2.DTOs.TeamDTO;
import fr.sorbonne.paris.nord.tpspringboot2.EntityInvalidException;
import fr.sorbonne.paris.nord.tpspringboot2.Mapper.PlayerMapper;
import fr.sorbonne.paris.nord.tpspringboot2.Repository.PlayerRepository;
import fr.sorbonne.paris.nord.tpspringboot2.models.Player;
import fr.sorbonne.paris.nord.tpspringboot2.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {






        private final PlayerRepository playerRepository;
        private final PlayerMapper playerMapper;

        @Autowired
        public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
            this.playerRepository = playerRepository;
            this.playerMapper = playerMapper;
        }


        public List<PlayerDTO> getAllPlayers() {


            return  playerRepository.findAll().stream().map(p->playerMapper.playerToPlayerDTO(p)).toList();
        }


        public PlayerDTO getPlayerById(Long id) {
            return playerMapper.playerToPlayerDTO(playerRepository.findById(id).orElse(null));
        }


        public PlayerDTO insertPlayer(PlayerDTO player) {
            return playerMapper.playerToPlayerDTO(playerRepository.save(playerMapper.playerDTOToPlayer(player)));
        }
/*

        public Player updatePlayer(PlayerDTO player) {
            Player m=playerMapper.playerDTOToPlayer(player);
            PlayerDTO PlayerExisted = get

            return playerRepository.save(player);
        }

   */


        public void deletePlayer(Long id) {
            playerRepository.deleteById(id);
        }
    }






