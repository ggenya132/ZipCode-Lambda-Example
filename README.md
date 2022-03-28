# ZipCode-Lambda-Example
Introduction to AWS Lambda functions for Zip Code

# Adding http method handlers 
To add additional methods the the http handlers class, implement the method that corresponds to your intended handler
, eg, for `HTTP GET` requests we have a `get` method that returns a function that handles the request. Note the method signature of the function returned, 
`BiFunction<Map<String, Object>, Context, APIGatewayProxyResponseEvent>`: this corresponds to the two arguements passed to the function, (`Event` and `Context`) 
and the response returned, `APIGatewayProxyResponseEvent` 
