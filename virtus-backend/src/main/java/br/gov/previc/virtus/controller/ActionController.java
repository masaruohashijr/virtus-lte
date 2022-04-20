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

import br.gov.previc.virtus.domain.Action;
import br.gov.previc.virtus.repository.ActionRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @PostMapping(value = "/action")
    @ResponseBody
    public Action addAction(@RequestBody Action action) {
        return actionRepository.save(action);
    }

    @GetMapping("/action/{id}")
    public @ResponseBody Action getAction(@PathVariable("id") int id) {
        return actionRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/action")
    public @ResponseBody List<Action> getActions() {
        Iterable<Action> iterable = actionRepository.findAll();
        List<Action> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/action/{id}")
	public ResponseEntity<Action> updateAction(@PathVariable Integer id, @RequestBody Action formAction){

		Action  action = actionRepository.findById(id).get();
        		action.setName(formAction.getName());
                action.setOrigin_status_id(formAction.getOrigin_status_id());
                action.setDestination_status_id(formAction.getDestination_status_id());
                action.setOther_than(formAction.isOther_than());
                action.setDescription(formAction.getDescription());
                
        Action updatedAction = actionRepository.save(action);
		return ResponseEntity.ok(updatedAction);
	}

    @DeleteMapping("/action/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAction(@PathVariable int id) {

        Action action = actionRepository.findById(id).get();
                    	actionRepository.delete(action);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}