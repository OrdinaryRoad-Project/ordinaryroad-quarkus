package tech.ordinaryroad.commons.core.quarkus.base.handler;

import tech.ordinaryroad.commons.base.cons.IStatusCode;
import tech.ordinaryroad.commons.base.exception.BaseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Objects;

/**
 * BaseException 异常拦截器
 */
@Provider
public class BaseExceptionHandler implements ExceptionMapper<BaseException> {

    @Override
    public Response toResponse(BaseException exception) {
        if (Objects.nonNull(exception)) {
            IStatusCode statusCode = exception.getStatusCode();
            return Response.status(statusCode.getCode(), statusCode.getMessage())
                    .build();
        }
        return null;
    }

}
