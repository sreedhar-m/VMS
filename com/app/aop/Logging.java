package com.app.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
//
//@Aspect
//@Component
public class Logging {

	private final Log log=LogFactory.getLog(this.getClass());

	@Pointcut("execution(* com.app.*..*.*(..))")
	public void point1(){}

	//	@Around("point1()")
	//	public Object CalculateTime(ProceedingJoinPoint pjp) throws Throwable{
	//	    StopWatch watch=new StopWatch(pjp.getTarget().getClass().getName());
	//	    watch.start(pjp.getSignature().getName());
	//		Object ob=pjp.proceed();
	//		watch.stop();
	//		System.out.println(watch.prettyPrint());
	//		return ob;
	//	}

		@Around("point1()")
		public Object logTimeMethod(ProceedingJoinPoint pjp) throws Throwable{
			Object ob=null;
			StopWatch sw=new StopWatch(pjp.getTarget().getClass().getName());
			//before business
			sw.start();
			ob=pjp.proceed();
			//after business
			sw.stop();
			log.info("sampleTest");
			return ob;
		}


}
