package com.pavelryzhov.translator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Pavel Ryzhov
 */
public class TranslatorTest {

    private static final String DICTIONARY_FILEPATH = "src/test/resources/dictionary.properties";

    private Translator translator;

    @Before
    public void setUp() throws Exception {
        translator = new Translator(DICTIONARY_FILEPATH);
    }

    @Test
    public void testGetTranslationValue() throws Exception {
        assertEquals("First Name", translator.getTranslationValue("firstName"));
        assertEquals("Equipment First Name", translator.getTranslationValue("equipmentForm.firstName"));
        assertEquals("First Name", translator.getTranslationValue("orderForm.firstName"));
        assertEquals("First Name", translator.getTranslationValue("orderView.orderForm.firstName"));
        assertEquals("First Name", translator.getTranslationValue("..firstName"));
        assertEquals("First Name", translator.getTranslationValue("a text with spaces.firstName"));

        assertNull(translator.getTranslationValue("lastName"));
        assertNull(translator.getTranslationValue("Form.first"));
        assertNull(translator.getTranslationValue("orderForm"));
        assertNull(translator.getTranslationValue(".."));
        assertNull(translator.getTranslationValue("First Name"));
        assertNull(translator.getTranslationValue("equipment"));
        assertNull(translator.getTranslationValue("\\"));
        assertNull(translator.getTranslationValue(null));
    }
}