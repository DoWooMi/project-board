<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head >
<meta charset="UTF-8">
<title>Blog main</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
<style type="text/css"> 
.calendar {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-right: 18px;
}
.calendar input {
	border: 1px solid #dcdcde;
	width: 220px;
	height: 40px;
	text-align: center;
	font-size: 18px;
	font-weight: 900;
	font-family: 'Kanit', sans-serif;
	padding-right: 15px;
}
</style>
</head>



<body class="wd-75 row d-flex justify-content-center" >
	
<form class="mb-5">
<div class="w-75 d-flex justify-content-center" style="margin: 0 auto;"> 	
 	<!-- 날짜 지정 (최소값 최대값 지정) -->
	<div class="calendar">
	  	<div>
			<input type="date" id="startdate" name="startdate" value="">&nbsp;&nbsp;&nbsp;&nbsp;─&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div>
			<input type="date" id="enddate" name="enddate" value="">
		</div>&nbsp;&nbsp;
		<button class="btn btn-primary py-2 px-4 rounded-pill shadow" type="submit" id="sub_btn" style="font-size: 1em;">검색</button>
  	</div>
 </div>
	   		
<div id="noticetable" class="w-100" style="margin: 0 auto; padding: 35px;"></div>
<div id="pageNumDiv"></div>
	</form>	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/	js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>







<script>
			
var page=1;
noticeListDisplay(page);
			
function noticeListDisplay(pageNum) {
    page = pageNum;
    const urlParams = new URLSearchParams(window.location.search);
    const startValue = urlParams.get('startdate');
    const endValue = urlParams.get('enddate');

    
    $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/blogList",
        data: {
            pageNum: pageNum,
            sDate: startValue,
            eDate: endValue
        },	
        dataType: "json",
        success: function(result) {
        	var html = "<section class='md'>";
                html = "<div class='container'>";
                html += "<div class='row'>";
        	$(result.boardList).each(function(){        		
                html += "<div class='col-md-6 col-lg-4 mb-1-9 blog-style-one'>";
                html += "<article class='item text-center'>";
                html +=	"<div class='post-img'>";
                html += "<img src='${pageContext.request.contextPath}/img/"+this.img+"' style='height: 300px; width: 400px;'>";
                html += "</div>";
                html += "<div class='content'>";
                html += "<h3 class='h5 mb-2'><a href='${pageContext.request.contextPath}/blog/view'>"+this.title+"</a></h3>";
                html += "<div class='tag alt-font'>";
                html += "<span class='d-inline-block text-primary'>"+this.cdate+"</span>";
                html += "</div>";
                html += "</div>";
                html += "</article>";
                html += "</div>";
            });
                html += "</div>";
                html += "</div>";
                html += "</section>";
        	
            $("#noticetable").html(html);
            pageNumDisplay(result.pager);
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
}

			
function pageNumDisplay(pager) {
	var html="";
	
	if(pager.startPage > pager.blockSize) {
		html+="<a href='javascript:noticeListDisplay("+pager.prevPage+")'>[이전]</a>";
	}
	for(i=pager.startPage;i<=pager.endPage;i++) {
		if(pager.pageNum!=i) {
			html+="<a href='javascript:noticeListDisplay("+i+")'>[ "+i+" ]</a>";
		} else {
			html+="[ "+i+" ] ";
		}
	}
	if(pager.endPage != pager.totalPage) {
		html+="<a href='javascript:noticeListDisplay("+pager.nextPage+")'>[다음]</a>";
	}
	$("#pageNumDiv").html(html);
}


</script>

</html>