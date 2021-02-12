package org.javacream.training.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class PeopleRestController {

	@Autowired
	private PeopleRepository repo;

	@GetMapping(path = "/people/{id}", produces = "application/json")
	public Person findPersonById(@PathVariable("id") Long personId) {
		try {
			return repo.findById(personId).get();
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/people", produces = "application/json")
	public Person[] findAllPeople() {
		List<Person> people = repo.findAll();
		Person[] result = new Person[people.size()];
		people.toArray(result);
		return result;
	}

	@PostMapping(path = "/people", consumes = "application/json")
	public Long savePerson(@RequestBody Person p) {
		try {
			repo.save(p);
			return p.getId();
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PutMapping(path = "/people", consumes = "application/json")
	public void updatePerson(@RequestBody Person p) {
		repo.save(p);
	}

	@DeleteMapping(path = "/people/{id}")
	public void deletePersonById(@PathVariable("id") Long personId) {
		try {
			repo.deleteById(personId);
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}