package com.matthewcasperson.swarmdemo;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.topology.TopologyArchive;
import org.wildfly.swarm.undertow.WARArchive;

import java.io.File;

/**
 * Swarm entry point
 */
public class MyMain {

    private static final String WEBAPP_SRC = "src/main/webapp";


    public static void main(final String... args) throws Exception {

        // Instantiate the container
        final Container container = new Container();

        final WARArchive deployment = ShrinkWrap.create(WARArchive.class);
        deployment.setWebXML(new File(WEBAPP_SRC, "WEB-INF/web.xml"));
        deployment.addAsWebResource(new File(WEBAPP_SRC, "demo.js"));
        deployment.addAsWebResource(new File(WEBAPP_SRC, "index.xhtml"));

        // advertise this deployment as `sampleapp`
        deployment.as(TopologyArchive.class).advertise("sampleapp");

        container.start();
        container.deploy(deployment);
    }
}