package com.telecom.Wezen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.Wezen.entity.Usage_Details;

@Repository
public interface UsageRepository extends JpaRepository<Usage_Details, Long> {
}
