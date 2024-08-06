import java.sql.*;
class Main{
    private static String url="jdbc:mysql://localhost:3306/practice";
    private static String username="root";
    private static String password="Harshal@25";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }


        try{
            Connection conn=DriverManager.getConnection(url,username,password);

            createTable(conn);
            insertData(conn,1,85.20f,"A");
            updateDataGrade(conn,1,"B");
            deleteData(conn,1);
            retriveData(conn);





        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }



    }
    public static void createTable(Connection conn) {
        String query = "CREATE TABLE IF NOT EXISTS StudentsData1 (" +
                "id INT PRIMARY KEY, " +
                "percentage FLOAT, " +
                "grade VARCHAR(20))";

        try (Statement statement = conn.createStatement()) {
            statement.execute(query);
            System.out.println("Table created successfully or already exists.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }

    public static void insertData(Connection conn,int id,float percentage,String grade){
        try{
            Statement insertstatement=conn.createStatement();
            String query = String.format("INSERT INTO StudentsData1 (id, percentage, grade) VALUES (%d, %f, '%s')", id, percentage, grade);

            int result=insertstatement.executeUpdate(query);

            if(result>0){
                System.out.println("Data inserted Successfully");
            }
            else{
                System.out.println("Not able to add data");

            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void updateDataGrade(Connection conn,int  id,String grade){
      try{
          Statement newStatement=conn.createStatement();
          String query=String.format("update StudentsData1 set grade='%s' where id=%d ",grade,id);
          int result=newStatement.executeUpdate(query);

          if(result>0){
              System.out.println("Row is Updated");
          }
          else{
              System.out.println("Not able to Update");
          }

      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }


    }

    public static void retriveData(Connection conn){
        try{
            String query="select * from StudentsData1";
            Statement newStatement=conn.createStatement();
            ResultSet result=newStatement.executeQuery(query);
            System.out.println("id   percentage   grade");
            while(result.next()){
                int id=result.getInt(1);
                float percentage=result.getFloat(2);
                String grade=result.getString(3);

                System.out.println(id+"       "+percentage+"        "+grade);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteData(Connection conn,int id){
        try{
            Statement newStatement=conn.createStatement();
            String query = String.format("DELETE FROM StudentsData1 WHERE id = %d", id);

            int result=newStatement.executeUpdate(query);
            if(result>0){
                System.out.println("Data Deleted Successfully");
            }
            else{
                System.out.println("Not able delete data");
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}