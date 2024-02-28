package com.boyslab.ads.aop.ccs.logger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<LogDetails,Integer> {
}
