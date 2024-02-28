package com.boyslab.ads.aop.ccs.performance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository  extends JpaRepository<PerformanceDetails,Long> {
}
