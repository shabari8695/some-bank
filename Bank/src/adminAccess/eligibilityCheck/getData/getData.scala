package adminAccess.eligibilityCheck.getData

import java.io._
import databaseConnection.connectToSomeBank

class getData{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()
  val writer1=new PrintWriter(new File("/home/Ezio/IdeaProjects/Bank/src/adminAccess/eligibilityCheck/dataForAnalysis/accountBalance.txt"))
  val writer2=new PrintWriter(new File("/home/Ezio/IdeaProjects/Bank/src/adminAccess/eligibilityCheck/dataForAnalysis/loanAmount.txt"))
  val writer3=new PrintWriter(new File("/home/Ezio/IdeaProjects/Bank/src/adminAccess/eligibilityCheck/dataForAnalysis/loanPeriodInMonths.txt"))

  def storeALMDetails(): Unit ={
    val resultSet=statement.executeQuery("select account_balance,loan_amount,loan_period_in_months from account,loan where loan.customer_id=account.customer_id order by account_balance")
    while(resultSet.next()){
      writer1.write(resultSet.getString("account_balance")+"\n")
      writer2.write(resultSet.getString("loan_amount")+"\n")
      writer3.write(resultSet.getString("loan_period_in_months")+"\n")
    }
    writer1.close();writer2.close();writer3.close()
    connection.close()
  }

}