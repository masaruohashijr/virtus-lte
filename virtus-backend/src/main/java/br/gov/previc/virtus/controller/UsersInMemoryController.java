package br.gov.previc.virtus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gov.previc.virtus.domain.User;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class UsersInMemoryController {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    @GetMapping("/im_users")
    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }

    @GetMapping("/im_user")
    public User getById(int id) {
        return users.get(id);
    }

    @PostMapping("/im_user")
    public void add(@RequestBody User user) {
        System.out.println("Adding " + user.getName());
        int max = getMaxKey() + 1;
        user.setId(max);
        users.put(max, user);
    }

    @PutMapping("/im_user/{id}")
    @CrossOrigin(origins = { "http://localhost:4200" })
    public void update(@PathVariable int id, @RequestBody User user) {
        System.out.println("Updating " + id + " - " + user.getName());
        users.replace(id, user);
    }

    @DeleteMapping("/im_user/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("Deleting " + id);
        users.remove(id);
    }

    private int getMaxKey() {
        int aux = 0;
        for (User s : users.values()) {
            if (aux < s.getId()) {
                aux = s.getId();
            }
        }
        return aux;
    }

    public HashSet<User> mockUsers() {

        HashSet<User>   usuarios = new HashSet<User>();

                        usuarios.add(new User("Chico Buarque", "senha", "user@mail.com", "+5561999999999", "Chico Buarque", 1, 1, null));
                        usuarios.add(new User("Jorge Ben Jor", "senha", "user@mail.com", "+5561999999999", "Jorge Ben Jor", 1, 1, null));
                        usuarios.add(new User("Tom Jobim", "senha", "user@mail.com", "+5561999999999", "Tom Jobim", 1, 1, null));
                        usuarios.add(new User("Milton Nascimento", "senha", "user@mail.com", "+5561999999999", "Milton Nascimento", 1, 1, null));
                        usuarios.add(new User("Elis Regina", "senha", "user@mail.com", "+5561999999999", "Elis Regina", 1, 1, null));
                        usuarios.add(new User("João Gilberto", "senha", "user@mail.com", "+5561999999999", "João Gilberto", 1, 1, null));
                        usuarios.add(new User("Toquinho", "senha", "user@mail.com", "+5561999999999", "Toquinho", 1, 1, null));
                        usuarios.add(new User("Vinícius de Moraes", "senha", "user@mail.com", "+5561999999999", "Vinícius de Moraes", 1, 1, null));
                        usuarios.add(new User("Nara Leão", "senha", "user@mail.com", "+5561999999999", "Nara Leão", 1, 1, null));
                        usuarios.add(new User("Djavan", "senha", "user@mail.com", "+5561999999999", "Djavan", 1, 1, null));
                        usuarios.add(new User("Taiguara", "senha", "user@mail.com", "+5561999999999", "Taiguara", 1, 1, null));
                        usuarios.add(new User("Zé Ramalho", "senha", "user@mail.com", "+5561999999999", "Zé Ramalho", 1, 1, null));

        return usuarios;
    }


}