package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class HttpHandlers {
    public Map<String, BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent>> httpMethodHandlers;

    public Map<String, BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent>> getHttpMethodHandlers() {
        return httpMethodHandlers;
    }


    private StudentService studentService;

    public HttpHandlers() {
        this.studentService = new StudentService();
        httpMethodHandlers = new HashMap<>();
        httpMethodHandlers.put("GET", get());
        httpMethodHandlers.put("POST", post());
    }

    private BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent> get() {
        return (event, context) -> {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            LambdaLogger logger = context.getLogger();

            String response;
            logger.log("CONTEXT: " + gson.toJson(context));
            logger.log("EVENT: " + gson.toJson(event));

            response = gson.toJson(this.studentService.getStudents()).replace("\\\\", "");

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(response)
                    .withIsBase64Encoded(false);
        };
    }

    private BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent> post() {
        return (event, context) -> {
            String response;


            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            LambdaLogger logger = context.getLogger();

            logger.log("CONTEXT: " + gson.toJson(context));
            logger.log("EVENT: " + gson.toJson(event));
            String eventBody = (String) event.get("body");
            Map<String, String> requestBodyJson = gson.fromJson(eventBody, Map.class);

            logger.log("REQUEST BODY: " + gson.toJson(requestBodyJson));

            response = gson.toJson(this.studentService.addStudent(requestBodyJson)).replace("\\\\", "");

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(response)
                    .withIsBase64Encoded(false);
        };
    }


}
