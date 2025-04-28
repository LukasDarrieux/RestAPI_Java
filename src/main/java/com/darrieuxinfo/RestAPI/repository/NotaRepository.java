package com.darrieuxinfo.RestAPI.repository;

import com.darrieuxinfo.RestAPI.models.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
