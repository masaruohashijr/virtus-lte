package br.gov.previc.virtus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.previc.virtus.domain.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {}
