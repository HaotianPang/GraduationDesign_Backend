package com.ttai.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用的返回对象
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-07 00:09:49
 * @see com.ttai
 */
@Data
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 8486468806063544444L;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "系统状态码,-1为请求成功，其他可根据错误码查询接口进行查询")
    private Integer code;

    /**
     * 消息
     */
    @ApiModelProperty("提示消息")
    private String message;

    /**
     * 返回对象
     */
    @ApiModelProperty("响应数据")
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer code) {
        super();
        this.code = code;
    }

    public ResponseResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, Throwable throwable) {
        super();
        this.code = code;
        this.message = throwable.getMessage();
    }

    public ResponseResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(ResultEnum resultEnum) {
        super();
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }

    public ResponseResult(ResultEnum resultEnum, T data) {
        super();
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ResponseResult<?> other = (ResponseResult<?>) obj;
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!data.equals(other.data)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        if (code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResponseResult [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}
