/**
 * Created by geoff on 30/03/2016.
 */
public class App {
    public static void main(String[] args) {

        //Creates a new thread connection to the Rockets websocket server
        //Passes channel subscription, options are "comments" or "posts"
        Connection con = new Connection("comments");
//        Connection con2 = new Connection("posts");

        con.start();
//        con2.start();

        //Runs for 20 seconds before closing connection and terminating
        try {
            con.sleep(20000);
//            con2.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
