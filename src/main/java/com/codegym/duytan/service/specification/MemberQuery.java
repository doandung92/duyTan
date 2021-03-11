package com.codegym.duytan.service.specification;

import com.codegym.duytan.entity.Member;
import com.codegym.duytan.entity.Member_;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class MemberQuery {

    public Specification<Member> findActiveMembers(){
        return ((root, query, cb) -> cb.equal(root.get(Member_.USE_FLAG), true));
    }
}
