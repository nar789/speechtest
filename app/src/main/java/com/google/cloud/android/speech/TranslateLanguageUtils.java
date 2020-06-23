package com.google.cloud.android.speech;

import android.text.TextUtils;

import java.util.regex.Pattern;

public class TranslateLanguageUtils {
    static String speakerLanguage = "ko-KR";
    static String target = "en";

    static String getTarget(String requestString) {
        if (!TextUtils.isEmpty(target)) {
            return target;
        }
        requestString = requestString.substring(0, 1);
        String autoDetectedTarget = "en";
        if (Pattern.matches("^[a-zA-Z0-9]*$", requestString)) {
            autoDetectedTarget = "kor";
        }
        return autoDetectedTarget;
    }

    static String getLanguageOfDetectedString(String responseString) {
        responseString = responseString.substring(0, 1);
        String speaker = "kor";
        if (Pattern.matches("^[a-zA-Z0-9]*$", responseString)) {
            speaker = "en";
        }
        return speaker;
    }


}
