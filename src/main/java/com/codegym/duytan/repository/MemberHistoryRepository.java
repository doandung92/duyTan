package com.codegym.duytan.repository;

import com.codegym.duytan.entity.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer>,
        JpaSpecificationExecutor<MemberHistory> {
}
