/*
 * Copyright (c) 2017, The Modern Way. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

import com.themodernway.server.core.support.spring.network.websocket.AbstractWebSocketEndPointByPathPart;

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
