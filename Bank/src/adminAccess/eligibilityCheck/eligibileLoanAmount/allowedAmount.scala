package adminAccess.eligibilityCheck.eligibileLoanAmount

import databaseConnection.connectToSomeBank

class allowedAmount{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()
  def getAllowdAmount(accountBal:Int): Int ={
    val upperLimit=accountBal+2000
    val lowerLimit=accountBal-2000
    val query="select loan_amount from account,loan where loan.customer_id=account.customer_id and account_balance between "+lowerLimit+" and "+upperLimit+";"
    val resultSet=statement.executeQuery(query)
    var totalLoanAmount=0
    var totalNumberOfLoans=0
    while(resultSet.next()){
      totalLoanAmount+=resultSet.getString("loan_amount").toInt
      totalNumberOfLoans+=1
    }
    val averageLoan=totalLoanAmount/totalNumberOfLoans
    averageLoan
  }
}