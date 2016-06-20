package adminAccess.generalQuery

import databaseConnection.connectToSomeBank

class basicGeneralQuery{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()

  def printQueryResult(query:String): Unit = {
    val resultSet = statement.executeQuery(query)
    val array=query.split(" ")
    val displaySpace=" "*5
    while (resultSet.next()){
      var i=1
      while(array(i)!="from") {
        if(array(i)!=",")
          print(resultSet.getString(array(i))+displaySpace)
        i+=1
      }
      println("")
    }
    connection.close()
  }
}