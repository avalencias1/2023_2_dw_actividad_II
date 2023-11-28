package co.edu.udec.devweb.activdad2.alberto_valencia_solis.modelo;
import java.sql.*;
/**
 *
 * @author invic
 */
public class ConexionDb {
    protected String strDriver ="com.mysql.cj.jdbc.Driver";
    protected String strServer ="127.0.0.1"; //O localhost
    protected String strUrl ="jdbc:mysql"; 
    protected int intPort=3306;
    protected String strUserDB="root";
    protected String strPass="";  
    protected String strDbName="gastos_db"; 
    
    protected String strCadConn=strUrl + "://" + strServer + ":" + String.valueOf(intPort) +"/" + strDbName ;  

    Connection con;
    protected PreparedStatement pstSQL; 
    protected  ResultSet rstRecords;
    
    //Constructores
    
    public ConexionDb() throws Exception{
        //Atributos
        try {
            Class.forName(strDriver);
        } catch (ClassNotFoundException ex) {
            throw new Exception("No se ha encontado el Driver " + strDriver );
        }        
        try {
            con=DriverManager.getConnection(strCadConn,strUserDB,strPass);            
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gastos_db","root","");            
        } catch (SQLException e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    
    public void DbClose(){
        try {
            con.close();
        } catch (SQLException e) {
            con=null;
        }   
        
    }

    public PreparedStatement prepareStatement(String query, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
