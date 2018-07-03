package org.nix.po;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class LogPo {

    private String methodName;

    private String result;

    private long useTime;

    private Date startTime;

    private Date endTime;

    private Date creteTime;

    private List<ParametersPo> parametersPos;

    public LogPo() {
    }

    public LogPo(String methodName, String result, int useTime, Date startTime, Date endTime) {
        this.methodName = methodName;
        this.result = result;
        this.useTime = useTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<ParametersPo> getParametersPos() {
        return parametersPos;
    }

    public void setParametersPos(List<ParametersPo> parametersPos) {
        if (this.parametersPos == null){
            this.parametersPos = parametersPos;
        }else {
            this.parametersPos.addAll(parametersPos);
        }
    }

    public void addParameter(ParametersPo parametersPo){
        if (this.parametersPos == null){
            this.parametersPos = new ArrayList<>(5);
            this.parametersPos.add(parametersPo);
        }else {
            this.parametersPos.add(parametersPo);
        }
    }

    public Date getCreteTime() {
        return creteTime;
    }

    public void setCreteTime(Date creteTime) {
        this.creteTime = creteTime;
    }

    @Override
    public String toString() {
        return "LogPo{" +
                "methodName='" + methodName + '\'' +
                ", result='" + result + '\'' +
                ", useTime=" + useTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creteTime=" + creteTime +
                ", parametersPos=" + parametersPos +
                '}';
    }
}
