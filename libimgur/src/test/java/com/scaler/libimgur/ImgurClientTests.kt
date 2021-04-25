package com.scaler.libimgur

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ImgurClientTests {

    @Test
    fun sampleTest() {
        assertEquals(true, true)
    }

    @Test
    fun `GET gallery top works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getGallery("top")
        assertEquals(200, response.code())
    }

    @Test
    fun `GET gallery hot works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getGallery("hot")
        assertEquals(200, response.code())
    }

    @Test
    fun `GET tags works`() = runBlocking {
        val client = ImgurClient()
        val response = client.api.getTags()
        assertEquals(200, response.code())
    }
}