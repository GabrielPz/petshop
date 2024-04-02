package br.com.gabrielhenrique.petshop.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielhenrique.petshop.entity.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByName(String name);
}
