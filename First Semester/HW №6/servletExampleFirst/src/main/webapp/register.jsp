<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/register.css" />
</head>
<body>
    <section class="registration">
        <form action="register" method="POST" name="registration-form   ">
            <label >Your name</label>
            <input  name='name' type="text">

            <label  >Your email</label>
            <input name='email' type="text">


            <label  >Password</label>
            <input name='password' type="password">


            <label  >Password [repeat]</label>
            <input name='password2' type="password">

            <label  class="check-box">Agree with terms
                <input name='agreement' type="checkbox" checked="checked">
                <span class="checkmark"></span>
            </label>


            <button type="submit" class="register_button">Register</button>
        </form>
    </section>
</body>
</html>
