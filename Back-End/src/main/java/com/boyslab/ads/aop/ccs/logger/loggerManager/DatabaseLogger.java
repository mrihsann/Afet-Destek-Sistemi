package com.boyslab.ads.aop.ccs.logger.loggerManager;

import com.boyslab.ads.aop.ccs.logger.LogDetails;
import com.boyslab.ads.aop.ccs.logger.LoggerRepository;
import com.boyslab.ads.core.result.Result;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseLogger implements  BaseLogger{

    private final LoggerRepository loggerRepository;

    public void logToDb (JoinPoint point, Result result) throws Throwable {
        LogDetails logDetails = writeLog(point,result);
        this.loggerRepository.save(logDetails);

    }
}
