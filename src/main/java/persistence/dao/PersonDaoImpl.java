package persistence.dao;

import model.PersonModel;
import persistence.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public List<PersonModel> getAllPersons() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstws");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql = "select u from Person u";
        List<Person> personList = entityManager.createQuery(sql).getResultList();
        List<PersonModel> personModels = new ArrayList<>();

        for(Person person:personList){

            personModels.add(new PersonModel(person.getId(),person.getName(),person.getSurname()));
        }


        return personModels;
    }

    @Override
    public void addPerson(PersonModel model) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstws");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person person = new Person();

        person.getPerson(model);

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();;

    }

    @Override
    public void updatePerson(PersonModel model) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstws");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class,model.getId());
        person.setName(model.getName());
        person.setSurname(model.getSurname());
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deletePerson(Integer id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstws");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();

    }
}
