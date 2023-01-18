package fr.sorbonne.paris.nord.tpspringboot2.Repository;

import fr.sorbonne.paris.nord.tpspringboot2.models.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<team, Long> {

    List<team> findByNom(String name);
}
