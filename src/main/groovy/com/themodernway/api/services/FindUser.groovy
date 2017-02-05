
package com.themodernway.api.services

import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.mongodb.support.MongoDBTrait
import com.ait.tooling.server.rest.*

import groovy.transform.CompileStatic

@Service
@CompileStatic
@RequestMethod(HttpMethod.GET)
@RequestBinding('/demo/users/finduser')
class FindUser extends RESTServiceSupport implements MongoDBTrait
{
    @Override
    public JSONObject execute(final IRESTRequestContext context, final JSONObject object) throws Exception
    {
        json(collection('users').findOne(QUERY(name: 'dean')))
    }
}

