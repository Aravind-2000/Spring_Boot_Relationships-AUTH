package com.futura.test.Auth;

public class LogOutRequest {
  private Long userId;

  private String refreshToken;

  public String getRefreshToken() {
    return refreshToken;
  }

  public Long getUserId() {
    return this.userId;
  }
}
