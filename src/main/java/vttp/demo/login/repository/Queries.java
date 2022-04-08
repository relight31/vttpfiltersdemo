package vttp.demo.login.repository;

public interface Queries {
    public static final String SQL_AUTHENTICATE_USER = "select count(*) as auth from user where username = ? and password = sha(?)";
}
