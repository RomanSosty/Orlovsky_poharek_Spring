package org.example.jatspring.repository;

import org.example.jatspring.entity.DanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanceGroupRepository extends JpaRepository<DanceGroup, Long> {

    @Query("SELECT k FROM DanceGroup k WHERE k.name = :name")
    List<DanceGroup> duplicityDanceGroup(@Param("name") String nameOfClub);
}
