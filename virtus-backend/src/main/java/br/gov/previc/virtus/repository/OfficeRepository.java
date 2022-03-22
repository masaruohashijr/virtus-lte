package br.gov.previc.virtus.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.previc.virtus.domain.Office;

public interface OfficeRepository extends CrudRepository<Office, Integer> {}