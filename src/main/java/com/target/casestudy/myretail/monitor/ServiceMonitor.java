package com.target.casestudy.myretail.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceMonitor {

	private static final Logger log = LoggerFactory.getLogger(ServiceMonitor.class);
	
	@Around("execution(* com.target.casestudy..*Service.*(..))")
	public Object captureTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		
		if(log.isDebugEnabled()){
			log.debug("Execution time for: "+pjp.toShortString()+ " is:"+(System.currentTimeMillis()-start)+"ms");
		}
		
		return retVal;
		
	}
	
	
}
