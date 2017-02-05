/*
 * Copyright (c) 2015,2016 The Modern Way. All rights reserved.
 *
 */

package com.themodernway.api.socket

import org.springframework.stereotype.Service

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.core.support.spring.network.websocket.*

import groovy.transform.CompileStatic

@CompileStatic
@Service("list.socket")
public class ListWebSocket extends JSONWebSocketServiceSupport
{
    @Override
    public void onMessage(final IWebSocketServiceContext context, final JSONObject json) throws Exception
    {
        int cntr = 0

        def many = json.getAsInteger('many')

        if (many)
        {
            cntr = many
        }
        def list = jarr()

        for (int i = 0; i < cntr; i++)
        {
            list << json
        }
        context.reply(list)
    }
}
