/*
 * Copyright (c) 2015,2016 The Modern Way. All rights reserved.
 *
 */

package com.themodernway.api.services

import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.rest.*
import com.ait.tooling.server.sql.support.GSQLTrait

import groovy.transform.CompileStatic

@Service
@CompileStatic
@RequestMethod(HttpMethod.GET)
@RequestBinding('/demo/users/findusers')
public class FindUsersService extends RESTServiceSupport implements GSQLTrait
{
    @Override
    public JSONObject execute(final IRESTRequestContext context, final JSONObject object) throws Exception
    {
        jsql("select * from users")
    }
}
