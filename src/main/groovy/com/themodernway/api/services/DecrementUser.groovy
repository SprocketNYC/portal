
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
@RequestBinding('/demo/users/decrement')
class DecrementUser extends RESTServiceSupport implements MongoDBTrait
{
    @Override
    public JSONObject execute(final IRESTRequestContext context, final JSONObject object) throws Exception
    {
        collection('users').upsert(QUERY(name: 'dean'), INC(count: -1L))
        
        json(collection('users').findOne(QUERY(name: 'dean')))
    }
}

