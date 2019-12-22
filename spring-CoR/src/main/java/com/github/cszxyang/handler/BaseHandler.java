package com.github.cszxyang.handler;

import com.github.cszxyang.request.ServiceReq;

public abstract class BaseHandler {
    abstract void process(ServiceReq serviceReq);
}
