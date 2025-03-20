package com.hanghae.module.domain.enums;

public enum Genre {
  ACTION("액션"),
  COMEDY("코미디"),
  DRAMA("드라마"),
  HORROR("공포"),
  SF("SF"),
  ANIMATION("애니메이션"),
  ROMANCE("로맨스"),
  THRILLER("스릴러");

  private final String displayName;

  Genre(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
