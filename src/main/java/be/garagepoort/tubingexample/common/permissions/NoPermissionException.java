package be.garagepoort.tubingexample.common.permissions;

import be.garagepoort.tubingexample.common.exceptions.BusinessException;

public class NoPermissionException extends BusinessException {
    public NoPermissionException() {
        super("You don't have permission to do this.");
    }
}
