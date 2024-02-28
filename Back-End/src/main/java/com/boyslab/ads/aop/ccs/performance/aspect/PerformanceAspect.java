package com.boyslab.ads.aop.ccs.performance.aspect;

import com.boyslab.ads.aop.ccs.performance.PerformanceDetails;
import com.boyslab.ads.aop.ccs.performance.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class PerformanceAspect {

    private final PerformanceRepository repository;

    @Pointcut("@annotation(com.boyslab.ads.aop.aspects.PerformanceLogger)")
    public void measureMethod() {}

    @Around("measureMethod()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.nanoTime() - start;
            long proceedTime = executionTime / 1_000_000;

            PerformanceDetails log = new PerformanceDetails();
            log.setClassName(joinPoint.getSignature().getDeclaringTypeName());
            log.setMethodName(joinPoint.getSignature().getName());
            log.setProceedTime(proceedTime);

            repository.save(log);
        }
    }

}
