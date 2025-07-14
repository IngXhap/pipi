package vg.roberto.espinoza.hackathon.config;

import jakarta.annotation.PostConstruct;

public class JasperXmlFixConfig {
    @PostConstruct
    public void fixXmlParser() {
        System.setProperty(
            "javax.xml.parsers.DocumentBuilderFactory",
            "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl"
        );
    }

}
