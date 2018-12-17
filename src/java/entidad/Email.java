/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidad;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Pababarcac
 */
public class Email {
    
    //public boolean enviarCorreo(String de, String clave, String[] para, String mensaje, String asunto){
    public boolean enviarCorreo(String para, String mensaje, String asunto){
        boolean enviado = false;
            try{
            
                String host = "smtp.gmail.com";
                
                Properties prop = System.getProperties();
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user","contacto.ontour.2018@gmail.com");
                prop.put("mail.smtp.password", "avaras08");
                prop.put("mail.smtp.port",587);
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop,null);
                
                MimeMessage message = new MimeMessage(sesion);
                
                message.setFrom(new InternetAddress("contacto.ontour.2018@gmail.com"));
                
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
                
                message.setSubject(asunto);
                message.setText(mensaje);
                
                
                Transport transport = sesion.getTransport("smtp");
                
                transport.connect(host,"contacto.ontour.2018@gmail.com","avaras08");
                
                transport.sendMessage(message, message.getAllRecipients());
                
                transport.close();
                
                enviado = true;
                
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        
        return enviado;
    }
    
}
