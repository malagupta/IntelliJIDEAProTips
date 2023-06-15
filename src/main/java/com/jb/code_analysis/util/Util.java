package com.jb.code_analysis.util;

import com.jb.code_analysis.inspections.feature_envy.Job;
import com.jb.code_analysis.inspections.feature_envy.JobManager;

public class Util {
    public static void main(String[] args) {
        new JobManager().performJob(new Job());
    }
}
