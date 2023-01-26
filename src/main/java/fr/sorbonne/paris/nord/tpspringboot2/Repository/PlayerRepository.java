package fr.sorbonne.paris.nord.tpspringboot2.Repository;


import fr.sorbonne.paris.nord.tpspringboot2.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PlayerRepository extends JpaRepository<Player, Long> {
    }

