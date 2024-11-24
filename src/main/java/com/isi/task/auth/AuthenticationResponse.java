package com.isi.task.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class AuthenticationResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
