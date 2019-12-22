package com.github.cszxyang.handler;

import com.github.cszxyang.annotation.ProcessOrder;
import com.github.cszxyang.entity.ProcessResult;
import com.github.cszxyang.entity.ServiceReq;
import com.github.cszxyang.util.ClassScanner;
import com.github.cszxyang.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
@Slf4j
public class ChainHandlerProcessor implements BeanFactoryPostProcessor {

    private Map<Integer, Class<?>> orderAndClassMap;

    private static final String HANDLER_PACKAGE = "com.github.cszxyang.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        orderAndClassMap = new TreeMap<>();
        ClassScanner.scan(HANDLER_PACKAGE, ProcessOrder.class).forEach(annotationClass -> {
            ProcessOrder processOrder = annotationClass.getAnnotation(ProcessOrder.class);
            orderAndClassMap.put(processOrder.value(), annotationClass);
        });
    }

    public void doProcess(ServiceReq serviceReq) {
        for (Map.Entry<Integer, Class<?>> entry : orderAndClassMap.entrySet()) {
            BaseHandler baseHandler = (BaseHandler) SpringContextHolder.getBean(entry.getValue());
            ProcessResult result = baseHandler.process(serviceReq);
            if (result.isFinished()) {
                return;
            }
        }
    }
}
