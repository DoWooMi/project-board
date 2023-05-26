<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
    
<!DOCTYPE html>
<html>
<head >
<style type="text/css">

</style>
<meta charset="UTF-8">
<title>Blog view</title>
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body>

<!-- BLOG POST-->
 <section class="blogs md">
     <div class="container">
         <div class="row">

             <div class="w-75" style="margin:0 auto; text-align: left;">
                 <div class="posts">
                     <!-- post -->
                     <div class="post">
                         <div class="content">
                             <div class="post-meta">
                                 <div class="post-title">
                                     <h2>${boardview.title}</h2>
                                     <hr>
                                 </div>
                                 <ul class="meta ps-0 d-flex justify-content-between">
                                     <li>조회수 : <span>${boardview.cnt }</span></li>
                                     <li>작성자 : <span>${hewoninfo.name }</span></li>
                                     <li>작성일자 : <span>${boardview.cdate }</span></li>
                                 </ul>
                             </div>
                         <div class="post-img">
                             <a href="#" class="w-100">
                                 <img src="${pageContext.request.contextPath}/img/${boardview.img}" class="img-style">
                             </a>
                         </div>
                             <div class="post-cont" style="white-space: pre-wrap;">
                                 <p>${boardview.content}</p>
                             </div>
                         </div>
                     </div>
                     <!-- end post -->
                     
                    <div style="text-align: center;">
					<br>
					<p><button onclick="location.href='${pageContext.request.contextPath }/view?bidx=${boardview.bidx }';" type="button" class="btn btn-primary btn-sm" >게시글변경</button>
					<button onclick="location.href='${pageContext.request.contextPath }/blog';" type="button" class="btn btn-primary btn-sm">게시글목록</button>
					<button onclick="location.href='${pageContext.request.contextPath }/blog';" type="button" class="btn btn-primary btn-sm">게시글삭제</button></p>
					</div>
                            
                            
             		<!-- comment view -->
                    <div class="comments-area">
                    <div class="inner-title"><h3 class="mb-0">Comments</h3></div>
                    
                        <div class="comment-box">
                            <div class="comment-info">
                                <h6><a href="#">댓글작성자</a></h6>
                                <p>댓글내용</p>
                                <div class="reply">
                                    <a href="#">
                                        <i class="fa fa-reply" aria-hidden="true"></i> Reply
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="comment-box">
                            <div class="comment-info">
                                <h6><a href="#">대댓글작성자</a></h6>
                                <p>내용</p>
                                <div class="reply">
                                    <a href="#">
                                        <i class="fa fa-reply" aria-hidden="true"></i> Reply
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end comment-->
                    
                    <!-- comment post -->
                    <div class="common-block">

                    <div class="inner-title">
                        <h4 class="mb-0">Post a Comment</h4>
                    </div>

                    <form>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label>Your Name</label>
                                    <input type="text" class="form-control" name="name" placeholder="이름을 작성해주세요">
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label>Your ID</label>
                                    <input type="email" class="form-control" name="email" placeholder="ID를 작성해주세요">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 mb-4">
                                <label>Message</label>
                                <div class="form-group mb-1">
                                    <textarea rows="2" class="form-control" placeholder="댓글 입력..."></textarea>
                                </div>
                            </div>
                        </div>

                        <button type="button" class="butn-style2">Send Message</button>
                    </form>
                	</div>

                    <!-- end form -->
                </div>
            </div>
            <!-- end blog left -->
        </div>
	</div>
</section>
</body>
</html>