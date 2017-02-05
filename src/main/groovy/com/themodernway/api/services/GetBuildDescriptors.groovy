
package com.themodernway.api.services

import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

import com.ait.tooling.server.core.json.JSONObject
import com.ait.tooling.server.core.support.spring.IBuildDescriptor
import com.ait.tooling.server.rest.*

import groovy.transform.CompileStatic
import groovy.transform.Memoized

@Service
@CompileStatic
@RequestMethod(HttpMethod.GET)
@RequestBinding('/demo/build/descriptors')
class GetBuildDescriptors extends RESTServiceSupport
{
    @Override
    public JSONObject execute(final IRESTRequestContext context, final JSONObject object) throws Exception
    {
        getBuildDescriptors()
    }
    
    @Memoized
    public JSONObject getBuildDescriptors()
    {
        def list = []
        
        getBuildDescriptorProvider().getBuildDescriptors().each { IBuildDescriptor desc ->
            
            list << desc.toJSONObject()
        }
        json(descriptors: list)
    }
}

