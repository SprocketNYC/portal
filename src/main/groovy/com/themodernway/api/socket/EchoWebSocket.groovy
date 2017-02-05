/*
 * Copyright (c) 2015,2016 The Modern Way. All rights reserved.
 *
 */

package com.themodernway.api.socket

import org.springframework.stereotype.Service

import com.ait.tooling.server.core.support.spring.network.websocket.*

import groovy.transform.CompileStatic

@CompileStatic
@Service("echo.socket")
public class EchoWebSocket extends WebSocketServiceSupport
{
    @Override
    public void onMessage(IWebSocketServiceContext context, String text, boolean last) throws Exception
    {
        context.reply(text, last)
    }
}
