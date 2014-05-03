package com.duffmanstudios.memory.terminal.io

import com.duffmanstudios.memory.ProjectTest

/**
 * Contains unit tests for the utility methods in UserInputReader that receive and evaluate console inputs
 * for the game
 *
 * @author Iain Duff
 */
class UserInputReaderTest extends ProjectTest {

  "readNumberFromConsole" should "return None if the character entered is not numerical" in {
    val invalidInputs = Array("a", "1a", "1#", "#", " ", "")

    for (input <- invalidInputs) {
      UserInputReader.readNumberFromConsole(input, "<message_to_print_to_console>") should equal (None)
    }
  }

  "readNumberFromConsole" should "return the user input as an option[Int] if the value is numerical" in {
    val validInput = "12"

    UserInputReader.readNumberFromConsole(validInput, "<message_to_print_to_console>") should equal (Some(12))
  }

  "readNumberFromConsole" should "throw an IllegalArgumentException if the number is zero or below" in {
    val invalidInputs = Array("0", "-1", "-10")
    for (input <- invalidInputs) {
      intercept[IllegalArgumentException] {
        UserInputReader.readNumberFromConsole(input, "<message_to_print_to_console>")
      }
    }
  }

  "readNumberFromConsole" should "NOT throw an IllegalArgumentException if the number is above zero" in {
    val validInputs = Array("1", "2", "20")
    for (input <- validInputs) {
      UserInputReader.readNumberFromConsole(input, "<message_to_print_to_console>")
    }
  }
}
