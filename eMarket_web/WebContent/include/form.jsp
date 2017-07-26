<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="pop" class="wrap">
	<div class="pop">
		<div class="head">
			登陆与注册<span class="close" onclick="hide()">×</span>
		</div>
		<div class="reg">
			<form action="${pageContext.request.contextPath}/login" method="post">

				<input class="button" name="username" type="text" placeholder="请输入用户名" /> <input
					class="button" type="password" placeholder="请输入密码" name="password"/>
				<div class="mid">
					<input type="checkbox" />两周内自动登陆 <a href="#" class="fp">忘记密码？</a>
				</div>
				<p>
					<br /> <input type="submit"
						style="border: gray 1px solid;background-color: white;color: gray"
						value="立即登陆" class="login btn" /> <a class="regnow btn"
						href="register.jsp">注册</a>
				</p>
			</form>
		</div>
	</div>
</div>