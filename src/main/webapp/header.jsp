<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <style>
        body {
            margin: 0;
        }

        div.c {
            width: 900px;
            height: 100px;
            margin: auto;
        }

        div.a {
            float: left;
            margin: 0;
        }

        div.b {
            float: left;
            margin: 0;
        }

        div.d {
            float: left;
            margin: 0;
        }

        div.clear {
            clear: both;
        }


        input.formClass[type="submit"] {
            width: 200px;
            height: 100px;
            color: white;
            margin-right: 50px;
            margin-left: 50px;
            background-color: darkslategrey;
            font-size: large;
            border-radius: 25px;
            margin-top: 8px;
        }

        input.formClass:hover {
            background-color: #111;
        }
    </style>
</head>
<body>

<div class="c">
    <div class="a">
        <form action="login.jsp" method="POST">
            <input class="formClass" type="submit" name="userName" value="User"/>
        </form>
    </div>

    <div class="b">
        <form action="login.jsp" method="POST">
            <input class="formClass" type="submit" name="userName" value="Admin"/>
        </form>
    </div>

    <div class="d">
        <form action="index.jsp" method="POST">
            <input class="formClass" type="submit" value="Main menu"/>
        </form>
    </div>
    <div class="clear"></div>
</div>

</body>
</html>
