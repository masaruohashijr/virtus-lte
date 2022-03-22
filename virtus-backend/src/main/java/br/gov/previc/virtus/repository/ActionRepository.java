package br.gov.previc.virtus.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.previc.virtus.domain.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {}