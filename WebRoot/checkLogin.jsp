<%
if((String)session.getAttribute("LOGIN")==null){
response.sendRedirect("login.jsp");
}
 %>