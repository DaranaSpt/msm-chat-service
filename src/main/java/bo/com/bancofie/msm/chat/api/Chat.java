package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class Chat {
    @Schema(description = "Id de chat", example = "1")
    private Long id;

    @Schema(description = "Lista de ids de usuarios", example = "[1,2,3]")
    private List<Long> participants;

    @Schema(description = "Fecha de creación", example = "2023-08-30T12:34:00.000")
    private LocalDateTime dateCreated;
}
