package QuestionSolutions

object HandlingFailure extends App {

  import scala.util.{Try, Success, Failure}

  // Simulating an external API call that might fail
  def fetchDataFromAPI(): Try[String] = {
    // Simulating a successful call
    // Uncomment the line below to simulate a failure
    // Failure(new RuntimeException("API call failed"))
    Success("Data from API")
  }

  // Your code here

  // Expected result: Either an error message or the processed data


}
