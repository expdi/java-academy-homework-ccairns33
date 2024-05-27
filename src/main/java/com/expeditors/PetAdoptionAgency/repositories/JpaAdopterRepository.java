package com.expeditors.PetAdoptionAgency.repositories;

import com.expeditors.PetAdoptionAgency.domain.JpaAdopter;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("jpa-dev")
@Repository // persistence layer
public interface JpaAdopterRepository extends CrudRepository<JpaAdopter, Integer> {
    Optional<JpaAdopter> findByName(String name);


    @Query("SELECT a from JpaAdopter a where a.dateOfAdoption is not null ")
    Iterable<JpaAdopter> findAllWithDateOfAdoption();
}
