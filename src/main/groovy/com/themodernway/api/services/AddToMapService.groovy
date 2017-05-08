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

package com.themodernway.api.services

import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

import com.hazelcast.core.IMap
import com.themodernway.server.core.json.JSONObject
import com.themodernway.server.hazelcast.support.HazelcastTrait
import com.themodernway.server.rest.IRESTRequestContext
import com.themodernway.server.rest.RESTServiceSupport
import com.themodernway.server.rest.RequestBinding
import com.themodernway.server.rest.RequestMethod

import groovy.transform.CompileStatic

@Service
@CompileStatic
@RequestMethod(HttpMethod.GET)
@RequestBinding('/demo/cache/add')
class AddToMapService extends RESTServiceSupport implements HazelcastTrait
{
    @Override
    def call(IRESTRequestContext context, JSONObject object) throws Exception
    {
        def pmap = getIMap('map')

        if (pmap)
        {
            pmap.put(uuid(), (new Date()).toString())
        }
        else
        {
            pmap = getBean('map', IMap)

            if (pmap)
            {
                pmap.put(uuid(), (new Date()).toString())
            }
            else
            {
                pmap = [dean:1]
            }
        }
        Optional.ofNullable(pmap)
    }
}

