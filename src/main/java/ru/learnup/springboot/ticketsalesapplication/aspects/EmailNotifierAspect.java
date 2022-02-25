package ru.learnup.springboot.ticketsalesapplication.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.learnup.springboot.ticketsalesapplication.services.EntertainmentService;

@Component
@Aspect
public class EmailNotifierAspect {

    @Pointcut("@annotation(ru.learnup.springboot.ticketsalesapplication.annotations.Loggable)")
    public void EntertainmentServiceLog(){}

    @AfterReturning("EntertainmentServiceLog()")
    public void afterReturning(JoinPoint point) {
        send("After returning " + point.getSignature().getName() + "()");
    }

    @AfterThrowing("EntertainmentServiceLog()")
    public void afterThrowing(JoinPoint point) {
        send("After exception in " + point.getSignature().getName() + "()");
    }

    public void send(Object obj){
        System.out.println(obj);
    }
}
