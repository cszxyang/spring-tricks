package com.github.cszxyang.handler;

import com.github.cszxyang.annotation.ProcessOrder;
import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;

@ProcessOrder(4)
public class GeneralHandler extends BaseHandler {
    @Override
    ProcessResult process(ServiceReq serviceReq) {
        if (isQualified(serviceReq.getOrder())) {
            System.out.println("GeneralHandler handling...");
            return new ProcessResult(true);
        }
        return new ProcessResult();
    }
}
