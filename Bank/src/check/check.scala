package check
import databaseConnection.connectToSomeBank
class  checkAdmin{
  val connection=(new connectToSomeBank).connection()
  val statement=connection.createStatement()

  def isAdmin(usrName:String,psswd:String): Boolean={
    val resultSet=statement.executeQuery("SELECT * from admin")
    while(resultSet.next()){
      if(resultSet.getString("admin_id")==usrName && resultSet.getString("passwd")==psswd)
        return true
    }
    return false
  }
}