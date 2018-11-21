package com.sinosoft.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author hoverkan
 * @create 2018-11-21 17:00
 * @Aspect ： 告诉Spring当前类是一个切面类
 * 切面类
 */
@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1、本类中引用
    // 2、其他的切面引用
    @Pointcut("execution(public int com.sinosoft.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "运行...参数列表是：{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束");
    }

    @AfterReturning(value = "com.sinosoft.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回...运行结果是：{" + result + "}");
    }


    // JoinPoint joinPoint 在形参列表中，必须放在第一个
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "异常...异常信息是：{" + exception + "}");
    }
}
