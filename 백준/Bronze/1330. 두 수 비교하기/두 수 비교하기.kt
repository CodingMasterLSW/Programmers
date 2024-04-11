
import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)) {
    var a = nextInt()
    var b = nextInt()

    if(a>b){
        println(">")
    } else if (a<b){
        println("<")
    } else{
        println("==")
    }
}
