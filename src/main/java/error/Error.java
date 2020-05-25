package error;

import org.springframework.util.StringUtils;

public final class Error {
    private static final String ERROR_1 = "Код ошибки не может быть пустым";

    public static String printError(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }

    public static void raise(String code, Object... args) throws Exception { throw new Exception(_message(code, args)); }

    private static String checkCode(String code) throws Exception {
        if (StringUtils.isEmpty(code)) { raise(ERROR_1); }
        return code.trim().toUpperCase();
    }

    private static String format(String code, Object... args) throws Exception { return String.format(format(code), args); }

    private static String _message(String code, Object ... args) throws Exception { return format(checkCode(code), args); }
}
