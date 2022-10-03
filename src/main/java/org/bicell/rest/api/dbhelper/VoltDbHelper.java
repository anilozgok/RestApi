package org.bicell.rest.api.dbhelper;

import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;

import java.io.IOException;

public class VoltDbHelper {

    private final String db_url="";

    private final int port=0;

    public Client client() throws IOException{
        Client client;
        ClientConfig clientConfig;
        clientConfig=new ClientConfig("advent", "xYZZy");
        client = ClientFactory.createClient(clientConfig);
        client.createConnection(db_url, port);
        return client;
    }


}
