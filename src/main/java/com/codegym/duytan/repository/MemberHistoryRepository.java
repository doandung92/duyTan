package com.codegym.duytan.repository;

import com.codegym.duytan.entity.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer>, JpaSpecificationExecutor<MemberHistory> {
}
