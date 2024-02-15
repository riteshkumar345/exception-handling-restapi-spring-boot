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
