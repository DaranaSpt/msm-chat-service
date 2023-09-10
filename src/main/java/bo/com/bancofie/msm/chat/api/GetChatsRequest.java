package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class GetChatsRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(0)
    @Schema(description = "Id de chat, enviar 0 para enviar todos los chats del usuario", example = "1")
    private Long id;
}
