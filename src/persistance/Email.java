package persistance;

import java.util.Properties;

import interfaces.Notificacion;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Email implements Notificacion {

	private final String username = "1f4ee2306cdd2f";
	private final String password = "e95be69fe86d28";
	private String host = "smtp.mailtrap.io";

	private String destinatario;
	private String asunto;
	private String mensaje;

	public Email(String destinatario, String asunto, String mensaje) {
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	@Override
	public boolean enviarNotificacion() {
		String to = destinatario; // Para

		String from = "jakartafrom@example.com"; // De

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(asunto); // Asunto del correo
			message.setText(mensaje); // mensaje del correo
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

}
