import connection.News;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maciek on 23.01.17.
 */
public class UpdatesManagerTest {



    @Test
    public void name() throws Exception {
        UpdatesManager um = new UpdatesManager();
        um.register("MPK");
        List<News> news = um.getUpdates();
        assertTrue(news.size() > 0);
    }
}