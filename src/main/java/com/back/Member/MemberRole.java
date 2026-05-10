package com.back.Member;

import lombok.Getter;

@Getter
public enum MemberRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    MemberRole(String role) {
        this.role = role;
    }

    private String role;
}
