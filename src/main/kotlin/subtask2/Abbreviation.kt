package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var result: String = ""
        for (char in a) {
            if (b.contains(char, true)) {
                if(!b.contains(char.toUpperCase(),false)) return "NO"
                result+=char.toUpperCase()
            }
        }
        if(result==b){
            return "YES"
        } else{
            return "NO"
        }
    }
}
