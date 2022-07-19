package persistence.dao;

import model.PersonModel;

import java.util.List;

public interface PersonDao {

    List<PersonModel> getAllPersons();

    void addPerson(PersonModel model);

    void updatePerson(PersonModel model);

    void deletePerson(Integer id);
}
