package br.com.gabrielhenrique.petshop.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String id){
        super("Pessoa Não encontrada" + id);
    }
}
