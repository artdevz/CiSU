package com.CiSU.enums;

public enum ERole {
    
    ROLE_USER ("USER"),
    ROLE_ADMIN ("ADMIN");

    private final String role;
    
    ERole(String role) {
        this.role = role;
    }
 
    public String getRole() {
        return role;
    }

}
