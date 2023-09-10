package bo.com.bancofie.msm.chat.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class GetChatsResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Lista de chats")
    private List<Chat> items;
}
