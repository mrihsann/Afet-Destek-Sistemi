package com.boyslab.ads.aop.ccs.logger.aspect;

import com.boyslab.ads.aop.aspects.logger.LoggerResult;
import com.boyslab.ads.aop.ccs.logger.LogType;
import com.boyslab.ads.aop.ccs.logger.loggerManager.DatabaseLogger;
import com.boyslab.ads.aop.ccs.logger.loggerManager.FileLogger;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.Result;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@RequiredArgsConstructor
@Component
public class LoggerAspect {

    private final DatabaseLogger databaseLogger;
    private final FileLogger fileLogger;

    @Pointcut("@annotation(logResult)")
    public void callLogResultMethod(LoggerResult logResult) {}


    @AfterReturning(value = "callLogResultMethod(logResult)",returning ="result")
    public void logger(JoinPoint point, LoggerResult logResult, Result result) throws Throwable {

        LogType logType = logResult.type();
        switch (logType){
            case DATABASE -> databaseLogger.logToDb(point, result);
            case FILE -> fileLogger.logToFile(point, result);
            default -> throw new BusinessException("Loglarken hata meydana geldi.");
        }
    }
}
