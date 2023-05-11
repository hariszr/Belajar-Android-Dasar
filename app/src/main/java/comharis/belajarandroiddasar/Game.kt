package comharis.belajarandroiddasar

import kotlin.random.Random

object Game  {

    private val options = listOf("ROCK", "SCISSORS", "PAPER")

    private val optionsDrawable = mapOf(
        "ROCK" to R.drawable.rock,
        "SCISSORS" to R.drawable.scissors,
        "PAPER" to R.drawable.paper,
        "LOSE" to R.drawable.lose,
        "WIN" to R.drawable.win,
        "QUESTION" to R.drawable.question,
    )

    private val rules = mapOf(
        "ROCK-PAPER" to false,
        "ROCK-SCISSORS" to true,
        "SCISSORS-ROCK" to false,
        "SCISSORS-PAPER" to true,
        "PAPER-ROCK" to true,
        "PAPER-SCISSORS" to false,
    )

    fun pickRandomOption(): String = options[Random.nextInt(0,3)]

    fun pickDrawable(option: String): Int = optionsDrawable[option]!!

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!
}