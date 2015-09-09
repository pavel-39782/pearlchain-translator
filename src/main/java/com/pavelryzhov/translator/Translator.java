package com.pavelryzhov.translator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Pavel Ryzhov
 */
public class Translator {

    private static final char TRANSLATION_KEY_DELIMITER = '.';

    private final Properties dictionary;

    public Translator(String propertiesFilepath) throws IOException {
        this(new File(propertiesFilepath));
    }

    public Translator(File propertiesFile) throws IOException {
        try (InputStream input = new FileInputStream(propertiesFile)) {
            dictionary = new Properties();
            dictionary.load(input);
        }
    }

    public String getTranslationValue(String translationKey) {
        if (translationKey == null) {
            return null;
        }

        String value = dictionary.getProperty(translationKey);
        if (value != null) {
            return value;
        }

        int firstDelimiterIndex;
        do {
            firstDelimiterIndex = translationKey.indexOf(TRANSLATION_KEY_DELIMITER);
            translationKey = translationKey.substring(firstDelimiterIndex + 1);
            value = dictionary.getProperty(translationKey);
            if (value != null) {
                return value;
            }
        } while (firstDelimiterIndex != -1);

        return null;
    }
}
