package com.hanghae.module.domain.model;

import lombok.Builder;

@Builder
public record Theater(
  Long id,
  String name
) {
}
