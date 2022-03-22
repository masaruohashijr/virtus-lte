package br.gov.previc.virtus.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.previc.virtus.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {}