package be.garagepoort.tubingexample.common.exceptions;

public class NoPermissionException extends BusinessException {
    public NoPermissionException() {
        super("You don't have permission to do this.");
    }
}
