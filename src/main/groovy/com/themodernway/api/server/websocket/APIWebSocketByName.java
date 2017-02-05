/*
 * Copyright (c) 2015,2016 The Modern Way. All rights reserved.
 *
 */

package com.themodernway.api.server.websocket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.ait.tooling.server.core.support.spring.network.websocket.AbstractWebSocketEndPointByPathPart;

@ServerEndpoint("/sockets/endpoints/{name}")
public final class APIWebSocketByName extends AbstractWebSocketEndPointByPathPart
{
    public APIWebSocketByName()
    {
        super("name");
    }

    @OnOpen
    @Override
    public void onOpen(final Session session, final EndpointConfig config) throws IOException
    {
        super.onOpen(session, config);
    }

    @OnClose
    @Override
    public void onClose(final Session session, final CloseReason reason) throws IOException
    {
        super.onClose(session, reason);
    }

    @OnMessage
    @Override
    public void onText(final Session session, final String text, final boolean last) throws IOException
    {
        super.onText(session, text, last);
    }

    @OnError
    @Override
    public void onError(final Session session, final Throwable t)
    {
        super.onError(session, t);
    }
}
