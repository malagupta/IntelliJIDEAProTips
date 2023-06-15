package com.jb.code_analysis.inspections.chain_instanceof;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransformBodyToSingleExitPointFormTest {
    @Test
    @DisplayName("testGetArea")
    void testGetArea() {
        UseNewFeatures body = new UseNewFeatures();
        System.out.println(body.getArea(new Cirle(12)));
    }
}