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

import br.gov.previc.virtus.domain.Workflow;
import br.gov.previc.virtus.repository.WorkflowRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class WorkflowController {

    @Autowired
    private WorkflowRepository workflowRepository;

    @PostMapping(value = "/workflow")
    @ResponseBody
    public Workflow addWorkflow(@RequestBody Workflow workflow) {
        return workflowRepository.save(workflow);
    }

    @GetMapping("/workflow/{id}")
    public @ResponseBody Workflow getWorkflow(@PathVariable("id") int id) {
        return workflowRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/workflow")
    public @ResponseBody List<Workflow> getWorkflows() {
        Iterable<Workflow> iterable = workflowRepository.findAll();
        List<Workflow> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/workflow/{id}")
	public ResponseEntity<Workflow> updateWorkflow(@PathVariable Integer id, @RequestBody Workflow formWorkflow){

		Workflow	workflow = workflowRepository.findById(id).get();
					workflow.setName(formWorkflow.getName());
					workflow.setDescription(formWorkflow.getDescription());
					workflow.setEntity_type(formWorkflow.getEntity_type());
					workflow.setStart_at(formWorkflow.getStart_at());
					workflow.setEnd_at(formWorkflow.getEnd_at());
					workflow.setAuthor_id(formWorkflow.getAuthor_id());
					workflow.setCreated_at(formWorkflow.getCreated_at());
					workflow.setId_versao_origem(formWorkflow.getId_versao_origem());
					workflow.setCreated_at(formWorkflow.getCreated_at());

        Workflow updatedWorkflow = workflowRepository.save(workflow);
		return ResponseEntity.ok(updatedWorkflow);
	}

    @DeleteMapping("/workflow/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWorkflow(@PathVariable int id) {

        Workflow workflow = workflowRepository.findById(id).get();
                    workflowRepository.delete(workflow);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}