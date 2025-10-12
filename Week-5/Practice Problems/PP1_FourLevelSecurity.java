package com.company.security;

public class PP1_FourLevelSecurity {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    public PP1_FourLevelSecurity(int p, String d, double pr, boolean pub) {
        privateField = p;
        defaultField = d;
        protectedField = pr;
        publicField = pub;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public void testInternalAccess() {
        System.out.println("PrivateField: " + privateField);
        System.out.println("DefaultField: " + defaultField);
        System.out.println("ProtectedField: " + protectedField);
        System.out.println("PublicField: " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        PP1_FourLevelSecurity obj = new PP1_FourLevelSecurity(10, "Hello", 99.9, true);
        // obj.privateField → Error
        // obj.privateMethod() → Error
        obj.testInternalAccess();
    }
}