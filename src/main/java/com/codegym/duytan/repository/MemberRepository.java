package com.codegym.duytan.repository;

import com.codegym.duytan.dto.MemberDto;
import com.codegym.duytan.entity.Member;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer>,
        JpaSpecificationExecutor<Member> {
    Optional<Member> findByUsername(String username);
}
