package com.akog02.common;

public enum RolesEnum {

    SYSADMIN(1, "ROLE_SYSADMIN"),
    POSTWRITER(2, "ROLE_POSTWRITER"),
    BLOGUSER(3, "ROLE_BLOGUSER"),
	ANOMYNOUS(4, "ROLE_ANOMYNOUS");
	
    private final int id;

    private final String roleName;

    RolesEnum(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
