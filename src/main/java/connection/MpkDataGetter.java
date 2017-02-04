package connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by maciek on 23.01.17.
 */
public class MpkDataGetter {
    String getResponse(String stopId) {
        URL url = null;
        try {
            url = new URL("http://tram.wroclaw.pl/ws/board/show/" + stopId);

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();
        return str;
        } catch (MalformedURLException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }
}
