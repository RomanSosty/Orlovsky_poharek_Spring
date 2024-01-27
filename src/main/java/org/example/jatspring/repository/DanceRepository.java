package org.example.jatspring.repository;

import org.example.jatspring.entity.Dance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceRepository extends JpaRepository<Dance, Long> {
}
