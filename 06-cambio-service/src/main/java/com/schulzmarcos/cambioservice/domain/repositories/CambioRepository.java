package com.schulzmarcos.cambioservice.domain.repositories;

import com.schulzmarcos.cambioservice.domain.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);
}
