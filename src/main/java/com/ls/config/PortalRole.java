package com.ls.config;

public enum PortalRole {

    SUPER_ADMIN (Types.SUPER_ADMIN),
    CHANCELLOR (Types.CHANCELLOR),
    PARENT (Types.PARENT),
    TEACHER (Types.TEACHER);


    public class Types{
        public static final String SUPER_ADMIN = "SUPER_ADMIN";
        public static final String CHANCELLOR = "CHANCELLOR";
        public static final String PARENT = "PARENT";
        public static final String TEACHER = "TEACHER";
    }


    String type;
    PortalRole(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}
