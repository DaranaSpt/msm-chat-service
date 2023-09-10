package bo.com.bancofie.msm.chat.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errMsg;

    public BaseResponse(T data) {
        this.data = data;
    }
}
