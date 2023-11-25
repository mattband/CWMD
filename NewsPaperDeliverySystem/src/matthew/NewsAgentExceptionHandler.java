package matthew;
// project exception handeler. no need to create other.
	public class NewsAgentExceptionHandler extends Exception{
	    
		 String message;
		
		public NewsAgentExceptionHandler(String errMessage){
			message = errMessage;
			
		}
		
		public String getMessage() {
			return message;
		}
}
	
