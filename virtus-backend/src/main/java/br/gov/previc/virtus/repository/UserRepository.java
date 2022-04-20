package br.gov.previc.virtus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.previc.virtus.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {}