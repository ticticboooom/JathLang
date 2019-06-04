package IO

import java.io.File

object IOFileReader {
    fun Read(path: String): String{
        return File(path).readText()
    }
}