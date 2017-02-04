package connection;

/**
 * Created by maciek on 23.01.17.
 */
public class ConnectorFactory {

    public Connector createConnector(String name) {
        if(name.equalsIgnoreCase("MPK")) {
            return new MpkConnector(new MpkDataGetter());
        }
        else {
            throw new IllegalArgumentException("No connector found for" + name);
        }
    }
}
