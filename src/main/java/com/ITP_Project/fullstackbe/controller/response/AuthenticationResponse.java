package com.ITP_Project.fullstackbe.controller.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

    @JsonProperty("user_id")
    private Long userId;
    private Boolean authenticated;

    public AuthenticationResponse(Long userId, Boolean authenticated) {
        this.userId = userId;
        this.authenticated = authenticated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }
}
