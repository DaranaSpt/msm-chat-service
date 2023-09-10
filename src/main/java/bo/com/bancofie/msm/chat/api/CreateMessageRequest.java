package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CreateMessageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(1)
    @Schema(description = "Id del chat", example = "1")
    private Long chatId;
    @NotNull
    @NotBlank
    @Schema(description = "Texto del chat", example = "texto de mensaje")
    private String text;
}
