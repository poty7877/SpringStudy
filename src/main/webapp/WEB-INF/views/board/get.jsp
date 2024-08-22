<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>

<!-- list.jsp에서 /board/register 경로를 호출하면 get 메서드가 실행되며 폼박스가 나옴 -->
<!-- 입력완료를 누르면 vo객체가 만들어져서 /board/register의 post 메서드가 실행-->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판 글 확인 페이지</h1>
	</div>
	<!-- .col-lg-12 end -->
</div>
<!-- .row end -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-warning">
			<div class="panel-heading">Board Get</div>
			<!-- .panel-heading end -->
			<div class="panel-body">
				<!-- form 박스 만들고 submit 처리 -->
				<!-- 				<form role="form" action="/board/register" method="post"> -->
				<div class="form-group">
					<label>Number</label> <input class="form-control" name="Number"
						value='<c:out value="${ board.bno }" />' readonly />
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						value='<c:out value="${ board.title }"/>' readonly />
				</div>
				<!-- Title.form-group end -->
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="3" name="content" readonly><c:out
							value="${ board.content }" /></textarea>
				</div>
				<!-- Content.form-group end -->
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						value='<c:out value="${ board.writer }"/>' readonly />
				</div>
				<!-- Writer.form-group end -->
				<div class="form-group">
					<label>RegDate</label> <input class="form-control" name="regdate"
						value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${ board.regdate }"/>' readonly />
				</div>
				<!-- Writer.form-group end -->
				<div class="form-group">
					<label>UpdateDate</label> <input class="form-control"
						name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${ board.updateDate }"/>'
						readonly />
				</div>
				<!-- Writer.form-group end -->
				<button data-oper='modify' class="btn btn-primary">수정하기</button>
					<!-- onclick="location.href='/board/modify?bno=<c:out value="${ board.bno }" />'"> -->
				<!-- <button data-oper='delete' class="btn btn-danger">삭제하기</button> -->
				<button data-oper='list' class="btn btn-info">
					<!-- onclick="location.href='/board/list'"> -->
					목록보기
				</button>

				<!-- 수정버튼 클릭시 bno를 가지고 감 -->
				<form id="operForm" action="/board/modify" method="get">
				<input type="hidden" id="bno" name="bno" value="${ board.bno }"/>
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
		var operForm = $("#operForm"); //
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		$("button[data-oper='list']").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
		
	});

</script>
<%@ include file="../includes/footer.jsp"%>