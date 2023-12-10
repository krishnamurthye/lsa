package com.ls.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.ls.config.PortalRole;
import com.ls.domain.Person;
import com.ls.exception.ResourceNotFoundException;
import com.ls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

//@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;


	@RolesAllowed({ PortalRole.Types.SUPER_ADMIN, PortalRole.Types.CHANCELLOR })
	@GetMapping("/list")
	public List<Person> getAllUsers() {
		
		return userRepository.findAll();
	}


	@PostMapping("/create")
	public Person createUser(@RequestBody Person person) {
		
		Random random = new Random();
		person.setId((person.getFirstName() + person.getLastName() + person.getEmailId()) + random.nextInt(1000));
		return userRepository.save(person);
	}

	@RolesAllowed({ PortalRole.Types.SUPER_ADMIN, PortalRole.Types.CHANCELLOR })
	@GetMapping("/{id}")
	public ResponseEntity<Person> getUserById(@PathVariable String id) {
		
		Person person = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(person);
	}

	@RolesAllowed({ PortalRole.Types.SUPER_ADMIN, PortalRole.Types.CHANCELLOR })
	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updateUser(@PathVariable String id, @RequestBody Person personDetails) {
		
		Person person = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

		person.setFirstName(personDetails.getFirstName());
		person.setLastName(personDetails.getLastName());
		person.setEmailId(personDetails.getEmailId());
		Person updatedPerson = userRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}

	@RolesAllowed({ PortalRole.Types.SUPER_ADMIN, PortalRole.Types.CHANCELLOR })
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String id) {
		
		Person person = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

		userRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
