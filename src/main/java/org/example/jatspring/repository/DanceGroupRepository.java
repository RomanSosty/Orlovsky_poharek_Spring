package org.example.jatspring.repository;

import org.example.jatspring.entity.DanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DanceGroupRepository extends JpaRepository<DanceGroup, Long> {

    @Query("SELECT k FROM DanceGroup k WHERE k.name = :name")
    DanceGroup duplicityDanceGroup(@Param("name") String nameOfClub);
}
