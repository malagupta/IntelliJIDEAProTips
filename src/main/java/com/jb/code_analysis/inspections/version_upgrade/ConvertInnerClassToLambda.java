package com.jb.code_analysis.inspections.version_upgrade;
import java.util.Comparator;
import java.util.List;

record Label(String name) {}

public class ConvertInnerClassToLambda {

    static void sort(List<Label> personList) {
        personList.sort(new Comparator<Label>() {
            @Override
            public int compare(Label o1, Label o2) {
                return o1.name().compareToIgnoreCase(o2.name());
            }
        });
    }

}
