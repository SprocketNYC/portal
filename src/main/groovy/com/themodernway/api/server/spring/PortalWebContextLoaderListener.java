/*
 * Copyright (c) 2015,2016 The Modern Way. All rights reserved.
 *
 */

package com.themodernway.api.server.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.log4j.Logger;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ait.tooling.server.core.support.spring.CoreWebContextLoaderListener;

public class PortalWebContextLoaderListener extends CoreWebContextLoaderListener
{
    private static final Logger logger = Logger.getLogger(PortalWebContextLoaderListener.class);

    @Override
    protected void customizeContext(final ServletContext sc, final ConfigurableWebApplicationContext context)
    {
        logger.info("PortalWebContextLoaderListener.customizeContext() STARTING");

        super.customizeContext(sc, context);

        final Dynamic dispatcher = sc.addServlet("DispatcherServlet", new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        
        dispatcher.addMapping("/rest/*");
        
        logger.info("PortalWebContextLoaderListener.customizeContext() COMPLETE");
    }
}
