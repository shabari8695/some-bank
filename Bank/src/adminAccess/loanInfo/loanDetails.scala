package adminAccess.loanInfo

import databaseConnection.connectToSomeBank

class basicLoanDetails{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()

  def printDetails(): Unit ={
    val resultSet=statement.executeQuery("SELECT * from loan")
    while(resultSet.next()){
      val customerId=resultSet.getString("customer_id")
      val loanID=resultSet.getString("loan_id")
      val loanAmount=resultSet.getString("loan_amount")
      val loanDate=resultSet.getString("loan_date")
      val loanDueDate=resultSet.getString("loan_period_in_months")
      val displaySpace=" "*5
      println(loanID+displaySpace+customerId+displaySpace+loanAmount+displaySpace+loanDate+displaySpace+loanDueDate)
    }
    connection.close()
  }

  def printDetails(colNames:Array[String]): Unit ={
    val coloumnNames=colNames.mkString(",")
    val query="select "+coloumnNames+" from loan"
    val resultSet=statement.executeQuery(query)
    while(resultSet.next()){
      val displaySpace=" "*5
      for(colName<-colNames){
        print(resultSet.getString(colName)+displaySpace)
      }
      println("")
    }
    connection.close()
  }

  def printDetails(colNames:Array[String],condition:String): Unit ={
    val coloumnNames=colNames.mkString(",")
    val query="select "+coloumnNames+" from loan where "+condition
    val resultSet=statement.executeQuery(query)
    while(resultSet.next()){
      val displaySpace=" "*5
      for(colName<-colNames){
        print(resultSet.getString(colName)+displaySpace)
      }
      println("")
    }
    connection.close()
  }

}