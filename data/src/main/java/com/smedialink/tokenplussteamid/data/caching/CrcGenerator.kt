package com.smedialink.tokenplussteamid.data.caching

import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.util.zip.CRC32
import javax.inject.Inject

/**
 * Created by six_hundreds on 15.04.18.
 */
class CrcGenerator @Inject constructor() {

    private val crc = CRC32()

    fun generateCrc(data: Any): Long {
        val bos = ByteArrayOutputStream()
        val out = ObjectOutputStream(bos)
        out.use {
            out.writeObject(data)
            out.flush()
            crc.update(bos.toByteArray())
        }
        val result = crc.value
        crc.reset()
        return result
    }
}