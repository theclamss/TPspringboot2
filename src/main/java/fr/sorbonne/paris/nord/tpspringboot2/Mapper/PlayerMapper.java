package fr.sorbonne.paris.nord.tpspringboot2.Mapper;

import fr.sorbonne.paris.nord.tpspringboot2.DTOs.PlayerDTO;
import fr.sorbonne.paris.nord.tpspringboot2.models.Player;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
@Component
public class PlayerMapper {





    public PlayerDTO playerToPlayerDTO(Player player){
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setFirstname(player.getFirstname());
            playerDTO.setLastname(player.getLastname());
            playerDTO.setBirthday(player.getBirthday());
            playerDTO.setPosition(player.getPosition());
            return playerDTO;
        }

    public Player playerDTOToPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setFirstname(playerDTO.getFirstname());
        player.setLastname(playerDTO.getLastname());
        player.setBirthday(playerDTO.getBirthday());
        player.setPosition(playerDTO.getPosition());
        return player;
    }

}
