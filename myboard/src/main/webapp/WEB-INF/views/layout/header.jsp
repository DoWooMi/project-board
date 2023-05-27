<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>

<!-- Navbar STart -->
<header id="topnav" class="defaultscroll sticky">
    <div class="container">
    
        <!-- Logo container-->
        <a class="logo" href="${pageContext.request.contextPath }/">
            <div class="media align-items-center">
                <span class="text-primary">MyBoard</span>
            </div>
        </a>
        <!-- End Logo container-->
        
                      
        <div class="buy-button" >
			  <c:choose>
			    <c:when test="${not empty loginHewon}">
			      <!-- 로그인한 경우 -->
			      <a href="${pageContext.request.contextPath }/logout" class="btn btn-primary scroll-down">
			        <span>Logout</span>
			      </a>
			    </c:when>
			    <c:otherwise>
			      <!-- 로그인하지 않은 경우 -->
			      <a href="${pageContext.request.contextPath }/login" class="btn btn-primary scroll-down">
			        <span>Login</span>
			      </a>
			    </c:otherwise>
			  </c:choose>
        </div>
        <!--end logout button-->

        
	    <!-- Navigation Menu-->   
        <div id="navigation">
            <ul class="navigation-menu">
                <li>
                    <a href="${pageContext.request.contextPath }/mypage">MyPage</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/blog">Blog</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/new">New Post</a>
                </li>
            </ul>
        </div><!--end navigation-->
    </div><!--end container-->
</header><!--end header-->
<!-- Navbar End -->