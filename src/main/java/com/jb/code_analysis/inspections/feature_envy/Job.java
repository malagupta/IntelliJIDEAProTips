package com.jb.code_analysis.inspections.feature_envy;

public class Job {
    public void perform() {
        beforeStart();
        process();
        afterProcessing();
    }

    public void beforeStart() {
    }

    public void process() {
    }

    public void afterProcessing() {
    }

}
