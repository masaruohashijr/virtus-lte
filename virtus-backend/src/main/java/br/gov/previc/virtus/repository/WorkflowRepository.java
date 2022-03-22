package br.gov.previc.virtus.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.previc.virtus.domain.Workflow;

public interface WorkflowRepository extends CrudRepository<Workflow, Integer> {}