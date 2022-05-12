package br.gov.previc.virtus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gov.previc.virtus.domain.User;
import br.gov.previc.virtus.repository.UserRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/user")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable("id") int id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/user/list")
    public @ResponseBody List<User> getUsers() {

//    	Iterable<User> iterable = userRepository.findAll();    	
//      List<User> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
  	
    	List<User> actualList = userRepository.findAll();

        return actualList;
    }

    @PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User formUser){

		User    user = userRepository.findById(id).get();
        		user.setUsername(formUser.getUsername());
                user.setPassword(formUser.getPassword());
                user.setEmail(formUser.getEmail());
                user.setMobile(formUser.getMobile());
                user.setName(formUser.getName());
//                user.setAuthor_id(formUser.getAuthor_id());

        User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {

        User user = userRepository.findById(id).get();
                    userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}