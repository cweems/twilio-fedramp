package twilio;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import io.github.cdimascio.dotenv.Dotenv;
import twilio.ProxiedTwilioClientCreator;

public class Client {
    public static void main(String[] args) {
        final Dotenv dotenv = Dotenv.load();

        final String ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
        final String AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
        String PROXY_HOST = dotenv.get("PROXY_HOST");
        int PROXY_PORT = Integer.parseInt(dotenv.get("PROXY_PORT"));

        ProxiedTwilioClientCreator clientCreator = new ProxiedTwilioClientCreator(
                    ACCOUNT_SID, AUTH_TOKEN, PROXY_HOST, PROXY_PORT);
        
        TwilioRestClient twilioRestClient = clientCreator.getClient();
        Twilio.setRestClient(twilioRestClient);

        Message message = Message.creator(new PhoneNumber("+14136587734"),
                    new PhoneNumber("+14155706226"), "Hey there! First SMS from Twilio").create();
        
        System.out.println(message);
    }
}