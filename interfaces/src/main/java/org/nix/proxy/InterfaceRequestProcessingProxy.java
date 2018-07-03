package org.nix.proxy;

import org.nix.dao.LogDao;
import org.nix.po.LogPo;
import org.nix.po.ParametersPo;
import org.nix.utils.http.AbstractProxyFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.sql.SQLException;

/**
 * 对接口测试的代理类
 * 争对代理类方法的执行前后计入业务逻辑由用户自定义
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class InterfaceRequestProcessingProxy extends AbstractProxyFactory {

    private Object target;

    private long runTime;

    /**
     * 日志记录类
     */
    private LogPo logPo = new LogPo();

    public InterfaceRequestProcessingProxy(Object target) {
        super(target);
        this.target = target;
    }

    @Override
    public void preHandler(Method method ,Object[] args) {
        runTime = System.currentTimeMillis();
        System.out.println("=======================================");
        System.out.println("方法执行开始时间:" + runTime + "/ms");
        System.out.println("执行方法名字 === > "+ target.getClass() + "." + method.getName());
        System.out.println("入参 === >");
        System.out.println("[");

        // 日志添加开始事件和方法名字
        logPo.setStartTime(new Date(runTime));
        logPo.setMethodName(target.getClass() + "." + method.getName());

        int parameterCount = args.length;
        Parameter[] argsName = method.getParameters();
        for (int i = 0; i < parameterCount; i++) {
            // 加入方法参数
            ParametersPo parametersPo = new ParametersPo(argsName[i].getName(),args[i]);
            logPo.addParameter(parametersPo);

            System.out.println(argsName[i] + ":" + args[i]);
        }

        System.out.println("]");
    }

    @Override
    public void postHandler(Object args) {
        long tempTime = System.currentTimeMillis();
        System.out.println("方法执行结束时间:" + tempTime + "/ms");
        System.out.println("方法执行耗时:"+(tempTime-runTime) + "/ms");
        System.out.println("出参 === >");
        System.out.println("[" + args + "]");
        System.out.println("=======================================");

        logPo.setEndTime(new Date(tempTime));
        logPo.setUseTime(tempTime-runTime);
        logPo.setResult(args.toString());
        saveLog();
    }

    private void saveLog(){
        LogDao logDao = new LogDao();
        try {
            logDao.insertCompleteLog(logPo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
