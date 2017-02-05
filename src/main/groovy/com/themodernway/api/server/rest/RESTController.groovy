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
    @GetMapping("/user")
    @ResponseBody
    def user()
    {
        json(collection('users').findOne(QUERY(name: 'dean')))
    }
}
