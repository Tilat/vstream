package io.vstream.apiserver.conf;

import io.vstream.apiserver.rest.TestEndpoint;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(TestEndpoint.class);
    }
}
