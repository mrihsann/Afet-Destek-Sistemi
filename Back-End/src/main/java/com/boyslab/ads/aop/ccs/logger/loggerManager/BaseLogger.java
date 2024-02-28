package com.boyslab.ads.aop.ccs.logger.loggerManager;

import com.boyslab.ads.aop.ccs.logger.LogDetails;
import com.boyslab.ads.aop.ccs.logger.LogStatus;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Field;
import java.util.Date;

public interface BaseLogger {

    default LogDetails writeLog(JoinPoint point, Result result) throws Throwable{
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();
        String params = "";
        if (args.length>0){
            StringBuilder paramsBuilder = new StringBuilder();
            for (Object arg : args){
                paramsBuilder.append(arg.getClass().getSimpleName())
                        .append(":{");

                Field[] fields = arg.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);

                    try{
                        paramsBuilder.append(field.getName())
                                .append(":")
                                .append(field.get(arg).toString())
                                .append(", ");
                    }catch (IllegalAccessException e){
                        throw new BusinessException(e.getMessage());
                    }
                }
                paramsBuilder.setLength(paramsBuilder.length()-2);
                paramsBuilder.append("}, ");
            }
            paramsBuilder.setLength(paramsBuilder.length()-2);
            params=paramsBuilder.toString();
        }
        LogDetails logDetails = new LogDetails();
        logDetails.setMethodName(methodName);
        logDetails.setParameters(params);
        logDetails.setLogDate(new Date());
        logDetails.setReturnValue(result.getMessage());

        if (result.isSuccess()) logDetails.setLogStatus(LogStatus.INFO);
        else logDetails.setLogStatus(LogStatus.ERROR);

        return logDetails;
    }
}
