package org.bicell.rest.api.repository;

import org.bicell.rest.api.dbhelper.OracleHelper;
import org.bicell.rest.api.encryption.Encryption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class LoginRepository {

    Encryption encryption = new Encryption();

    public ResponseEntity loginCheck(String msisdn, String password) throws Exception {
        try {
            OracleHelper oracleDbHelper = new OracleHelper();
            Connection connection = oracleDbHelper.getConnection();

            String encryptedPassword = encryption.encryptPassword(password);

            CallableStatement callableStatement = connection.prepareCall("{ ? = call package_subscriber.login(?,?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, msisdn);
            callableStatement.setString(3, password);
            callableStatement.execute();

            int checkUser = callableStatement.getInt(1);
            if (checkUser == 1) {
                return new ResponseEntity<>("Login successful", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Login unsuccessful", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Login unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }
}
