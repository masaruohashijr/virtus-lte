package br.gov.previc.virtus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import br.gov.previc.virtus.domain.Role;
import br.gov.previc.virtus.repository.RoleRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value = "/role")
    @ResponseBody
    public Role addrole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @GetMapping("/role/{id}")
    public @ResponseBody Role getrole(@PathVariable("id") int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/role/list")
    public @ResponseBody List<Role> getroles() {
        Iterable<Role> iterable = roleRepository.findAll();
        List<Role> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/role/{id}")
	public ResponseEntity<Role> updaterole(@PathVariable Integer id, @RequestBody Role formrole){

		Role	role = roleRepository.findById(id).get();
        		role.setName(formrole.getName());
                role.setDescription(formrole.getDescription());

        Role updatedrole = roleRepository.save(role);
		return ResponseEntity.ok(updatedrole);
	}

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Map<String, Boolean>> deleterole(@PathVariable int id) {

        Role role = roleRepository.findById(id).get();
                    roleRepository.delete(role);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}