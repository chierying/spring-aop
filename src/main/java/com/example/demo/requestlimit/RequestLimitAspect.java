package com.example.demo.requestlimit;

import com.example.demo.requestlimit.Exceptions.RequestLimitException;
import com.example.demo.requestlimit.annotation.RequestLimit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by v_zhangbing on 2017/7/2.
 * 访问限制的切面
 * 要使切面生效, 需要:
 * 1 @Aspect注解
 * 2 声明为Spring Bean
 * 3 启用 @EnableAspectJAutoProxy 注解
 */
@Aspect
@Slf4j
public class RequestLimitAspect {

    /**
     * 此处定义切点, 这里的2个切点表达式是and的关系:
     * "@annotation(requestLimit)"连接点方法上必须有这个注解, 注解类型写在参数上了.
     * -@within 和 within 差不多都是限制连接点类型的. 前者表示连接点是具有某种注解的类型, 后者表示连接点是某种类型.
     * 此处限定连接点要具有Controller注解
     *
     * @param joinPoint
     * @param requestLimit
     * @throws RequestLimitException
     */
    @Before("@annotation(requestLimit) && @within(org.springframework.stereotype.Controller)")
    public void requestLimit(JoinPoint joinPoint, RequestLimit requestLimit) throws RequestLimitException {
        HttpServletRequest request = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
                break;
            }
        }

        if (request == null) {
            throw new RequestLimitException("参数中没有HttpServletRequest");
        }

        log.info("设定的访问次数:{}, 时间:{}", requestLimit.count(), requestLimit.time());

        String ip = request.getRemoteHost();
        String uri = request.getRequestURI();

        throw new RequestLimitException("访问超出了限制, ip:" + ip + " url:" + uri);
    }

}
