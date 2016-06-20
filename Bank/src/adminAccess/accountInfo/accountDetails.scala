package adminAccess.accountInfo
import databaseConnection.connectToSomeBank

class basicAccountDetails{

  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()

  def printDetails(): Unit ={
    val resultSet=statement.executeQuery("SELECT * from account")
    while(resultSet.next()){
      val customerId=resultSet.getString("customer_id")
      val accountId=resultSet.getString("account_id")
      val accountBalance=resultSet.getString("account_balance")
      val displaySpace=" "*5
      println(accountId+displaySpace+customerId+displaySpace+accountBalance+displaySpace)
    }
    connection.close()
  }

  def printDetails(colNames:Array[String]): Unit ={
    val coloumnNames=colNames.mkString(",")
    val query="select "+coloumnNames+" from account"
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
    val query="select "+coloumnNames+" from account where "+condition
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