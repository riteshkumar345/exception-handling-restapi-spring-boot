# Exception Handling In REST API
1. Exception is an unexpected and unwanted situation occuring in the application
2. When exception occured our program will terminate abnormally
3. To achieve graceful termination of the program we need to handle the exception
4. In Java we have below keywords to handle the exceptions
    try     :  It is used to keep risky code
    catch   :  Catch block is used to handle the exception
    throw   :  It is used to re-throw the exception
    throws  :  It is used to ignore the exception
    finally :  It is used to execute clean up logic (closing files, closing connection, release resources....)

# When we get exception in REST API we should convey that exception information to client/consumer application in json format.
    Example
    {
	    msg : "Exception Reason"
	    code : "SBI0004"
    }
# In Spring Web MVC, we can handle exceptions in 2 ways
   # 1) Controller Based Exception Handling 
      - Exception Handlers applicable for only particular controller
   # 2) Global Exception Handling
      - Exception Handlers applicable for all the classes in the project

# Testing API from Browser/Postman

# 1. Request : http://localhost:8080/status                     [GET] : No Body

   Response from Global Exception handler class i.e. AppExceptionHandler.java

   Respone : {
    		"msg": "/ by zero",
    		"code": "PRE.DEFINED.EXCEP.CODE.0001"
	     }
   Http Status Code : 500 Internal Server Error
    --------------- OR ------------------
   If you un-comment Controller Based Exception Handling method i.e. handleAE(-)#ControllerBasedExceptionHandling,
   then you get response from particular controller

   Respone : {
    		"msg": "/ by zero",
    		"code": "ABC0004"
	     }
   Http Status Code : 500 Internal Server Error

  
# 2. Valid Request : http://localhost:8080/book/{ISBN001}       [GET] No Body
   Respone : 	Book Price is $ 48

# 3. In-valid Request : http://localhost:8080/book/{ISBN002}    [GET] No Body

   Respone : {
    		"msg": "Invalid ISBN",
    		"code": "USER.DEFINE.EXCEP.CODE.9999"
	     }
   Http Status Code : 400 Bad Request
