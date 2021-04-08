<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    
    <title>�Ѵ� ���</title>
</head>

<body>
 	<jsp:include page="/incl/Header.jsp" />
 	

	<!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="container">
            <div class="hs-slider owl-carousel">
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-1.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Seoul</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Seoul</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-bed"></i> 05</li>
                                        <li><i class="fa fa-automobile"></i> 01</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-2.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Jeju</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Jeju</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-bed"></i> 05</li>
                                        <li><i class="fa fa-automobile"></i> 01</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hs-item set-bg" data-setbg="resources/img/hero/hero-3.jpg">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="hc-inner-text">
                                <div class="hc-text">
                                    <h4>Gangneung</h4>
                                    <p><span class="icon_pin_alt"></span> Korea, Gangneung</p>
                                </div>
                                <div class="hc-widget">
                                    <ul>
                                        <li><i class="fa fa-object-group"></i> 2, 283</li>
                                        <li><i class="fa fa-bathtub"></i> 03</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Property Section Begin -->
    <section class="property-section latest-property-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="section-title">
                        <h4>������</h4>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="property-controls">
                        <ul>
                            <li data-filter="all">All</li>
                            <li data-filter=".seoul">����</li>
                            <li data-filter=".gyeonggi">��⵵</li>
                            <li data-filter=".gangwon">������</li>
                            <li data-filter=".chungcheong">��û��</li>
                            <li data-filter=".jeolla">����</li>
                            <li data-filter=".gyeongsang">���</li>
                            <li data-filter=".jeju">���ֵ�</li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="row property-filter">
            
               <div class="col-lg-4 col-md-6 mix all seoul">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-1.jpg">
	                           <div class="label">����</div>
	                       </div>
					       <div class="info">
					         <h3>Seoul</h3>
					         <p>�����Դϴ�.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
              	<div class="col-lg-4 col-md-6 mix all gyeonggi">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-2.jpg">
	                           <div class="label">����</div>
	                       </div>
					       <div class="info">
					         <h3>Yangpyeong</h3>
					         <p>�����Դϴ�.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                <div class="col-lg-4 col-md-6 mix all gangwon">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-3.jpg">
	                           <div class="label">����</div>
	                       </div>
					       <div class="info">
					         <h3>Gangneung</h3>
					         <p>�����Դϴ�.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                 <div class="col-lg-4 col-md-6 mix all chungcheong">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-4.jpg">
	                           <div class="label">����</div>
	                       </div>
					       <div class="info">
					         <h3>Boryeong</h3>
					         <p>�����Դϴ�.</p>
					       </div>
				       </a>
			       </div>
                </div>
                
                <div class="col-lg-4 col-md-6 mix all jeju">
                    <div class="ih-item square effect13 left_to_right property-item">
	                   <a href="#">
	                       <div class="pi-pic set-bg" data-setbg="resources/img/property/property-5.jpg">
	                           <div class="label">����</div>
	                       </div>
					       <div class="info">
					         <h3>Jeju</h3>
					         <p>���ֵ� �Դϴ�.</p>
					       </div>
				       </a>
			       </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/incl/Footer.jsp" />

</body>

</html>