import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by geoff on 27/03/2016.
 * When message is received, the string is parsed as a json object
 * and some of the elements are printed to the console
 */

public class MessageHandler implements javax.websocket.MessageHandler{

    private String message;
    private String content = null;
    private String subreddit = null;
    private String author = null;

    public void handleMessage(String message) {
        JSONObject obj = null;
        try {
            this.message = message;
            obj = new JSONObject(this.message);

            if (obj.getString("kind").equals("t1")) {
                author = obj.getJSONObject("data").getString("author");
                content = obj.getJSONObject("data").getString("body");
                subreddit = obj.getJSONObject("data").getString("subreddit");
                System.out.println("User \"" + author + "\" commented \"" + content + "\" in subreddit " + subreddit);
            }

            if (obj.getString("kind").equals("t3")) {
                author = obj.getJSONObject("data").getString("author");
                content = obj.getJSONObject("data").getString("title");
                subreddit = obj.getJSONObject("data").getString("subreddit");
                System.out.println("User \"" + author + "\" just posted \"" + content + "\" in subreddit " + subreddit);
            }
        }catch (JSONException e){
            System.out.println(e);

        }
    }
}
