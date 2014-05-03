package com.duffmanstudios.memory.terminal.io

/**
 * Contains static utility methods for reading console input when playing the game
 *
 * @author Iain Duff
 */
object UserInputReader {

  val ENTER_NUM_CARDS_MESSAGE = "Enter number of cards to use: "
  val ENTER_NUM_PLAYERS_MESSAGE = "Enter number of players: "
  val SELECT_CARD_MESSAGE = "Select a card: "

  val SUCCESSFUL_NUM_CARDS_READ_MESSAGE = "Number of cards in the game: "
  val SUCCESSFUL_NUM_PLAYERS_READ_MESSAGE = "Number of players: "
  val SUCCESSFUL_CARD_SELECT_MESSAGE = "Selected card: "


  def getInputFromUser(requestMessage: String, readSuccessMessage: String): Int = {
    println(requestMessage)
    var numCards: Option[Int] = None
    while (numCards == None) {
      val userInput = readLine()
      numCards = readNumberFromConsole(userInput, readSuccessMessage)
    }
    numCards.get
  }

  def getNumberOfGameCardsFromStdin(): Int = {
    println("Enter number of cards to use: ")
    var numCards: Option[Int] = None
    while (numCards == None) {
      val userInput = readLine()
      numCards = readNumberFromConsole(userInput, SUCCESSFUL_NUM_CARDS_READ_MESSAGE)
    }
    numCards.get
  }

  def getNumberOfPlayersFromStdin(): Int = {
    println("Enter number of players: ")
    var numPlayers: Option[Int] = None
    while (numPlayers == None) {
      val input = readLine()
      numPlayers = readNumberFromConsole(input, SUCCESSFUL_NUM_PLAYERS_READ_MESSAGE)
    }
    numPlayers.get
  }

  def getCardFromStdIn(): Int = {
    var cardNumber: Option[Int] = None
    while (cardNumber == None) {
      val input = readLine()
      cardNumber = readNumberFromConsole(input, SUCCESSFUL_CARD_SELECT_MESSAGE)
    }
    cardNumber.get
  }

  def readNumberFromConsole(input: String, consoleMessage: String): Option[Int] = {
    try {
      processSuccessfulNumberRead(input, consoleMessage)
    } catch {
      case e: NumberFormatException => {  processFailedNumberRead() }
    }
  }

  def processSuccessfulNumberRead(input: String, consoleMessage: String): Option[Int] = {
    val numCards = input.toInt
    verifyNumberLargerThanZero(numCards)
    println(consoleMessage + numCards)
    Some(numCards)
  }

  protected def processFailedNumberRead() = {
    println("Value entered MUST be a number, cretin!")
    None
  }

  def verifyNumberLargerThanZero(input: Int) {
    if (input <= 0) {
      throw new IllegalArgumentException("You MUST enter a value above 0")
    }
  }
}
