package com.finradar.android.data.parser

object SmsPatternRegistry {
    val patterns = mapOf(
        "Garanti BBVA" to Regex("""(\d+[\.,]\d+)\s?TL.*?(\w+)'(?:den|dan|ten|tan)"""),
        "İş Bankası" to Regex("""Harcama:\s*(\d+[\.,]\d+)\s?TL\s+(\w[\w\s]+)"""),
        "Yapı Kredi" to Regex("""(\d+[\.,]\d+)TL tutarinda.*?(\w+)'(?:a|e|ye|ya)"""),
        "Akbank" to Regex("""(\d+[\.,]\d+) TL.*?\.(\w[\w\s]+)\."""),
        "Ziraat Bankası" to Regex("""Harcamaniz:\s*(\d+[\.,]\d+)\s?TL""")
    )
}
