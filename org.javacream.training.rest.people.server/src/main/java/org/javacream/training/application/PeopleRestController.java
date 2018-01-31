package org.javacream.training.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PeopleRestController{
	

	@Autowired private PeopleRepository repo;

	@RequestMapping(method=RequestMethod.GET, path="/people/{id}", produces="application/json")
	public Person findPersonById(@PathVariable("id") Long personId) {
		return repo.findOne(personId);
	}
	@RequestMapping(method=RequestMethod.GET, path="/people", produces="application/json")
	public Person[] findAllPeople() {
		List<Person> people = repo.findAll();
		Person[] result = new Person[people.size()];
		people.toArray(result);
		return result;
	}

	@RequestMapping(method=RequestMethod.POST, path="/people", consumes="application/json")
	public void savePerson(@RequestBody Person p) {
		repo.save(p);
	}

	@RequestMapping(method=RequestMethod.PUT, path="/people", consumes="application/json")
	public void updatePerson(@RequestBody Person p) {
		repo.save(p);
	}

	@RequestMapping(method=RequestMethod.DELETE, path="/people/{id}")
	public void deletePersonById(@PathVariable("id") Long personId) {
		repo.delete(personId);
	}

}