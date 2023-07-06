package Stepdefinitions.database_stepdefs;

import io.cucumber.java.en.*;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class US01_DBStepDefs {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile guest useri cagir")
    public void ile_guest_useri_cagir(String username) throws SQLException {

        //Connection ve Statement oluştur
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();

        //Query'yi çalıştır
        String query = "SELECT * FROM guest_user WHERE username = 'john129'";
        resultSet = statement.executeQuery(query);

    }

    @Then("body sunlari icermeli: {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string}")
    public void body_sunlari_icermeli(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth, String ssn , String username, String password) throws SQLException {

        resultSet.next();//Pointer varsayılan olarak sütun isimlerini gösterir. Next methodu ile table üzerine alınarak data okunabilir.
        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhone = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");
        String actDateOfBirth = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");

        assertEquals(username,actUsername);
        assertEquals(name,actName);



    }

}