package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;


import java.util.Map;
import java.util.function.BiFunction;

public class Handler implements RequestHandler<Map<String, Object>, APIGatewayProxyResponseEvent> {

    HttpHandlers httpHandlers;

    public Handler() {
      this.httpHandlers  = new HttpHandlers();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(Map<String, Object> event, Context context) {
            String methodRequest = (String) event.get("httpMethod");
            BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent> httpMethodHandler =  httpHandlers.getHttpMethodHandlers().get(methodRequest);
            return httpMethodHandler.apply(event,context);
    }
}
