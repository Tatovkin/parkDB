<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<head>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<form class="form-horizontal" action="do?command=Signup" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="login">Login</label>
            <div class="col-md-3">
                <input id="login" name="login" type="text" placeholder="UserLogin" class="form-control input-md"
                       required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="password">Password</label>
            <div class="col-md-3">
                <input id="password" name="password" type="password" placeholder="UserPassword"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-3 control-label" for="email">Email</label>
            <div class="col-md-3">
                <input id="email" name="email" type="text" placeholder="Enter your email" class="form-control input-md"
                       required="">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-3 control-label" for=""></label>
            <div class="col-md-3">
                <button id="" name="" class="btn btn-primary">Зарегистрировать</button>
            </div>
        </div>

    </fieldset>
</form>
</body>

<%@ include file="include/end-html.jsp" %>
