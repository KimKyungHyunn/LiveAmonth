<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">

    <title>Finally Ask Drop</title>
</head>
<body>
<section class="contact-form-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="cf-content">
                    <div class="cc-title">
                        <h4>ȸ��Ż��Ȯ��</h4>
                        <p>Ȯ���� ���� �� ȸ��Ż�� ����˴ϴ�.</p>
                    </div>
                    <div>
                        <form action="resultMentDropUser" method=post class="cc-form" id="resultMentDropUser">
                            <button type="submit" class="site-btn">Ȯ��</button>

                            <input type="button" class="site-btn" value="���" onclick="cancelDropUser();">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Contact Form Section End -->
<script>
    function cancelDropUser() {

        $("#resultMentDropUser").attr("action", "/").submit();
    }
</script>
</body>
</html>