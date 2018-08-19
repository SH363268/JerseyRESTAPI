package test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
    
    
    @GET
    @Path("/sayhello")
    @Produces(MediaType.TEXT_XML)
    public String sayhello(){
	
	String response = "<?xml version='1.0'?>"+"<hello> hello </hello>";
	
	return response;
    }

    @GET
    @Path("ccCheck")
    @Produces(MediaType.TEXT_HTML)
    public String hellotext(@QueryParam("name") String name,@QueryParam("Card_no") String Card_no,@QueryParam("amount") int amount){
	System.out.println("Name is: "+name);
	System.out.println("Amount is"+amount);	
	String response;
	
	if(amount> 100000){
	    System.out.println("amount is > 100000");
	    response = "credit card is not approved";
	}else{
	    System.out.println("amount is < 100000");
	    response = "credit card is accepted";
	}
	
	return "<html>"+"<title>"+ name +"</title>"+"<body><h1>"+response+"</h1></body>"+"</html>";
    }
    
    @GET
    @Path("readComment")
    @Produces(MediaType.APPLICATION_JSON)
    public String validateComment(@QueryParam("comment") String comment){
	
	System.out.println("comment with replace all is: "+comment.replaceAll("\"", ""));
	
	String response = "";
	int countofobjwordsincomment = 0;
	
	String parentlibrary = "bad worst annoying irritated waste";
	System.out.println("what is the result of replaceAll? "+parentlibrary.replaceAll("\"", ""));
	String[] parentlibinarray = parentlibrary.replaceAll("\"", "").split(" ");
	
	ArrayList<String> listofobjectionablewords = new ArrayList<String>() ;

	for(String eachobjectionableword: parentlibinarray){
	    listofobjectionablewords.add(eachobjectionableword.toLowerCase());
	}
	
	String[] listofwordsincomment = comment.replaceAll("\"","").split(" ");
	System.out.println("length of given comment string array is "+listofwordsincomment.length);
	if(listofwordsincomment.length > 0){
	    for(String eachword: listofwordsincomment){
		System.out.println("each word from comment is: "+eachword);
		if(listofobjectionablewords.contains(eachword)){
		    countofobjwordsincomment++;
		}
		
//		if(parentlibrary.toLowerCase().contains(eachword.toLowerCase())){
//		    countofobjwordsincomment++;
//		}		
	    }
	}
	System.out.println("objectionable words count: "+countofobjwordsincomment);
	if(countofobjwordsincomment > 0){
	    response = "Comment contains objectionable words";
	}else{
	    response = "canProceed";
	}
	return response;
    }
	
//	//ArrayList<String> listofobjectionablewords = new ArrayList<String>() ;
//	String[] listofwordsincomment = comment.substring(1,comment.length()-1).split(" ");
//	System.out.println("length of given comment string array is "+listofwordsincomment.length);
//	if(listofwordsincomment.length > 0){
//	    for(String eachword: listofwordsincomment){
//		System.out.println("each word from comment is: "+eachword);
//		if(parentlibrary.toLowerCase().contains(eachword.toLowerCase())){
//		    countofobjwordsincomment++;
//		}		
//	    }
//	}
//	System.out.println("objectionable words count: "+countofobjwordsincomment);
//	if(countofobjwordsincomment > 0){
//	    response = "Comment contains objectionable words";
//	}else{
//	    response = "canProceed";
//	}
//	return response;
//    }
    
    
}
