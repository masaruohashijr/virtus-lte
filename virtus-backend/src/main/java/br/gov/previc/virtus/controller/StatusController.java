package br.gov.previc.virtus.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import br.gov.previc.virtus.domain.Status;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class StatusController {

    private Map<Integer, Status> statuses = new HashMap<Integer, Status>();

    @GetMapping("/statuses")
    public List<Status> getAll() {
        return new ArrayList<Status>(statuses.values());
    }

    @GetMapping("/status")
    public Status getById(int id) {
        return statuses.get(id);
    }

    @PostMapping("/status")
    public void add(@RequestBody Status status) {
        System.out.println("Adding "+status.getName());
        int max = getMaxKey() + 1;
        status.setId(max);
        statuses.put(max, status);
    }

    @PutMapping("/status/{id}")
    @CrossOrigin(origins = { "http://localhost:4200" })
    public void update(@PathVariable int id, @RequestBody Status status) {
        System.out.println("Updating "+id+" - "+status.getName());
        statuses.replace(id, status);
    }

    @DeleteMapping("/status/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("Deleting "+id);
        statuses.remove(id);
    }

    private int getMaxKey() {
        int aux = 0;
        for (Status s : statuses.values()) {
            if (aux < s.getId()) {
                aux = s.getId();
            }
        }
        return aux;
    }
}
