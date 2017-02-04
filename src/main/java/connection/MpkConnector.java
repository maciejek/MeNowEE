package connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MpkConnector implements Connector {

    private final MpkDataGetter mpkDataGetter;

    public MpkConnector(MpkDataGetter mpkDataGetter) {
        this.mpkDataGetter = mpkDataGetter;
    }

    public Collection<News> connect() {

        String str = mpkDataGetter.getResponse("23710");
        JSONObject obj = new JSONObject(str);
        JSONObject stop = obj.getJSONObject("23710");
        JSONArray res = stop.getJSONArray("board");
        List<News> result = new ArrayList<>();
        for(int i = 0; i<res.length(); i++) {
            result.add(new News(
                    String.valueOf(res.getJSONObject(i).getInt("minuteCount")).concat(" min "),
                    res.getJSONObject(i).getString("line"),
                    res.getJSONObject(i).getString("direction")));
        }
        return result;
    }

}
