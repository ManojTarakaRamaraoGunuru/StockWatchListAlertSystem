package org.stockManagement.constants;

public enum Roles {
    ADMIN,
    USER;

    public String getRole(){
        return this.name();
    }
}
