package com.jump2digital.challenge.v1.testdocuments;

import com.jump2digital.challenge.v1.documents.Skin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkinTest {

    private Skin skin;

    @BeforeEach
    public void setUp() {
        // Create a Skin object for testing
        skin = new Skin();
        skin.setId(1);
        skin.setName("Test Skin");
        skin.setDescription("Test Description");
        skin.setAuthor("Test Author");
        skin.setPrice(10);
        skin.setColor("Test Color");
    }

    @Test
    public void testSkinProperties() {
        assertEquals(1, skin.getId());
        assertEquals("Test Skin", skin.getName());
        assertEquals("Test Description", skin.getDescription());
        assertEquals("Test Author", skin.getAuthor());
        assertEquals(10, skin.getPrice());
        assertEquals("Test Color", skin.getColor());
    }

    /*@Test
    public void testSkinToString() {
        String expectedString = "Skin{id=1, name='Test Skin', description='Test Description', author='Test Author', price=10, color='Test Color'}";
        assertEquals(expectedString, skin.toString());
    }*/
}

