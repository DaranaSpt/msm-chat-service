package bo.com.bancofie.msm.chat.handler;

public class MagentaConstants {

    // Constants for error messages
    public static final String ERR_TOKEN = "ERR10001";
    public static final String ERR_USER_CREATION = "ERR10002";
    public static final String ERR_GET_USER = "ERR10003";
    public static final String ERR_SAVE_USER = "ERR10004";
    public static final String ERR_GENERIC = "ERR10005";
    public static final String ERR_NOT_FOUND = "ERR102";
    public static final String ERR_INVALID_CREDENTIALS = "Credenciales incorrectas";
    public static final String ERR_USER_EXISTS = "Usuario ya tiene una cuenta existente";
    public static final String ERR_TOKEN_MESSAGE = "Error de Token";
    public static final String ERR_USER_CREATION_MESSAGE = "Error de creación de usuario";
    public static final String ERR_GET_USER_MESSAGE = "Error de obtener usuario";
    public static final String ERR_SAVE_USER_MESSAGE = "Error al guardar usuario";
    public static final String ERR_GENERIC_MESSAGE = "Error Genérico";
    public static final String ERR_NOT_FOUND_MESSAGE = "No se pudo encontrar el usuario con el id: ";

    // Constants for success messages
    public static final String SUCCESS_USER_CREATED = "CREATED";
    public static final String SUCCESS_SESSION_STARTED = "Sesión iniciada";
    public static final String SUCCESS_PASSWORD_CHANGED = "Contraseña cambiada con éxito";
    public static final String SUCCESS_USER_CREATED_RESPONSE = "Usuario creado con éxito";

    private MagentaConstants() {
        // Private constructor to prevent instantiation.
    }
}
