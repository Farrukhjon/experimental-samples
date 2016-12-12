package org.netty.server.experiment.http;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;

public class DefaultHttpResponseProvider extends HttpResponseProvider {

    @Override
    protected boolean haveMatchingResource(HttpRequest request) {
        return true;
    }

    @Override
    protected boolean isSupportedMethod(HttpRequest request) {
        return true;
    }

    @Override
    protected FullHttpResponse generateResponse(HttpRequest request, HttpHeaders headers) {
        return createSuccessResponse("Hello world!");
    }

}
