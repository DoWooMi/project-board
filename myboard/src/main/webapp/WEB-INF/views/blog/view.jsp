<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head >
<style type="text/css">
.replybutton{
	background-color: white;
	color: blue; 
	font-weight: 600;
}
</style>
<meta charset="UTF-8">
<title>Blog view</title>
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                                     <li>작성일자 : <span>${boardview.cdate.substring(0,10)}</span></li>
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
					<span><button onclick="location.href='${pageContext.request.contextPath }/blog';" type="button" class="btn btn-primary btn-sm">게시글목록</button></span>
					<c:if test="${loginHewon.id.equals(boardview.bhid) }">
						<span><button onclick="location.href='${pageContext.request.contextPath }/modify?bidx=${boardview.bidx }';" type="button" class="btn btn-primary btn-sm" >게시글변경</button>
						<button onclick="location.href='${pageContext.request.contextPath }/delete?bidx=${boardview.bidx}';" type="button" class="btn btn-primary btn-sm">게시글삭제</button></span>
					</c:if>
					</div>
					<br>
                            
             		<!-- comment view -->
                    <div class="comments-area">
                    <div class="inner-title"><h3 class="mb-0">Comments</h3></div>
                    
                        <c:forEach var="reply" items="${replylist }">
                        <div class="comment-box" style="margin-left: ${reply.relevel > 0 ? '80px' : '0'}">
                            <div class="comment-info">
                            	<div class="meta ps-0 d-flex justify-content-between" style="font-weight: 600">
                                     <p>🐣 작성자 : <span>${reply.rhid}</span></p>
                                     <p>작성일자 : <span>${reply.rdate.substring(0,10)}</span></p>
                                 </div>
                            	<div class="meta ps-0 d-flex justify-content-between">
	                                <p>${reply.comments}</p>
	                                <c:if test="${loginHewon.id.equals(reply.rhid) }">
                                     <button onclick="location.href='${pageContext.request.contextPath }/deletereply?ridx=${reply.ridx}&rbidx=${reply.rbidx }';" type="button" class="replybutton">삭제</button>
                                 	</c:if>
                                 </div>
                                 
                                <div class="reply">
                                	<c:if test="${reply.relevel==0 }">
                                    <button type="button" class="replybutton" onclick="rereply('${reply.ridx}');" id="rebtn"> ↳ Reply </button>
                                    </c:if>
                                    <div id="replyDiv-${reply.ridx }" style="display: none;">
                                    <form name="reply-${reply.ridx }" method="post">
				                        <div class="row">
				                            <div class="col-12 mb-4">
				                                <div class="">
				                                    <textarea rows="1" name="comments" id="comments-${reply.ridx }" class="form-control" placeholder="댓글 입력..."></textarea>
				                                    <input type="hidden" class="form-control" name="rhid" value="${loginHewon.id }">
				                                    <input type="hidden" class="form-control" name="rbidx" value="${boardview.bidx}">
				                                    <input type="hidden" class="form-control" name="regroup" value="${reply.regroup}">
				                                </div>
				                            </div>
				                        </div>
				                        <button type="button" class="butn-style2" onclick="rereplyAdd('${reply.ridx}');">등록</button>
				                    </form>
				                    </div>
				                    
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <!-- end comment-->
                    
                    <!-- comment post -->
                    <c:if test="${not empty loginHewon}">
                    <div class="common-block">
                    <div class="inner-title">
                        <h4 class="mb-0">Post a Comment</h4>
                    </div>

                    <form name="f" method="post">
                        <div class="row">
                            <div class="col-12 mb-4">
                                <label>Message</label>
                                <div class="form-group mb-1">
                                    <textarea rows="2" name="comments" id="comments" class="form-control" placeholder="댓글 입력..."></textarea>
                                    <input type="hidden" class="form-control" name="rhid" value="${loginHewon.id }">
                                    <input type="hidden" class="form-control" name="rbidx" value="${boardview.bidx}">
                                    <input type="hidden" class="form-control" name="regroup" value="0">
                                </div>
                            </div>
                        </div>

                        <button type="button" class="butn-style2" onclick="replyAdd();">Send Message</button>
                    </form>
                	</div>
					</c:if>
                    <!-- end form -->
                </div>
            </div>
            <!-- end blog left -->
        </div>
	</div>
</section>
</body>
<script type="text/javascript">
function replyAdd() { 
	if ( f.comments.value == "" ) {
		alert("내용을 입력해주세요.");
		f.comments.focus();
		return;
	}
	f.action = "<c:url value="/writecomment"/>"
	f.submit();
}

function rereplyAdd(ridx) { 
	var ref = document.forms['reply-'+ridx+''];
	var comment=document.getElementById("comments-"+ridx);
	if ( comment.value == "" ) {
		alert("내용을 입력해주세요.");
		comment.focus();
		return;
	}
	ref.action = "<c:url value="/writecomment"/>"
	ref.submit();
}

function rereply(replyRidx) {
	var rereplydiv = document.getElementById("replyDiv-"+replyRidx);
	
	if(rereplydiv.style.display === "none"){
	rereplydiv.style.display = "block";
	} else {
		rereplydiv.style.display = "none";
	}
}
</script>
</html>