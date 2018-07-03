package org.nix.po;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class ParametersPo {

    private String parameterName;

    private Object value;

    public ParametersPo(String parameterName, Object value) {
        this.parameterName = parameterName;
        this.value = value;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParametersPo{" +
                "parameterName='" + parameterName + '\'' +
                ", value=" + value +
                '}';
    }
}
