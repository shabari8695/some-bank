package adminPage.clientInfo
import databaseConnection.connectToSomeBank

class basicClientDetails{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()

  def printDetails(): Unit ={
    val resultSet=statement.executeQuery("SELECT * from customer")
    while(resultSet.next()){
      val customerId=resultSet.getString("customer_id")
      val customerName=resultSet.getString("customer_name")
      val customerAddress=resultSet.getString("customer_address")
      val displaySpace=" "*5
      println(customerId+displaySpace+customerName+displaySpace+customerAddress)
    }
    connection.close()
  }

  def printDetails(colNames:Array[String]): Unit ={
    val coloumnNames=colNames.mkString(",")
    val query="select "+coloumnNames+" from customer"
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
    val query="select "+coloumnNames+" from customer where "+condition
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