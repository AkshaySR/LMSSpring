<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.lms.entity.Author" %>
    <%@ page import="com.gcit.lms.entity.Book" %>
    <%@ page import="com.gcit.lms.service.AdministratorService" %>
    <% 
    	AdministratorService service = new AdministratorService();
    	List<Book> books = service.getAllBooks();
    %>
    <script>
    	function validateAuthorName(){
    		var aname = $('#authorName').val();
    		if(aname.length <3){
    			$('#notification').toggle();
    			$('#failure').show();
    		}
    	}
    </script>
<h2>Welcome to GCIT Library Management System - Admin</h2>
<h3>Enter Author Details Below:</h3>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
${result}
	<div id="notification">
	  
	  <span class="sr-only">Error: Author name should be more than 3 chars</span>
	</div>

	<form action="addAuthor" method="post">
		Author Name: <input type="text" name="authorName" id="authorName"> <br />
		Associate author to books:<br/>
		<select name="bookId">
			<%for(Book b: books){ %>
			<option onc value="<%=b.getBookId()%>"><%=b.getTitle() %></option>
			<%} %>
		</select>
		<br/>
		<button type="button" onclick="validateAuthorName()">Add Author</button>
	</form>
