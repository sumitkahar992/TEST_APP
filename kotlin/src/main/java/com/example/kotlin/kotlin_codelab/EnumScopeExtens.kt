fun main() {

    Quiz.printProgressBar()

    Quiz().apply {
        printQuiz()
    }


}

val Quiz.StudentProgress.progressText: String      //Add an extension property
    get() = "${answered} of ${total} answered"


fun Quiz.StudentProgress.printProgressBar() {       //Add an extension function
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)

}

class Quiz {

    val question1 = Question<String>("what is your penis ___", "5 inches", Difficulty.EASY)
    val question2 = Question<Int>("what is your Age ? ", 24, Difficulty.MEDIUM)
    val question3 = Question<Boolean>("want to MASTERBATE ?", false, Difficulty.HARD)


    //  Singleton Object
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {                        // scope functions : let, it, this
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}


data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


enum class Difficulty {
    EASY, MEDIUM, HARD
}


/*


class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)


class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)


 */