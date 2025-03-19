package com.hanghae.module.common.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    // 실제 애플리케이션에서는 현재 인증된 사용자 정보를 반환
    // 인증 시스템 통합 시 이 부분을 수정
    return Optional.of("SYSTEM");
  }
}
