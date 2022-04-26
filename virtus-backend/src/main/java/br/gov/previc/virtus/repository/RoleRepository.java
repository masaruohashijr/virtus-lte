package br.gov.previc.virtus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.previc.virtus.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}