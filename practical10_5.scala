import scala.io.StdIn.readLine

object LetterCounter {

  // Function to count letter occurrences
  def countLetterOccurrences(words: List[String]): Int = {
    words.map(_.length).reduce(_ + _)
  }

  // Main function to get user inputs and display the result
  def main(args: Array[String]): Unit = {
    // Get the number of words the user wants to enter
    println("How many words do you want to add?")
    val numOfWords = readLine().toInt

    // Get each word from the user and collect them in a list
    var words: List[String] = List()
    for (i <- 1 to numOfWords) {
      println(s"Enter word $i:")
      val word = readLine()
      words = words :+ word  // Append each word to the list
    }

    // Call the function to count letter occurrences
    val totalCount = countLetterOccurrences(words)

    // Display the result
    println(s"Total count of letter occurrences: $totalCount")
  }
}
