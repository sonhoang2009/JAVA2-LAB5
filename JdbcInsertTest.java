package mySQL.lab4;

import java.sql.*;

public class JdbcInsertTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            String sqlDelete = "delete from books where id >=8000";
            System.out.println("The SQL statement is " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + "record Deleted.\n");

            String sqlInsert = "insert into books values ( 3001,'Gone Fishing','Kumar',11.11,11)";
            System.out.println("The SQL statement is: "+sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records inserted . \n");

            sqlInsert = "insert into books values "+
                    "(3002,'Gone Fishing 2','Kumar',22.22,22),"
                    +"(3003,'Gone Fishong 3','Kumar',33.33,33)";
            System.out.println("The SQL statement is "+ sqlInsert+ "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +"record insert .\n ");

            sqlInsert = "insert into books (id, title , author) values (3004,'Fishing 101','Kumar')";
            System.out.println("The SQL statement is :"+sqlInsert +"\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +"record insert .\n ");

            sqlInsert = "insert into books (id, title , author) values (2001,'JavaJDBC MySQL','ThiDK')";
            System.out.println("The SQL statement is :"+sqlInsert +"\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +"record insert .\n ");

            sqlInsert = "insert into books values "+
                    "(8001,'Java Core','Dang Kim Thi',15.55,55),"
                    +"(8002,'Java Anvnadec','James Goshing',25.55,55)";
            System.out.println("The SQL statement is "+ sqlInsert+ "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +"record insert .\n ");

            String sqlDelete = "delete from books where id =2001";
            System.out.println("The SQL statement is " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + "record Deleted.\n");




            String strSelect = "select * from books";
            System.out.println("The SQL statement is " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(rset.getInt("id") + " ,"
                        + rset.getString("author") + " ,"
                        + rset.getString("title") + " ,"
                        + rset.getDouble("price") + " ,"
                        + rset.getInt("qty"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
