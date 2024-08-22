<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>

<!-- get.jsp에서 /board/modify 경로를 호출하면 get 메서드가 실행되며 폼박스가 나옴 -->
<!-- 입력완료를 누르면 vo객체가 만들어져서 /board/modify의 post 메서드가 실행-->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판 글 수정 페이지</h1>
	</div>
	<!-- .col-lg-12 end -->
</div>
<!-- .row end -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-warning">
			<div class="panel-heading">Board Modify</div>
			<!-- .panel-heading end -->
			<div class="panel-body">
				<!-- form 박스 만들고 submit 처리 -->
				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>Number</label> <input class="form-control" name="bno"
							value="${ board.bno }" readonly />
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value="${ board.title }" required />
					</div>
					<!-- Title.form-group end -->
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="3" name="content" required><c:out
								value="${ board.content }" /></textarea>
					</div>
					<!-- Content.form-group end -->
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${ board.writer }"/>' readonly />
					</div>
					<!-- Writer.form-group end -->
					<div class="form-group">
						<label>RegDate</label> <input class="form-control" 
							value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${ board.regdate }"/>'
							readonly />
					</div>
					<!-- Writer.form-group end -->
					<div class="form-group">
						<label>UpdateDate</label> <input class="form-control"
							value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${ board.updateDate }"/>'
							readonly />
					</div>
					<!-- Writer.form-group end -->
					<button type="submit" data-oper='modify' class="btn btn-primary">수정하기</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">삭제하기</button>
					<button type="submit" data-oper='list' class="btn btn-info">목록보기</button>
					<!-- submit이 많은 경우에는 js를 이용해서 분기처리를 해야함 -->
				</form>
				<!-- form end -->
			</div>
			<!-- .panel-body end -->
		</div>
		<!-- .panel panel-dafault.end -->
	</div>
	<!-- .col-lg-12 end -->
</div>
<!-- .row end -->
<script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form"); // 상단 코드중에 form태그를 formObj로 관여 하겠다 
	$('button').on("click", function(e){
		
		e.preventDefault(); // button 기본 사용을 안함. submit 안함
		var operation =$(this).data("oper"); // data-oper='modify','remove','list'
		
		console.log(operation); /* 개발자도구 콘솔에 찍힘 */
		if(operation === 'remove') { /* data-oper='remove' */
			formObj.attr("action","/board/remove"); // 삭제 컨트롤
		}else if(operation === 'list') {
			self.location="/board/list";
			return;
		}
		formObj.submit(); // data-oper='modify'
		
	});
});














</script>


<%@ include file="../includes/footer.jsp"%>