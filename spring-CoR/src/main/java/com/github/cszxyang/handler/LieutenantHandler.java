package com.github.cszxyang.handler;

import com.github.cszxyang.annotation.ProcessOrder;
import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;


/**
 * Lieutenant 中尉
 */
@ProcessOrder(2)
public class LieutenantHandler extends BaseHandler {
    @Override
    ProcessResult process(ServiceReq serviceReq) {
        if (isQualified(serviceReq.getOrder())) {
            System.out.println("LieutenantHandler handling...");
            return new ProcessResult(true);
        }
        return new ProcessResult();
    }
}
