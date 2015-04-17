package demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggerShould {

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Test
    public void Test(){

        int version = 1;
        MDC.put("version", Integer.toString(version));
        LOG.trace("Hello World! Version: " + Integer.toString(version));
        LOG.debug("How are you today? Version: " + Integer.toString(version));
        LOG.info("I am fine. Version: " + Integer.toString(version));
        LOG.warn("I love programming. Version: " + Integer.toString(version));
        LOG.error("I am programming. Version: " + Integer.toString(version));

        MDC.put("version", Integer.toString(++version));
        LOG.trace("Hello World! Version: " + Integer.toString(version));
        LOG.debug("How are you today? Version: " + Integer.toString(version));
        LOG.info("I am fine. Version: " + Integer.toString(version));
        LOG.warn("I love programming. Version: " + Integer.toString(version));
        LOG.error("I am programming. Version: " + Integer.toString(version));
    }
}



