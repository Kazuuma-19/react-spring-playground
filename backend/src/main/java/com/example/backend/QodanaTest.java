package com.example.backend;

public class QodanaTest {
    public static void main(String[] args) {
        // Test case 1: Obvious null pointer dereference
        String str = null;
        System.out.println(str.length());
        
        // Test case 2: Dead code
        if (true) {
            System.out.println("This always runs");
        } else {
            System.out.println("This never runs");
        }
        
        // Test case 3: Constant condition  
        boolean flag = false;
        if (flag) {
            System.out.println("Unreachable code");
        }
        
        // Test case 4: Unused variable
        int unusedVariable = 42;
    }
}
