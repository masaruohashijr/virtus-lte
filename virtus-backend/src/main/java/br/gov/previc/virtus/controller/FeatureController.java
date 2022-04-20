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

import br.gov.previc.virtus.domain.Feature;
import br.gov.previc.virtus.repository.FeatureRepository;

@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class FeatureController {

    @Autowired
    private FeatureRepository featureRepository;

    @PostMapping(value = "/feature")
    @ResponseBody
    public Feature addFeature(@RequestBody Feature feature) {
        return featureRepository.save(feature);
    }

    @GetMapping("/feature/{id}")
    public @ResponseBody Feature getFeature(@PathVariable("id") int id) {
        return featureRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/feature/list")
    public @ResponseBody List<Feature> getFeatures() {
        Iterable<Feature> iterable = featureRepository.findAll();
        List<Feature> result = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        return result;
    }

    @PutMapping("/feature/{id}")
	public ResponseEntity<Feature> updateFeature(@PathVariable Integer id, @RequestBody Feature formFeature){

		Feature	feature = featureRepository.findById(id).get();
        		feature.setName(formFeature.getName());
                feature.setCode(formFeature.getCode());
                feature.setDescription(formFeature.getDescription());

        Feature updatedFeature = featureRepository.save(feature);
		return ResponseEntity.ok(updatedFeature);
	}

    @DeleteMapping("/feature/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFeature(@PathVariable int id) {

        Feature feature = featureRepository.findById(id).get();
                    featureRepository.delete(feature);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}