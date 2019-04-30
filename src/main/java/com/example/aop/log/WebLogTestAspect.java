package com.example.aop.log;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
@Service
@Aspect
@Profile({"dev", "test"}) //ֻ�����ڲ��Ի���
public class WebLogTestAspect {
	
	private final static Logger logger         = LoggerFactory.getLogger(WebLogTestAspect.class);
	    /** ���з� */
	private static final String LINE_SEPARATOR = System.lineSeparator();
	
	
	/** ���Զ��� @WebLog ע��Ϊ�е� */
    @Pointcut("@annotation(com.example.aop.log.WebTestLog)")
    public void webLog() {}
	
	 /**
     * ���е�֮ǰ֯��
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // ��ʼ��ӡ������־
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // ��ȡ @WebLog ע���������Ϣ
        String methodDescription = getAspectLogDescription(joinPoint);

        // ��ӡ������ز���
        
        logger.info("========================================== Start ==========================================");
        // ��ӡ���� url
        logger.info("URL            : {}", request.getRequestURL().toString());
		/*
		 * // ��ӡ������Ϣ logger.info("Description    : {}", methodDescription); // ��ӡ Http
		 * method logger.info("HTTP Method    : {}", request.getMethod()); // ��ӡ����
		 * controller ��ȫ·���Լ�ִ�з��� logger.info("Class Method   : {}.{}",
		 * joinPoint.getSignature().getDeclaringTypeName(),
		 * joinPoint.getSignature().getName()); // ��ӡ����� IP
		 * logger.info("IP             : {}", request.getRemoteAddr()); // ��ӡ�������
		 * logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
		 */
    }

    /**
     * ���е�֮��֯��
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        // �ӿڽ������У�����ָ�鿴
        logger.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    /**
     * ����
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // ��ӡ����
        logger.info("Response Args  : {}", new Gson().toJson(result));
        // ִ�к�ʱ
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
    
    /**
     * ��ȡ����ע�������
     *
     * @param joinPoint �е�
     * @return ������Ϣ
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebTestLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}
