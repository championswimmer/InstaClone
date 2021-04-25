package com.scaler.libimgur

import org.junit.Assert.assertEquals
import org.junit.Test

class ImgurClientTests {

    @Test
    fun sampleTest() {
        assertEquals(true, true)
    }

    @Test
    fun `GET gallery top works`() {
        val client = ImgurClient()
        val response = client.api.getGallery("top").execute()
        assertEquals(200, response.code())
    }

    @Test
    fun `GET gallery hot works`() {
        val client = ImgurClient()
        val response = client.api.getGallery("hot").execute()
        assertEquals(200, response.code())
    }

    @Test
    fun `GET tags works`() {
        val client = ImgurClient()
        val response = client.api.getTags().execute()
        assertEquals(200, response.code())
    }
}