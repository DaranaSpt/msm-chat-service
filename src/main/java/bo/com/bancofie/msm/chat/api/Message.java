package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Message {
    @Schema(description = "Id de mensaje", example = "1")
    private Long id;
    @Schema(description = "Id del participante", example = "1")
    private Long participantId;
    @Schema(description = "Contenido del texto", example = "Hola")
    private String text;
    @Schema(description = "Estado de party", example = "false")
    private Boolean party;
    @Schema(description = "Estado de leido", example = "false")
    private Boolean read;
    @Schema(description = "Fecha de creación", example = "2023-08-30T12:34:00.000")
    private LocalDateTime dateCreated;
}
