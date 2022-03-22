package br.gov.previc.virtus.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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

import br.gov.previc.virtus.domain.Status;
import br.gov.previc.virtus.repository.StatusRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping(value = "/status")
    @ResponseBody
    public Status addStatus(@RequestBody Status status) {

        if(status.getCreated_at() == null) {
            status.setCreated_at(Timestamp.from(Instant.now()));
        }
        return statusRepository.save(status);
    }

    @GetMapping("/status/{id}")
    public @ResponseBody Status getStatus(@PathVariable("id") int id) {
        return statusRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/status")
    public @ResponseBody List<Status> getStatuss() {
        Iterable<Status> iterable = statusRepository.findAll();
        List<Status> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/status/{id}")
	public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Status formStatus){
        
        Status  status = statusRepository.findById(id).get();
        		status.setName(formStatus.getName());
        		status.setDescription(formStatus.getDescription());
        		status.setAuthor_id(formStatus.getAuthor_id());
        		status.setCreated_at(formStatus.getCreated_at());
        		status.setId_versao_origem(formStatus.getId_versao_origem());
        		status.setStatus_id(formStatus.getStatus_id());
        		status.setStereotype(formStatus.getStereotype());

        Status updatedStatus = statusRepository.save(status);
		return ResponseEntity.ok(updatedStatus);
	}

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStatus(@PathVariable int id) {

        Status status = statusRepository.findById(id).get();
                    	statusRepository.delete(status);

        Map<String, Boolean>	response = new HashMap<>();
        						response.put("deleted", Boolean.TRUE);
        						
        return ResponseEntity.ok(response);
    }

}