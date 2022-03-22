package br.gov.previc.virtus.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.previc.virtus.domain.Feature;

public interface FeatureRepository extends CrudRepository<Feature, Integer> {}