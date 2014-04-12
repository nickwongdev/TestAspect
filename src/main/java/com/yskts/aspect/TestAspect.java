package com.yskts.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Nick on 4/12/14.
 */
@Aspect
public class TestAspect {
    @Around(value = "pointcutTest() && @annotation(testAnnotation)", argNames = "pjp,testAnnotation")
    public Object aroundPointcutTest(final ProceedingJoinPoint pjp, final TestAnnotation testAnnotation) throws Throwable {
        System.out.println("Before!");
        final Object retval = pjp.proceed();
        System.out.println("After!");
        return retval;
    }



    @Pointcut("execution(@com.yskts.aspect.TestAnnotation * *.*(..))")
    public void pointcutTest() {
    }
}
