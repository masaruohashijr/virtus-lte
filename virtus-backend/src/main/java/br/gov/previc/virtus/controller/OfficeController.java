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

import br.gov.previc.virtus.domain.Office;
import br.gov.previc.virtus.repository.OfficeRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class OfficeController {

    @Autowired
    private OfficeRepository officeRepository;

    @PostMapping(value = "/office")
    @ResponseBody
    public Office addOffice(@RequestBody Office office) {
        return officeRepository.save(office);
    }

    @GetMapping("/office/{id}")
    public @ResponseBody Office getOffice(@PathVariable("id") int id) {
        return officeRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/office")
    public @ResponseBody List<Office> getOffices() {
        Iterable<Office> iterable = officeRepository.findAll();
        List<Office> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/office/{id}")
	public ResponseEntity<Office> updateOffice(@PathVariable Integer id, @RequestBody Office formOffice){

		Office  office = officeRepository.findById(id).get();
        		office.setNome(formOffice.getNome());
                office.setAbreviatura(formOffice.getAbreviatura());
                office.setDescricao(formOffice.getDescricao());
                office.setChefe_id(formOffice.getChefe_id());
                office.setAuthor_id(formOffice.getAuthor_id());
                office.setCriado_em(formOffice.getCriado_em());
                office.setId_versao_origem(formOffice.getId_versao_origem());
                office.setStatus_id(formOffice.getStatus_id());

        Office updatedOffice = officeRepository.save(office);
		return ResponseEntity.ok(updatedOffice);
	}

    @DeleteMapping("/office/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOffice(@PathVariable int id) {

        Office office = officeRepository.findById(id).get();
                    officeRepository.delete(office);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}