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

package com.themodernway.api.socket

import org.springframework.stereotype.Service

import com.themodernway.server.core.json.JSONObject
import com.themodernway.server.core.support.spring.network.websocket.IWebSocketServiceContext
import com.themodernway.server.core.support.spring.network.websocket.JSONWebSocketServiceSupport

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
