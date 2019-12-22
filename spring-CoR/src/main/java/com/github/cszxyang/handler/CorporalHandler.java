package com.github.cszxyang.handler;

import com.github.cszxyang.annotation.ProcessOrder;
import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;

/**
 * 下士
 */
@ProcessOrder(1)
public class CorporalHandler extends BaseHandler {

    public CorporalHandler() {
        this.order = 1;
    }

    @Override
    ProcessResult process(ServiceReq serviceReq) {
        if (isQualified(serviceReq.getOrder())) {
            System.out.println("CorporalHandler handling...");
            return new ProcessResult(true);
        }
        return new ProcessResult();
    }
}
