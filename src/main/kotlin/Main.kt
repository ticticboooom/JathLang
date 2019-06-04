import IO.IOFileReader
import parsing.JathParser
import javax.swing.text.html.parser.Parser

fun main(args : Array<String>) {
    val path = args[0]
    val code = IOFileReader.Read(path)
    val parsedTokens = JathParser().Parse(code)
    println(parsedTokens)
}