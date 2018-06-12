<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ attribute name="captKey" required="true" %>
<br>
<div class="login-mail">
    <img alt="captcha"	src="captcha?captchaKey=${captKey}">
    <br>
    <input type="hidden" name="captchaKey" value="${captKey}">
    <div class="login-mail">
        <input type="text" name="captcha"  placeholder="Enter captcha">
    </div>
    <div class="error-block">
        <span>${sessionScope.errors.captcha}</span>
    </div>
</div>