package com.rubahapi.footballclub.util

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat

class UtilsKtTest {

    @Test
    fun toSimpleString() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = dateFormat.parse("2018-02-28")
        assertEquals("Wed, 28 Feb 2018", toSimpleString(date))
    }
}