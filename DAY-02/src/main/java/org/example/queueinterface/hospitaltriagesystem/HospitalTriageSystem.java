package org.example.queueinterface.hospitaltriagesystem;

import java.util.PriorityQueue;

// Define a Patient class to store patient details
class Patient implements Comparable<Patient> {
    String name;
    int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Override compareTo method to prioritize higher severity
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity comes first
    }

    // Override toString method for better output
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a PriorityQueue to store patients
        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // Add patients to the queue
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        // Process patients in order of priority
        System.out.println("Treating patients in order of priority:");
        while (!queue.isEmpty()) {
            Patient patient = queue.poll(); // Get and remove the patient with the highest priority
            System.out.println("Treating: " + patient);
        }
    }
}
