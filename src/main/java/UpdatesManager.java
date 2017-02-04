import connection.Connector;
import connection.ConnectorFactory;
import connection.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciek on 23.01.17.
 */
public class UpdatesManager {
    List<Connector> connectorList;
    ConnectorFactory factory;

    public UpdatesManager() {
        this.connectorList = new ArrayList<>();
        factory = new ConnectorFactory();
    }

    public void register(String connectorName) {
        connectorList.add(factory.createConnector(connectorName));
    }

    public List<News> getUpdates() {
        List<News> result = new ArrayList<>();
        for(Connector connector : connectorList) {
            result.addAll(connector.connect());
        }
        return  result;
    }
}
