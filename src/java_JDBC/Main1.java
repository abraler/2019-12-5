package java_JDBC;

import com.util.CommUtils;

import java.sql.*;
import java.util.Properties;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        //通过配置文件
        Properties properties=CommUtils.loadProperties("db.properties");
        String url=properties.getProperty("url");
        String usename=properties.getProperty("usename");
        String password=properties.getProperty("password");
        //第一种
//        String url="jdbc:mysql://localhost:3306/SMS";
//        String usename="root";
//        String password="wx123456";
        Connection connection=DriverManager.getConnection(url,usename,password);

        Statement statement=connection.createStatement();
        String sqlstr="select *from classes";
        ResultSet rs=statement.executeQuery(sqlstr);

        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            System.out.println(id+name);
        }
        connection.close();
        statement.close();
        rs.close();
    }
}
