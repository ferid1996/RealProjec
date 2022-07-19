package controller;

import model.PersonModel;
import persistence.service.PersonService;
import persistence.service.PersonServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//localhost/api/index/hello

@Path("/user")
public class IndexController {

   /* @Path("/hello")
    @GET
    public void sayHello(){
        System.out.println("Hello World!!!");
    }*/

   /* @Path("/hello/{name}/{surname}")
    @GET
    public String sayHello(@PathParam("name") String ad, @PathParam("surname") String soyad){

        return "Hello  " + ad+" "+soyad;
    }*/

   /* @Path("/hello")
    @GET
    public String sayHello(@QueryParam("name") String ad, @QueryParam("surname") String soyad){

        return "Hello  " + ad+" "+soyad;
    }*/

   /* @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonModel sayHello(){

        PersonModel person = new PersonModel();
        person.setId(100);
        person.setName("Nazim");
        person.setSurname("Chobanli");

        return person; //new PersonModel(1000,"Eyyub","Qadirov");
    }*/

  /* @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonModel sayHello(@QueryParam("id") Integer id){

        return new PersonModel(id,"Eyyub","Qadirov");
    }*/

    private PersonService personService = new PersonServiceImpl();

    @Path("/get")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonModel> getAllPersons(){

        return personService.getAllPersons();
    }



    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(PersonModel model){

        personService.addPerson(model);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(PersonModel model){

        personService.updatePerson(model);
    }


    @Path("/{id}")
    @DELETE
    public void delete (@PathParam("id") Integer id){

        personService.deletePerson(id);

    }



}
