package com.marwa.myCatalogue.dao;

import com.marwa.myCatalogue.entities.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface TvaRepository extends JpaRepository<Tva, Long> {

    @RestResource(path = "/byTva")
    public List<Tva> findByTauxTva(@Param("tva") double tva);
}
