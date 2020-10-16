package sample;

import Connect.ConnectionClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static List<Word> findAll() throws SQLException {
        List<Word> wordlist = new ArrayList<>();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql ="select * from word";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(sql);
        while(resultSet.next()){
            Word std = new Word(resultSet.getString("target"),resultSet.getString("explains"));
            wordlist.add(std);
        }
    return wordlist;
    }
    public static void insert(Word a) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql ="insert into word(target,explains) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareCall(sql);
        preparedStatement.setString(1,a.getWord_target());
        preparedStatement.setString(2,a.getWord_explain());
        preparedStatement.execute();
    }



    public static void delete(Word a) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql ="delete from word where target = ?";
        PreparedStatement preparedStatement = connection.prepareCall(sql);
        preparedStatement.setString(1,a.getWord_target());
        preparedStatement.execute();
    }

    public static void update(Word a) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sql ="update word set explains=? where target=?";
        PreparedStatement preparedStatement = connection.prepareCall(sql);
        preparedStatement.setString(1,a.getWord_explain());
        preparedStatement.setString(2,a.getWord_target());
        preparedStatement.execute();
    }

}
