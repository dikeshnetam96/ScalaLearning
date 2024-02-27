package QuestionSolutions

object BankSystem extends App {

  case class BankAccount(accountNumber: String, balance: Double)

  case class Transaction(amount: Double, transactionType: String)

  def checkAmount(actualAmount: Double, TnxAmount: Double): Boolean = {
    actualAmount >= TnxAmount
  }

  def updateAmount(accountBalance: Double, transaction: Transaction): Double = {
    val ans: Double = transaction.transactionType match {
      case "withdrawal" => accountBalance - transaction.amount
      case "deposit" => accountBalance + transaction.amount
      case _ => 0
    }

    if (ans < 0) throw new Exception("Insufficient Balance...")
    else ans
  }

  def processTranscations(account: BankAccount, transactions: List[Transaction]): BankAccount = {
    if (transactions.isEmpty) account
    else {
      processTranscations(BankAccount(account.accountNumber, updateAmount(account.balance, transactions.head)), transactions.tail)
    }
  }

  val initialAccount = BankAccount("123456789", 1000.0)
  val transactionList = List(Transaction(500.0, "deposit"), Transaction(200.0, "withdrawal"), Transaction(300.0, "deposit"))
  /*  val initialAccount = BankAccount("123456789", 1000.0)
    val transactionList = List(Transaction(100.0, "deposit"), Transaction(2200.0, "withdrawal"), Transaction(300.0, "deposit"))*/
  val finalAccount = processTranscations(initialAccount, transactionList)
  println(s"Final account after transactions: ${finalAccount.balance}")
}
