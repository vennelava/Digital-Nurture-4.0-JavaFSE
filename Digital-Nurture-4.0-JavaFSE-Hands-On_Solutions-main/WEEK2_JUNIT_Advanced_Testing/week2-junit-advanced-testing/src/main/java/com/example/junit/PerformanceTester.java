package com.example.junit;

public class PerformanceTester {

    public void performTask() {
        
        try {
            Thread.sleep(100); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }
}
