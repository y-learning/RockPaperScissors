enum class Choice {
    ROCK, PAPER, SCISSORS
}

val gameChoices = arrayOf(Choice.ROCK, Choice.PAPER, Choice.SCISSORS)

fun pickAChoice(): Choice = gameChoices[(Math.random() * gameChoices.size).toInt()]

fun printChoiceRequest() {
    print("Please enter one of the following choices: ")
    for (choice in gameChoices) print("$choice ")
}

tailrec fun readPlayerInput(): Choice {
    printChoiceRequest()
    val input = readLine()?.trim()?.toUpperCase()

    if (input != null) {
        val playerChoice = Choice.valueOf(input)
        if (gameChoices.contains(playerChoice)) return playerChoice
    }

    return readPlayerInput()
}

private fun decideTheWinner(aiChoice: Choice, playerChoice: Choice): String {
    return if (aiChoice == playerChoice) "It's a draw!"
    else if (
        (playerChoice == Choice.ROCK && aiChoice == Choice.SCISSORS) ||
        (playerChoice == Choice.PAPER && aiChoice == Choice.ROCK) ||
        (playerChoice == Choice.SCISSORS && aiChoice == Choice.PAPER)
    ) "You win!"
    else "You lose!"
}

fun printResult(aiChoice: Choice, playerChoice: Choice) {
    val result: String = decideTheWinner(aiChoice, playerChoice)

    println("$result I chose $aiChoice")
}

fun main() {
    val aiChoice = pickAChoice()
    val playerChoice = readPlayerInput()
    printResult(aiChoice, playerChoice)
}