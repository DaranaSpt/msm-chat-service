package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class GetMessagesResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @Schema(description = "Número de página", example = "1")
  private Long page;
  @Schema(description = "Lista de mensajes")
  private List<Message> items;
}
