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

package com.themodernway.api.server.rest

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.core.support.CoreGroovyTrait
import com.ait.tooling.server.mongodb.support.MongoDBTrait

import groovy.transform.CompileStatic

@Controller
@CompileStatic
class RESTController implements CoreGroovyTrait, MongoDBTrait
{
    @GetMapping('/user')
    @ResponseBody
    def user()
    {
        json(collection('users').findOne(QUERY(name: 'dean')))
    }
}
