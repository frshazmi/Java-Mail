<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
</head>
<body>
    <form action="SendEmailServlet" method="post">
        To: <input type="text" name="to"><br>
        Subject: <input type="text" name="subject"><br>
        Message: <textarea name="message"></textarea><br>
        <input type="submit" value="Send Email">
    </form>
</body>
</html-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send an e-mail</title>
</head>
<body>
    <form action="SendMail" method="post">
        <table border="0" width="35%" align="center">
            <caption><h2>Send New E-mail</h2></caption>
            <tr>
                <td width="50%">Recipient address </td>
                <td><input type="text" name="recipient" size="50"/></td>
            </tr>
            <tr>
                <td>Subject </td>
                <td><input type="text" name="subject" size="50"/></td>
            </tr>
            <tr>
                <td>Message </td>
                <td><textarea rows="10" cols="39" name="message"></textarea> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>

