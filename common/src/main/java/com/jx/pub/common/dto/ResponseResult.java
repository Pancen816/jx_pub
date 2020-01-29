package com.jx.pub.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用数据传输对象
 *
 * @author Faxon
 * @date 2019-07-26 04:43:54
 */
@ApiModel(description = "通用数据返回对象")
@Data
public class ResponseResult<T> implements Serializable {
    
    private static final long serialVersionUID = 222936194482537280L;
    
    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    /**
     * 消息
     */
    @ApiModelProperty(value = "操作消息")
    private String message;

    /**
     * 返回对象
     */
    @ApiModelProperty(value = "返回对象(数据)")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseResult() {
        super();
    }
    
    public ResponseResult(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public ResponseResult(Boolean success, Throwable throwable) {
        super();
        this.success = success;
        this.message = throwable.getMessage();
    }

    public ResponseResult(Boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public ResponseResult(Boolean success, String message, T data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((success == null) ? 0 : success.hashCode());
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
        if (success == null) {
            if (other.success != null) {
                return false;
            }
        } else if (!success.equals(other.success)) {
            return false;
        }
        return true;
    }
}
