package com.damianigielski.app.repositories;

import com.damianigielski.app.entities.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Page<Person> findByMigrationStatusIsNull(Pageable pageable);

    @Query(nativeQuery = true,
            value = "UPDATE people SET people.migration_status = '093' WHERE people.person_id IN :#{#personIdList}")
    @Modifying
    void updateMigrationStatus(@Qualifier("personIdList") List<Integer> personIdList);
}
