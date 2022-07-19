package persistence.service;

import model.PersonModel;

import java.util.List;

public interface PersonService {

    List<PersonModel> getAllPersons();

    void addPerson(PersonModel model);

    void updatePerson(PersonModel model);

    void deletePerson(Integer id);
}
