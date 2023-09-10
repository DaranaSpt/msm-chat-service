package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DeleteChatResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Id del chat", example = "1")
    private Long id;
    @Schema(description = "Status del chat", example = "DELETED")
    private String status;
}
