package io.kimmking.rpcfx.exception;

/**
 * @author Hotstrip
 * Rpc 自定义异常
 */
public class RpcException extends RuntimeException {

    public RpcException() {
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }
}
