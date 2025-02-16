package org.example.insurancepolicymanagementsystemUsingSet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<Policy> getAllPolicies() {
        return hashSetPolicies;
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        LocalDate today = LocalDate.now();
        for (Policy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> result = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public Set<String> findDuplicatePolicies() {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<String> duplicatePolicies = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                duplicatePolicies.add(policy.getPolicyNumber());
            }
        }
        return duplicatePolicies;
    }

    public void comparePerformance() {
        int size = 10000;
        List<Policy> samplePolicies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            samplePolicies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 500 + i));
        }

        long start, end;

        //HashSet Performance
        start = System.nanoTime();
        Set<Policy> hashSet = new HashSet<>(samplePolicies);
        end = System.nanoTime();
        System.out.println("HashSet Insertion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.remove(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("HashSet Removal Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        Set<Policy> linkedHashSet = new LinkedHashSet<>(samplePolicies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Insertion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.remove(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Removal Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        Set<Policy> treeSet = new TreeSet<>(samplePolicies);
        end = System.nanoTime();
        System.out.println("TreeSet Insertion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(samplePolicies.get(size / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Removal Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P003", "Carol", LocalDate.now().plusDays(20), "Home", 7000));
        system.addPolicy(new Policy("P004", "Dave", LocalDate.now().plusDays(5), "Health", 6000));
        system.addPolicy(new Policy("P001", "Eve", LocalDate.now().plusDays(15), "Auto", 4000)); // Duplicate

        System.out.println("All Policies: " + system.getAllPolicies());
        System.out.println("Policies Expiring Soon: " + system.getPoliciesExpiringSoon());
        System.out.println("Health Policies: " + system.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + system.findDuplicatePolicies());

        system.comparePerformance();
    }
}
