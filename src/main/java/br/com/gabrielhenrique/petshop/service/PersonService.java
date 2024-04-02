package br.com.gabrielhenrique.petshop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielhenrique.petshop.DTO.PersonDTO;
import br.com.gabrielhenrique.petshop.entity.Person;
import br.com.gabrielhenrique.petshop.exceptions.PersonNotFoundException;
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
        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id.toString()));
        existingPerson.setName(personDTO.getName());
        existingPerson.setSurname(personDTO.getSurname());
        existingPerson.setPhone(personDTO.getPhone());
        existingPerson.setIndetifier(personDTO.getIdentifier());

        return personRepository.save(existingPerson);
    }
    public void delete(UUID id){
        if(!personRepository.existsById(id)){
            throw new PersonNotFoundException(id.toString());
        }
        personRepository.deleteById(id);
    }
    public List<Person> listAll(){
        return personRepository.findAll();
    }
    public Person listById(UUID id){
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id.toString()));
    }
}
