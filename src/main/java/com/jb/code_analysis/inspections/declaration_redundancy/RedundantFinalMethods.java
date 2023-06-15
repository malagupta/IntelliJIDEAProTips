package com.jb.code_analysis.inspections.declaration_redundancy;

public class RedundantFinalMethods {

    record Person(int age) {
        public static final int VOTING_AGE = 18;

        final boolean isEligibleToVote() {
            return age >= VOTING_AGE;
        }
    }

}
