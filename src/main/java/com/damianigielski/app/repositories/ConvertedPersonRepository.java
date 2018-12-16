package com.damianigielski.app.repositories;

import com.damianigielski.app.entities.ConvertedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertedPersonRepository extends JpaRepository<ConvertedPerson, Integer> {
}
