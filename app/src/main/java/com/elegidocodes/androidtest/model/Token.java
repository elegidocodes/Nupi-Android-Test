package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.Instant;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Token {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;

    private Instant createdAt;
    private boolean expired;

    public Token() {
        this.createdAt = Instant.now(); // Set creation time when token is instantiated
        this.expired = false; // Initially not expired
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isExpired() {
        return expired;
    }

    /**
     * Checks if the token has expired based on the current time.
     * Updates the expired field accordingly.
     *
     * @return true if the token has expired, false otherwise
     */
    public boolean checkExpired() {
        if (expiresIn == null || expiresIn <= 0) {
            this.expired = false; // Never expires if expiresIn is null or <= 0
            return false;
        }

        Instant now = Instant.now();
        Instant expirationTime = createdAt.plusSeconds(expiresIn);
        this.expired = now.isAfter(expirationTime);
        return this.expired;
    }

    /**
     * Calculates how many seconds remain until the token expires.
     *
     * @return seconds remaining until expiration, or null if expiresIn is not set
     */
    public Long getSecondsUntilExpiration() {
        if (expiresIn == null) {
            return null;
        }

        Instant now = Instant.now();
        Instant expirationTime = createdAt.plusSeconds(expiresIn);
        long secondsRemaining = expirationTime.getEpochSecond() - now.getEpochSecond();
        return secondsRemaining > 0 ? secondsRemaining : 0;
    }

    @Override
    public String toString() {
        return "Token{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", createdAt=" + createdAt +
                ", expired=" + expired +
                '}';
    }

}
