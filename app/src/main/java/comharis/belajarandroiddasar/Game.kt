package comharis.belajarandroiddasar

import kotlin.random.Random

object Game  {

    private val options = listOf("ROCK", "SCISSORS", "PAPER")

    private val optionsDrawable = mapOf(
        "ROCK" to R.drawable.Rock,
        "SCISSORS" to R.drawable.Scissors,
        "PAPER" to R.drawable.Paper,
        "LOSE" to R.drawable.Lose,
        "WIN" to R.drawable.Win,
        "QUESTION" to R.drawable.Question,
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

    fun isWin(from: String, to: String): Boolean = rules["$from=$to"]!!
}