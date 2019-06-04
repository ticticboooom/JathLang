package parsing

class JathParser {
    private val keywords = arrayOf("fnc", "var")
    private val operators = arrayOf("+", "-", "++", "--", "*", "/", ".", "(", ")")
    private val reString = "(((=)|(;)|(\\.)|(\\[)|(\\])|(\\()|(\\))|(\\{)|(\\})))|(((\\d+)\\.(\\d+))|(\\d+))|((\\\"\".+\\\"\")|('.+')|(\\\"\"\\\"\")|(''))|(\\w+)|([\\w_\\d-]+){1,}"
    fun Parse(code : String): Array<ParsedToken>{
        val regex = Regex(reString, RegexOption.MULTILINE)
        val separatedCode = regex.findAll(code)
        val result = Array(separatedCode.count() + 1, init = {ParsedToken("\\", ParsedTokenType.Identifier)})
        for ((i, value) in separatedCode.withIndex()){
            result[i + 1] = ParsedToken(value.value, getTokenType(value.value))
        }
        return result
    }
    private fun getTokenType(token: String): ParsedTokenType{
        if (keywords.contains(token)){
            return ParsedTokenType.Keyword
        }
        if (operators.contains(token)) {
            return ParsedTokenType.Operator
        }
        return ParsedTokenType.Identifier
    }
}