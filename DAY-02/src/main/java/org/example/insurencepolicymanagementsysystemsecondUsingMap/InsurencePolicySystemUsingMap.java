package org.example.insurencepolicymanagementsysystemsecondUsingMap;

import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{Number='" + policyNumber + "', Holder='" + policyHolder + "', Expiry=" + expiryDate + "}";
    }
}
class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, Policy> entry : sortedPolicyMap.subMap(today, true, next30Days, true).entrySet()) {
            expiringPolicies.add(entry.getValue());
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, Policy>> iterator = sortedPolicyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, Policy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                Policy expiredPolicy = entry.getValue();
                policyMap.remove(expiredPolicy.policyNumber);
                orderedPolicyMap.remove(expiredPolicy.policyNumber);
                iterator.remove();
            }
        }
    }

    // Display all policies
    public void displayPolicies() {
        for (Policy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurencePolicySystemUsingMap {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding policies
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(20)));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P1003", "Alice", LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P1004", "Charlie", LocalDate.now().minusDays(5)));

        // Display all policies
        System.out.println("All Policies:");
        manager.displayPolicies();

        // Get a policy by number
        System.out.println("\nPolicy P1001: " + manager.getPolicy("P1001"));

        // List policies expiring in 30 days
        System.out.println("\nPolicies expiring in the next 30 days:");
        for (Policy policy : manager.getExpiringPolicies()) {
            System.out.println(policy);
        }

        // List policies for Alice
        System.out.println("\nPolicies for Alice:");
        for (Policy policy : manager.getPoliciesByHolder("Alice")) {
            System.out.println(policy);
        }

        // Remove expired policies and display remaining policies
        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        manager.displayPolicies();
    }
}