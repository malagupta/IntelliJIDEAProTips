package com.jb.quick_features;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class StringUtil {
    public static String escapeStringCharacters(@NotNull String s) {
        StringBuilder builder = new StringBuilder(s.length());
        escapeStringCharacters(s.length(), s, "\"", builder);
        return builder.toString();
    }


    @NotNull
    @Contract(pure = true)
    public static String join(@NotNull final String[] strings, @NotNull final String separator) {
        return join(strings, 0, strings.length, separator);
    }
    @NotNull
    @Contract(pure = true)
    public static String join(@NotNull final String[] strings,
                              int startIndex,
                              int endIndex,
                              @NotNull final String separator) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) stringBuilder.append(separator);
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }

    @NotNull
    @Contract(pure = true)
    public static String first(@NotNull String text, final int maxLength, final boolean appendEllipsis) {
        return text.length() > maxLength ? text.substring(0, maxLength) + (appendEllipsis ? "..." : "") : text;
    }

    public static void escapeStringCharacters(int length, @NotNull String str, @NotNull StringBuilder buffer) {
        escapeStringCharacters(length, str, "\"", buffer);
    }

    @NotNull
    public static StringBuilder escapeStringCharacters(int length,
                                                       @NotNull String str,
                                                       @Nullable String additionalChars,
                                                       @NotNull StringBuilder buffer) {
        return escapeStringCharacters(length, str, additionalChars, true, buffer);
    }

    @NotNull
    public static StringBuilder escapeStringCharacters(int length,
                                                       @NotNull String str,
                                                       @Nullable String additionalChars,
                                                       boolean escapeSlash,
                                                       @NotNull StringBuilder buffer) {
        return escapeStringCharacters(length, str, additionalChars, escapeSlash, true, buffer);
    }

    public static void escapeStringCharacters2(int length,
                                                       @NotNull String str,
                                                       @Nullable String additionalChars,
                                                       boolean escapeSlash,
                                                       boolean escapeUnicode,
                                                       @NotNull StringBuilder buffer) {
        char prev = 0;
        for (int idx = 0; idx < length; idx++) {
            char ch = str.charAt(idx);
            switch (ch) {
                case '\b':
                    buffer.append("\\b");
                    break;
                case '\t':
                    buffer.append("\\t");
                    break;
                case '\n':
                    buffer.append("\\n");
                    break;
                case '\f':
                    buffer.append("\\f");
                    break;
                case '\r':
                    buffer.append("\\r");
                    break;
                default:
                    if (escapeSlash && ch == '\\') {
                        buffer.append("\\\\");
                    }
                    else if (additionalChars != null && additionalChars.indexOf(ch) > -1 && (escapeSlash || prev != '\\')) {
                        buffer.append("\\").append(ch);
                    }
            }
        }
    }

    @NotNull
    public static StringBuilder escapeStringCharacters(int length,
                                                       @NotNull String str,
                                                       @Nullable String additionalChars,
                                                       boolean escapeSlash,
                                                       boolean escapeUnicode,
                                                       @NotNull StringBuilder buffer) {
        char prev = 0;
        for (int idx = 0; idx < length; idx++) {
            char ch = str.charAt(idx);
            switch (ch) {
                case '\b':
                    buffer.append("\\b");
                    break;
                case '\t':
                    buffer.append("\\t");
                    break;
                case '\n':
                    buffer.append("\\n");
                    break;
                case '\f':
                    buffer.append("\\f");
                    break;
                case '\r':
                    buffer.append("\\r");
                    break;
                default:
                    if (escapeSlash && ch == '\\') {
                        buffer.append("\\\\");
                    }
                    else if (additionalChars != null && additionalChars.indexOf(ch) > -1 && (escapeSlash || prev != '\\')) {
                        buffer.append("\\").append(ch);
                    }
                    else if (escapeUnicode && !isPrintableUnicode(ch)) {
                        CharSequence hexCode = toUpperCase(Integer.toHexString(ch));
                        buffer.append("\\u");
                        int paddingCount = 4 - hexCode.length();
                        while (paddingCount-- > 0) {
                            buffer.append(0);
                        }
                        buffer.append(hexCode);
                    }
                    else {
                        buffer.append(ch);
                    }
            }
            prev = ch;
        }
        return buffer;
    }

    public static boolean isPrintableUnicode(char c) {
        int t = Character.getType(c);
        return t != Character.UNASSIGNED && t != Character.LINE_SEPARATOR && t != Character.PARAGRAPH_SEPARATOR &&
               t != Character.CONTROL && t != Character.FORMAT && t != Character.PRIVATE_USE && t != Character.SURROGATE;
    }

    @Contract(value = "null -> null; !null -> !null", pure = true)
    public static String toUpperCase(String s) {
        return s == null ? null : s.toUpperCase(Locale.ENGLISH);
    }

    private static void unescapeStringCharacters(int length,
                                                 @NotNull String s,
                                                 @NotNull StringBuilder buffer) {
        boolean escaped = false;
        for (int idx = 0; idx < length; idx++) {
            char ch = s.charAt(idx);
            if (!escaped) {
                if (ch == '\\') {
                    escaped = true;
                }
                else {
                    buffer.append(ch);
                }
            }
            else {
                int octalEscapeMaxLength = 2;
                switch (ch) {
                    case 'n':
                        buffer.append('\n');
                        break;

                    case 'r':
                        buffer.append('\r');
                        break;

                    case 'b':
                        buffer.append('\b');
                        break;

                    case 't':
                        buffer.append('\t');
                        break;

                    case 'f':
                        buffer.append('\f');
                        break;

                    case '\'':
                        buffer.append('\'');
                        break;

                    case '\"':
                        buffer.append('\"');
                        break;

                    case '\\':
                        buffer.append('\\');
                        break;

                    case 'u':
                        if (idx + 4 < length) {
                            try {
                                int code = Integer.parseInt(s.substring(idx + 1, idx + 5), 16);
                                //noinspection AssignmentToForLoopParameter
                                idx += 4;
                                buffer.append((char)code);
                            }
                            catch (NumberFormatException e) {
                                buffer.append("\\u");
                            }
                        }
                        else {
                            buffer.append("\\u");
                        }
                        break;

                    case '0':
                    case '1':
                    case '2':
                    case '3':
                        octalEscapeMaxLength = 3;
                        //noinspection fallthrough
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        int escapeEnd = idx + 1;
                        while (escapeEnd < length && escapeEnd < idx + octalEscapeMaxLength && isOctalDigit(s.charAt(escapeEnd))) escapeEnd++;
                        try {
                            buffer.append((char)Integer.parseInt(s.substring(idx, escapeEnd), 8));
                        }
                        catch (NumberFormatException e) {
                            throw new RuntimeException("Couldn't parse " + s.substring(idx, escapeEnd), e); // shouldn't happen
                        }
                        //noinspection AssignmentToForLoopParameter
                        idx = escapeEnd - 1;
                        break;

                    default:
                        buffer.append(ch);
                        break;
                }
                escaped = false;
            }
        }

        if (escaped) buffer.append('\\');
    }
    @Contract(pure = true)
    public static boolean isHexDigit(char c) {
        return '0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F';
    }

    @Contract(pure = true)
    public static boolean isOctalDigit(char c) {
        return '0' <= c && c <= '7';
    }

}
