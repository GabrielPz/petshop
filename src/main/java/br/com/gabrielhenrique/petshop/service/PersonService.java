package br.com.gabrielhenrique.petshop.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielhenrique.petshop.DTO.PersonDTO;
import br.com.gabrielhenrique.petshop.entity.Person;
import br.com.gabrielhenrique.petshop.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public Person create(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setPhone(personDTO.getPhone());
        person.setIndetifier(personDTO.getIdentifier());

        return personRepository.save(person);
    }
    public Person update(UUID id, PersonDTO personDTO){
        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        existingPerson.setName(personDTO.getName());
        existingPerson.setSurname(personDTO.getSurname());
        existingPerson.setPhone(personDTO.getPhone());
        existingPerson.setIndetifier(personDTO.getIdentifier());

        return personRepository.save(existingPerson);
    }
    // public Person delete(){
        
    // }
    // public Person listAll(){
        
    // }
    // public Person listById(){
        
    // }
}
