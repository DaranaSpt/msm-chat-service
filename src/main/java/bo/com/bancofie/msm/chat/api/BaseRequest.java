package bo.com.bancofie.msm.chat.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequest<T> implements Serializable {
  private T data;
}
