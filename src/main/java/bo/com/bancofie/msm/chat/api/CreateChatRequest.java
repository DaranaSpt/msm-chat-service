package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class CreateChatRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 1)
    @NotNull
    @Schema(description = "Lista de ids de usuarios", example = "[1,2,3]")
    private List<Long> participants;
}
