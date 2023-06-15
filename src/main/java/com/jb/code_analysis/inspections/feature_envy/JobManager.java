package com.jb.code_analysis.inspections.feature_envy;

public class JobManager {
    public void performJob(Job job) {
        job.beforeStart();
        job.process();
        job.afterProcessing();
    }
}
 