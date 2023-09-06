package br.com.nicole.crudCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nicole.crudCinema.model.Filmes;

@Repository
public interface FilmeRepository extends JpaRepository<Filmes, Long> {

}
