
package com.themodernway.api.services

import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.core.security.Authorized
import com.ait.tooling.server.rest.*

import groovy.transform.CompileStatic

@Service
@CompileStatic
@RequestMethod(HttpMethod.GET)
@RequestBinding('/demo/admin_only')
@Authorized("ADMIN")
class AdminOnly extends RESTServiceSupport
{
    @Override
    public JSONObject execute(final IRESTRequestContext context, final JSONObject object) throws Exception
    {        
        json(status: 'ok')
    }
}

