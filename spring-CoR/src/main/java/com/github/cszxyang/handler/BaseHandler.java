package com.github.cszxyang.handler;

import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;
import lombok.Data;

/**
 * 通用处理器
 *
 * @author cszxyang
 * @since 2019/12/22
 */
@Data
public abstract class BaseHandler {

    protected int order;

    abstract ProcessResult process(ServiceReq serviceReq);

    boolean isQualified(int order) {
        return this.order >= order;
    }
}
