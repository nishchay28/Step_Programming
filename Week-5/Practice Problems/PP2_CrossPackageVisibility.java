package com.company.extended;

import com.company.security.PP1_FourLevelSecurity;

public class PP2_CrossPackageVisibility extends PP1_FourLevelSecurity {

    public PP2_CrossPackageVisibility() {
        super(1, "Default", 2.2, true);
    }

    public void testInheritedAccess() {
        // privateField → Not accessible
        // defaultField → Not accessible
        System.out.println("ProtectedField: " + protectedField); // Accessible
        System.out.println("PublicField: " + publicField);       // Accessible
        protectedMethod(); // Accessible
        publicMethod();    // Accessible
    }

    public static void main(String[] args) {
        PP2_CrossPackageVisibility child = new PP2_CrossPackageVisibility();
        child.testInheritedAccess();
    }
}
