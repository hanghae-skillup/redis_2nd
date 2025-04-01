package com.hanghae.member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
}
