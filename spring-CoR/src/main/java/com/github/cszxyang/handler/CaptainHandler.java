package com.github.cszxyang.handler;

import com.github.cszxyang.annotation.ProcessOrder;
import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;
/**
 * Captain 上尉
 */
@ProcessOrder(3)
public class CaptainHandler extends BaseHandler{

    public CaptainHandler() {
        this.order = 3;
    }

    @Override
    ProcessResult process(ServiceReq serviceReq) {
        if (isQualified(serviceReq.getOrder())) {
            System.out.println("CaptainHandler handling...");
            return new ProcessResult(true);
        }
        return new ProcessResult();
    }
}
