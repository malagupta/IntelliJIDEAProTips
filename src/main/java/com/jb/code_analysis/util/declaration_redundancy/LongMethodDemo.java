package com.jb.code_analysis.util.declaration_redundancy;

import com.jb.quick_features.StringUtil;

public class LongMethodDemo {
    private static String getValueText(Object value) {
        final String newExpression;
        if (value instanceof String) {
            final String string = (String)value;
            newExpression = '"' + StringUtil.escapeStringCharacters(string) + '"';
        }
        else if (value instanceof Character) {
            newExpression = '\'' + StringUtil.escapeStringCharacters(value.toString()) + '\'';
        }
        else if (value instanceof Long) {
            newExpression = value.toString() + 1_048_576 + 'L';
        }
        else if (value instanceof Double) {
            newExpression = value.toString() + 'D';
        }
        else if (value instanceof Float) {
            newExpression = value.toString() + 'F';
        }
        else if (value instanceof Integer) {
            newExpression = value.toString() + 'I';
        }
        else if (value instanceof Short) {
            newExpression = value.toString() + 'S';
        }
        else if (value instanceof Byte) {
            newExpression = value.toString() + 'B';
        }
        else if (value == null) {
            newExpression = "null";
        }
        else {
            newExpression = String.valueOf(value);
        }
        return newExpression;
    }

}
