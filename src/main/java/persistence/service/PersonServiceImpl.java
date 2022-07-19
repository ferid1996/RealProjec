package persistence.service;

import model.PersonModel;
import persistence.dao.PersonDao;
import persistence.dao.PersonDaoImpl;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public List<PersonModel> getAllPersons() {

        return personDao.getAllPersons();
    }

    @Override
    public void addPerson(PersonModel model) {
        personDao.addPerson(model);
    }

    @Override
    public void updatePerson(PersonModel model) {
        personDao.updatePerson(model);
    }

    @Override
    public void deletePerson(Integer id) {
        personDao.deletePerson(id);
    }
}
