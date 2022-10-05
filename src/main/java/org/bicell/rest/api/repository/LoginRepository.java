package org.bicell.rest.api.repository;

import net.bytebuddy.jar.asm.Type;
import org.bicell.rest.api.dbhelper.OracleHelper;
import org.bicell.rest.api.email.EmailSenderService;
import org.bicell.rest.api.encryption.Encryption;
import org.bicell.rest.api.entity.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

@Repository
public class LoginRepository {
    @Autowired
    private EmailSenderService emailSenderService;

/*    @EventListener(ApplicationReadyEvent.class)
    private void sendEmail(String toEmail, String subject, string, ){
        emailSenderService.sendEmail("ozgok2001@gmail.com", "deneme subject", "deneme body");
    }*/

    public ResponseEntity loginCheck(String msisdn, String password) throws Exception {
        try {
            OracleHelper oracleDbHelper = new OracleHelper();
            Connection connection = oracleDbHelper.getConnection();

            /*
            boolean created=connection.createStatement().execute("INSERT INTO SUBSCRIBER (msisdn,name,surname,email,password,sdate,status) values('23423423411', 'anıl', 'can', 'ozgok2001@gmail.com', '123345A', '29.09.2022', 'A')");

            System.out.println(created);

            ResultSet result=connection.createStatement().executeQuery("SELECT COUNT(*) FROM SUBSCRIBER");

            while(result.next()){
                System.out.println(result.getInt(1));
            }*/

            CallableStatement callableStatement = connection.prepareCall("{ ? = call package_subscriber.login(?,?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, msisdn);
            callableStatement.setString(3, password);
            callableStatement.execute();

            int checkUser = callableStatement.getInt(1);
            if (checkUser==1) {
                return new ResponseEntity<>("Login successful", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Login unsuccessful", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Login unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity forgotPassword(Subscriber subscriber) throws Exception {

        OracleHelper oracleDbHelper = new OracleHelper();
        Connection connection = oracleDbHelper.getConnection();
        String sql = "{? = call package_subscriber.forget_password(?,?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.registerOutParameter(1, Types.VARCHAR);

        callableStatement.setString(2, subscriber.getEmail());
        callableStatement.execute();

        String password = callableStatement.getString(1);

        if (password != null) {

            String toEmail = subscriber.getEmail();
            String subject = "BiCell Password";
            String body = "Your password is " + password;

            emailSenderService.sendEmail(toEmail, subject, body);

            return new ResponseEntity<>("E-mail is sent", HttpStatus.OK);

        } else
            return new ResponseEntity<>("User not Found", HttpStatus.BAD_REQUEST);
    }
}
