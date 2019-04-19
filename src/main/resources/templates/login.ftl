<!DOCTYPE html>
<html lang="en">
<#include "components/head.ftl"/>
<body>
<main>
    <div class="text-center">
        <form id="form-signin" action="/do_login" method="POST">
            <img class="mb-4" src="/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Email address" required autofocus>
            <!--<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>-->
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
            <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}">
            <!--<div class="checkbox mb-3">-->
            <!--<label>-->
            <!--<input type="checkbox" value="remember-me"> Remember me-->
            <!--</label>-->
            <!--</div>-->
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
        </form>
    </div>
</main>
<!--required scripts-->
<#include "components/scripts.ftl"/>
<!--page scripts-->
<script>

</script>
</body>
</html>