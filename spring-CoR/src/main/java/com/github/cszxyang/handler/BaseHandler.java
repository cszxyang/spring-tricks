package com.github.cszxyang.handler;

import com.github.cszxyang.request.ServiceReq;

/**
 * 通用处理器
 *
 * @author cszxyang
 * @since 2019/12/22
 */
public abstract class BaseHandler {
    abstract void process(ServiceReq serviceReq);
}
