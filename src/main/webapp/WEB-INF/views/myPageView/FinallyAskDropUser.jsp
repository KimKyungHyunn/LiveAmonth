<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
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
                            <button type="button" class="site-btn" onclick=acyncMovePage("reCheckForModifyUserInfo");>���</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function cancelDropUser() {
        $("#resultMentDropUser").attr("action", "/").submit();
    }
</script>
</body>