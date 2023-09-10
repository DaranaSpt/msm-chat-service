package bo.com.bancofie.msm.chat.handler;

public class MagentaException extends Exception {
    private final String errcode;

    public MagentaException(String message) {
        this(MagentaConstants.ERR_GENERIC,message);
    }

    public MagentaException(String errCode, String message) {
        super(String.format("%s: %s", errCode, message));
        this.errcode = errCode;
    }

    public String getErrCode() {
        return errcode;
    }
}