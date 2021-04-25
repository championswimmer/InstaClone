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
        val response = client.api.getGallery().execute()
        assertEquals(200, response.code())
    }
}