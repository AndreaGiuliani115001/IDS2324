package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, Long> {
}
