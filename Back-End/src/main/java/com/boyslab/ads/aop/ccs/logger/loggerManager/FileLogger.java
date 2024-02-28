package com.boyslab.ads.aop.ccs.logger.loggerManager;

import com.boyslab.ads.aop.ccs.logger.LogDetails;
import com.boyslab.ads.core.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class FileLogger implements  BaseLogger{

    private final ObjectMapper objectMapper;

    public FileLogger(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void logToFile(JoinPoint point, Result result) throws Throwable {
        LogDetails logDetails = writeLog(point, result);
        String logMessage = objectMapper.writeValueAsString(logDetails) + System.lineSeparator();
        String fileName = "logs/myapp.log.txt";
        Path path = Paths.get(fileName);


        if (Files.notExists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }


        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        Files.write(path, logMessage.getBytes(), StandardOpenOption.APPEND);
    }
}
