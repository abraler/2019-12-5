package java_JDBC;/*
1：加载驱动
2：获取连接  Connection
3：使用连接执行SQl Curd
执行 sql statement
获取查询返回值  ResultSet
4:关闭资源
Connection
Statement
ResultSet

将数据库的配置文件信息存放到配置文件（*.properties）
将信息从配置文件读到程序中


Junit单元测试：白盒测试

 */



import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SMS");
        Statement statement=connection.createStatement();
        ResultSet resultSet =statement.executeQuery("desc classes");
        while(resultSet.next()){
            String table=resultSet.getNString(1);
            System.out.println(String.format(table));
        }
        resultSet.close();
    }
}
