package com.finradar.android.data.parser

import org.junit.Assert.*
import org.junit.Test

class SmsParserTest {

    private val parser = SmsParser()

    @Test
    fun parseGarantiSms() {
        val message = "450,00 TL Netflix'ten harcama"
        val transaction = parser.parseSms("Garanti", message, 1000L)
        assertNotNull(transaction)
        assertEquals(450.00, transaction?.amount!!, 0.01)
        assertEquals("Netflix", transaction.merchantName)
    }

    @Test
    fun parseIsBankasiSms() {
        val message = "Harcama: 89,99 TL Spotify"
        val transaction = parser.parseSms("IsBankasi", message, 1000L)
        assertNotNull(transaction)
        assertEquals(89.99, transaction?.amount!!, 0.01)
        assertEquals("Spotify", transaction.merchantName)
    }

    @Test
    fun parseYapiKrediSms() {
        val message = "199,00TL tutarinda Adobe'ye"
        val transaction = parser.parseSms("YapiKredi", message, 1000L)
        assertNotNull(transaction)
        assertEquals(199.00, transaction?.amount!!, 0.01)
        assertEquals("Adobe", transaction.merchantName)
    }

    @Test
    fun parseAkbankSms() {
        val message = "249.00 TL. AWS TR."
        val transaction = parser.parseSms("Akbank", message, 1000L)
        assertNotNull(transaction)
        assertEquals(249.00, transaction?.amount!!, 0.01)
        assertEquals("AWS TR", transaction.merchantName)
        // Note: The regex might capture "AWS TR" or similar depending on the dot.
        // Regex: (\d+[\.,]\d+) TL.*?\.(\w[\w\s]+)\.
        // It expects text between dots. " AWS TR" might be captured with leading space.
        // Parser trims it.
    }

    @Test
    fun parseZiraatSms() {
        val message = "Harcamaniz: 59,90 TL"
        val transaction = parser.parseSms("Ziraat", message, 1000L)
        assertNotNull(transaction)
        assertEquals(59.90, transaction?.amount!!, 0.01)
        assertEquals("Bilinmeyen İşyeri", transaction.merchantName)
    }
}
