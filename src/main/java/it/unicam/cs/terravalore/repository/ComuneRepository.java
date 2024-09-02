package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {
    List<Comune> findByUtenti_Id(Long utenteId);
}
