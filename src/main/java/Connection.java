import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by geoff on 27/03/2016.
 */

public class Connection extends Thread {

    private String channel;

    public Connection (String channel) {
        this.channel = channel;
    }

    public void run() {
        try {

            MessageHandler msgHandler = new MessageHandler();
            URI url = new URI("ws://rockets.cc:3210");

            //Open websocket to Rockets
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(url);

            //Add message Handler to print received stream
            clientEndPoint.addMessageHandler(msgHandler);

            //Send message to websocket to subscribe to specified channel parameter
            clientEndPoint.sendMessage("{\"channel\": \"" + channel + "\"}");


        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }
}
