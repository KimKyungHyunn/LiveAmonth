<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
   $(function(){
      $("#loginBtn").click(function(){
         location.href='signIn';
      })
   })
</script>
<title>비밀번호 찾기</title>
<jsp:include page="/incl/Header.jsp" />
</head>
<body>
<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">비밀번호 찾기 검색결과</h2>
				</div>
				</div>
				
			<form action="/resultMentFindPW" method="post">
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
				
			      	<div class="d-flex">
			      		<div class="w-100">
					<h3 class="mb-4">${ userPassword }</h3>
					  		</div>
			      	</div>
			      	
			      						
			      		<div class="form-group mt-3">			      		    
			      		</div>
			      	<div class="form-group">

		            	<button type="button" onclick="history.go(-1);" class="form-control btn btn-primary rounded submit px-3">Cancel</button>
		            </div>
		            
				</div>
				<div>

					
				</div>
			</form>
		</div>
		
	</section>
----
   
</body>
<jsp:include page="/incl/Footer.jsp" />
</html>