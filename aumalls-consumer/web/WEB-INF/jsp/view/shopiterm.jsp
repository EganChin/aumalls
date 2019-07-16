<%--@elvariable id="goodsPage" type="com.mall.common.utils.PageWrapper<com.mall.common.vo.goods.QueryGoodsVO>"--%>
<%--@elvariable id="goods" type="com.mall.common.vo.goods.QueryGoodsVO"--%>
<%--@elvariable id="typeList" type="java.util.List<com.mall.common.vo.goods.GoodsTypeVO>"--%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表-澳猫团</title>
    <link rel="stylesheet" href="../../resources/css/dialog.css">
    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link rel="stylesheet" href="../../resources/css/reset.css">
    <link rel="stylesheet" href="../../resources/css/base.css">
    <link rel="stylesheet" href="../../resources/css/list.css">
    <base target="_blank">

    <script src="../../resources/js/framework/AWLCore.js"></script>
    <script src="../../resources/js/framework/AWLConst.js"></script>
    <script src="../../resources/js/framework/AWLHttp.js"></script>
</head>
<body>
<jsp:include page="login.jsp"/>
<header class="wrap-all">
    <c:set var="APP_PATH" value="${pageContext.request.contextPath}" />
    <div class="head center_1200">
        <!-- 头部左边 -->
        <div class="headLeft">
            <div class="hello">
                <a href="#">
                    <em></em>
                    <span>澳猫首页</span>
                    <span id="welcome">嗨，澳猫欢迎你！</span>
                </a>
            </div>
            <div class="user" id="user-group">
                <a target="_self" id="login">登录</a>
                <span>|</span>
                <a target="_self" id="register">注册</a>
            </div>
            <div class="phone">
                <a href="#">
                    <em></em>
                    <span>手机逛澳猫</span>
                </a>
            </div>
        </div>
        <!-- 头部右边 -->
        <!-- 头部右边 -->
        <div class="headRight">
            <ul>
                <li><a href="#">我的订单</a></li>
                <span>|</span>
                <li class="erWrap">
                    <strong></strong>
                    <a href="#">个人中心</a>
                    <em></em>
                    <p class="headEr">
                        <a href="#">我的优惠券</a>
                        <a href="#">账户安全</a>
                        <a class="last" href="#">售后管理</a>
                    </p>
                </li>
                <span>|</span>
                <li class="erWrap">
                    <a href="#">客户服务</a>
                    <em></em>
                    <p class="headEr">
                        <a href="#">联系客服</a>
                        <a href="#">购物指南</a>
                        <a href="#">下单与配送</a>
                        <a href="#">售后服务</a>
                        <a href="#">商家服务</a>
                        <a class="last" href="#">帮助中心</a>
                    </p>
                </li>
                <span>|</span>
                <li class="erWrap">
                    <a href="#">消费者告知书</a>
                </li>
                <span>|</span>
                <li class="erWrap">
                    <a href="#">收藏夹</a>
                    <em></em>
                    <p class="headEr different">
                        <a href="#">收藏的宝贝</a>
                        <a class="last" href="#">收藏的品牌</a>
                    </p>
                </li>
                <span>|</span>
                <li class="erWrap">
                    <a href="#">帮助中心</a>
                    <em></em>
                    <p class="headEr">
                        <a href="#">海外正品</a>
                        <a href="#">服务保障</a>
                        <a href="#">关税&清关</a>
                        <a class="last" href="#">身份证报关</a>
                    </p>
                </li>
                <span>|</span>
                <li class="er_warp">
                    <a href="#">网站导航</a>
                    <em></em>
                    <div class="headEr clearfix">
                        <div class="er_area">
                            <h5>营养保健</h5>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=维生素&crossStore=true">维生素</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=矿物质&crossStore=true">矿物质</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=鱼油&crossStore=true">鱼油</a>
                            <a href="#">降糖</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=维生素&crossStore=true">维生素</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=矿物质&crossStore=true">矿物质</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=鱼油&crossStore=true">鱼油</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=蜂胶&crossStore=true">蜂胶</a>
                            <a href="#">蜂蜜</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=前列腺&crossStore=true">前列腺</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=强精&crossStore=true">强精</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=补肾&crossStore=true">补肾</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=护肝&crossStore=true">护肝</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=护眼&crossStore=true">护眼</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=职场&crossStore=true">其他</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=维骨力&crossStore=true">维骨力</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=高钙奶粉&crossStore=true">高钙奶粉</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=养心&crossStore=true">养心</a>
                        </div>
                        <div class="er_area">
                            <h5>母婴特卖</h5>
                            <a href="#">奶粉</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=孕前备孕&crossStore=true">孕前备孕</a>
                            <a href="#">辅食</a>
                            <a href="#">驱蚊</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=孕期营养&crossStore=true">孕期营养</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=孕前备孕&crossStore=true">孕前备孕</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=哺乳期&crossStore=true">哺乳期</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=营养品&crossStore=true">营养品</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=抗感冒/止咳&crossStore=true">抗感冒/止咳</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=辅食代餐&crossStore=true">辅食代餐</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=零食&crossStore=true">零食</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=奶粉1段&crossStore=true">1段
                                0-6个月</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=奶粉2段&crossStore=true">2段
                                6-12个月</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=奶粉3段&crossStore=true">3段
                                1-3岁</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=奶粉4段&crossStore=true">4段 3-6岁</a>
                            <a target="_blank" href="#">洗漱</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=奶粉2段&crossStore=true">2段
                                6-12个月</a>
                            <a target="_blank" href="#">护肤</a>
                            <a target="_blank" class="last" href="#">驱蚊</a>
                        </div>
                        <div class="er_area">
                            <h5>魅力女性</h5>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=补气养血&crossStore=true">补气养血</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=排毒养颜&crossStore=true">排毒养颜</a>
                            <a href="#">洗液</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=排毒养颜&crossStore=true">排毒养颜</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=完美身材&crossStore=true">完美身材</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=胶原蛋白&crossStore=true">胶原蛋白</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=补气养血&crossStore=true">补气养血</a>
                            <a target="_blank" href="#">卫生巾</a>
                            <a target="_blank" class="last" href="#">洗液</a>
                        </div>
                        <div class="er_area">
                            <h5>美妆个护</h5>
                            <a href="#">面部</a>
                            <a href="#">防嗮</a>
                            <a href="#">祛斑祛痘</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=面部洗护&crossStore=true">面部洗护</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=眼部护理&crossStore=true">眼部护理</a>
                            <a target="_blank"
                               href="http://www.aumalls.com/Store/Search/?q=唇部护理&crossStore=true">唇部护理</a>
                            <a target="_blank" class="last" href="#">祛斑祛痘</a>
                            <a target="_blank" href="#">手足洗护</a>
                            <a target="_blank" class="cAEE"
                               href="http://www.aumalls.com/Store/Search/?q=眼部护理/&crossStore=true">眼部护理</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=防晒修复&crossStore=true">防晒修复</a>
                        </div>
                        <div class="er_area">
                            <h5>个人洗护</h5>
                            <a href="#">沐浴</a>
                            <a href="#">洗发</a>
                            <a href="#">消毒液</a>
                            <a href="#">洗洁精</a>
                            <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=消毒液&crossStore=true">消毒液</a>
                            <a target="_blank" class="last"
                               href="http://www.aumalls.com/Store/Search/?q=洗洁精&crossStore=true">洗洁精</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</header>
<!-- 搜索和logo -->
<div class="logoAndSearch w1190 textWarp">
    <!-- logo -->
    <div class="logo">
        <a href="index.jsp">澳猫网</a>
    </div>
    <!-- 搜索 -->
    <div class="search">
        <div class="txt">
            <input class="SearchBttonValue" type="text" placeholder="Swisse/澳洲">
        </div>
        <a class="SearchBtton btn" href="#">
            搜索
        </a>
        <div class="hot_search">
            <em>热门搜索：</em>
            <span><a target="_blank" href="#">胶原蛋白</a></span>
            <span><a target="_blank" href="#">叶绿素</a></span>
            <span><a target="_blank" href="#">睡眠片</a></span>
            <span><a target="_blank" href="#">儿童维生素</a></span>
            <span><a target="_blank" href="#">鱼肝油</a></span>
            <span><a target="_blank" href="#">保健品</a></span>
            <span><a target="_blank" href="#">美容</a></span>
            <span><a target="_blank" href="#">运动保健</a></span>
        </div>
    </div>
    <!--购物车-->
    <a href="#" class="buy_car">
        <p>购物车</p>
        <em>0</em>
    </a>
    <!-- 新会员 -->
    <div class="app">
        <a href="#"></a>
        <div class="SAEr">
            <p>扫描下载澳猫APP</p>
            <img src="images/AppEr.png" alt="二维码">
        </div>
    </div>
</div>
<!-- 导航 -->
<div class="wrap-all">
    <div class="center_1200 nav_list_wrap">
        <!--左边二级菜单-->
        <div class="main_menu">
            <a href="javascript:;">全部商品分类</a>
            <div class="more_height"></div>
            <ul class="one_nav">
                <li>
                    <dl>
                        <dt>
                        <h4>营养保健</h4></dt>
                        <dd>
                            <span><a target="_blank" href="http://www.aumalls.com/Store/Search/?q=维生素&crossStore=true">维生素</a></span>
                            <span><a target="_blank" href="http://www.aumalls.com/Store/Search/?q=矿物质&crossStore=true">矿物质</a></span>
                            <span><a target="_blank"
                                     href="http://www.aumalls.com/Store/Search/?q=鱼油&crossStore=true">鱼油</a></span>
                            <span><a href="#">降糖</a></span>
                        </dd>
                    </dl>
                    <ul class="two_nav">
                        <li>
                            <dl>
                                <dt>
                                <h4>营养补充</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=维生素&crossStore=true">维生素</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=矿物质&crossStore=true">矿物质</a><i>|</i>
                                    <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=鱼油&crossStore=true">鱼油</a><i>|</i>
                                    <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=蜂胶&crossStore=true">蜂胶</a><i>|</i>
                                    <a href="#">蜂蜜</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>男士保健</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=前列腺&crossStore=true">前列腺</a><i>|</i>
                                    <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=强精&crossStore=true">强精</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=补肾&crossStore=true">补肾</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>职场白领</h4></dt>
                                <dd>
                                    <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=护肝&crossStore=true">护肝</a><i>|</i>
                                    <a target="_blank" href="http://www.aumalls.com/Store/Search/?q=护眼&crossStore=true">护眼</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=职场&crossStore=true">其他</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>滋补养生</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=维骨力&crossStore=true">维骨力</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=高钙奶粉&crossStore=true">高钙奶粉</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=养心&crossStore=true">养心</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </li>
                <li>
                    <dl>
                        <dt>
                        <h4>母婴特卖</h4></dt>
                        <dd>
                            <span><a href="#">奶粉</a></span>
                            <span><a target="_blank" href="http://www.aumalls.com/Store/Search/?q=孕前备孕&crossStore=true">孕前备孕</a></span>
                            <span><a href="#">辅食</a></span>
                            <span><a href="#">驱蚊</a></span>
                        </dd>
                    </dl>
                    <ul class="two_nav">
                        <li>
                            <dl>
                                <dt>
                                <h4>孕妈专用</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=孕期营养&crossStore=true">孕期营养</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=孕前备孕&crossStore=true">孕前备孕</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=哺乳期&crossStore=true">哺乳期</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>辅食营养</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=营养品&crossStore=true">营养品</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=抗感冒/止咳&crossStore=true">抗感冒/止咳</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=辅食代餐&crossStore=true">辅食代餐</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=零食&crossStore=true">零食</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>奶粉</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=奶粉1段&crossStore=true">1段
                                        0-6个月</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=奶粉2段&crossStore=true">2段
                                        6-12个月</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=奶粉3段&crossStore=true">3段 1-3岁</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=奶粉4段&crossStore=true">4段 3-6岁</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>宝宝用品</h4></dt>
                                <dd>
                                    <a target="_blank" href="#">洗漱</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=奶粉2段&crossStore=true">2段
                                        6-12个月</a><i>|</i>
                                    <a target="_blank" href="#">护肤</a><i>|</i>
                                    <a target="_blank" class="last" href="#">驱蚊</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </li>
                <li>
                    <dl>
                        <dt>
                        <h4>魅力女性</h4></dt>
                        <dd>
                            <span><a target="_blank" class="last"
                                     href="http://www.aumalls.com/Store/Search/?q=补气养血&crossStore=true">补气养血</a></span>
                            <span><a target="_blank" href="http://www.aumalls.com/Store/Search/?q=排毒养颜&crossStore=true">排毒养颜</a></span>
                            <span><a href="#">洗液</a></span>
                        </dd>
                    </dl>
                    <ul class="two_nav">
                        <li>
                            <dl>
                                <dt>
                                <h4>美容养颜</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=排毒养颜&crossStore=true">排毒养颜</a>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=完美身材&crossStore=true">完美身材</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=胶原蛋白&crossStore=true">胶原蛋白</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=补气养血&crossStore=true">补气养血</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>女性护理</h4></dt>
                                <dd>
                                    <a target="_blank" href="#">卫生巾</a><i>|</i>
                                    <a target="_blank" class="last" href="#">洗液</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </li>
                <li>
                    <dl>
                        <dt>
                        <h4>美妆个护</h4></dt>
                        <dd>
                            <span><a href="#">面部</a></span>
                            <span><a href="#">防嗮</a></span>
                            <span><a href="#">祛斑祛痘</a></span>
                        </dd>
                    </dl>
                    <ul class="two_nav">
                        <li>
                            <dl>
                                <dt>
                                <h4>护肤</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=面部洗护&crossStore=true">面部洗护</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=眼部护理&crossStore=true">眼部护理</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=唇部护理&crossStore=true">唇部护理</a><i>|</i>
                                    <a target="_blank" class="last" href="#">祛斑祛痘</a><i>|</i>
                                    <a target="_blank" href="#">手足洗护</a><i>|</i>
                                    <a target="_blank" class="cAEE"
                                       href="http://www.aumalls.com/Store/Search/?q=眼部护理/&crossStore=true">眼部护理</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=防晒修复&crossStore=true">防晒修复</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>个人洗护</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=沐浴护肤&crossStore=true">沐浴护肤</a><i>|</i>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=洗发护发&crossStore=true">洗发护发</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=口腔护理&crossStore=true">口腔护理</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <dl>
                                <dt>
                                <h4>健康生活</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=消毒液&crossStore=true">消毒液</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=洗洁精&crossStore=true">洗洁精</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </li>
                <li>
                    <dl>
                        <dt>
                        <h4>个人洗护</h4></dt>
                        <dd>
                            <span><a href="#">沐浴</a></span>
                            <span><a href="#">洗发</a></span>
                            <span><a href="#">消毒液</a></span>
                            <span><a href="#">洗洁精</a></span>
                        </dd>
                    </dl>
                    <ul class="two_nav">
                        <li>
                            <dl>
                                <dt>
                                <h4>健康生活</h4></dt>
                                <dd>
                                    <a target="_blank"
                                       href="http://www.aumalls.com/Store/Search/?q=消毒液&crossStore=true">消毒液</a><i>|</i>
                                    <a target="_blank" class="last"
                                       href="http://www.aumalls.com/Store/Search/?q=洗洁精&crossStore=true">洗洁精</a><i>|</i>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </li>
                <!--暂空不绑定-->
                <li>
                </li>
            </ul>
        </div>
        <div class="nav_list_parent">
            <div class="nav_list_bg"></div>
            <ul class="nav_list clearfix">
                <!-- 右边导航菜单-->
                <li>
                    <a href="#">首 页</a>
                </li>
                <li>
                    <a target="_blank" href="#">特价团购</a>
                    <em class="hot_sell"></em>
                </li>
                <li>
                    <a target="_blank" href="#">营养保健</a>
                </li>
                <li>
                    <a target="_blank" href="#">母婴特卖</a>
                </li>
                <li>
                    <a target="_blank" href="#">魅力女性</a>
                </li>
                <li>
                    <a target="_blank" href="#">美妆个护</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="mainArea">
    <!-- 位置导航 -->
    <div class="subnav w1190">
        <ul class="SNLeft">
            <li><a href="#">澳猫团</a></li>
            <li>></li>
            <li><a href="#">美妆个护</a></li>
        </ul>
    </div>
    <!-- 主要内容 -->
    <div class="content w1190 clearfix">
        <!-- 侧边 -->
        <div class="sidebar">
            <!-- 全部分类 -->
            <div class="classify">
                <h3>美妆个护</h3>
                <div class="ClaCont" id="type-list">
                    <dl>
                        <c:forEach var="type" items="${typeList}">
                            <dt><a href="#">${type.typeName}</a></dt>
                            <dd class="cli">
                                <em></em>
                                <ul>
                                    <c:forEach var="child" items="${type.children}">
                                        <li><a>·&nbsp;&nbsp;${child.typeName}</a></li>
                                    </c:forEach>
                                </ul>
                            </dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
            <!-- 热卖排行榜 -->
            <div class="hotSale">
                <h3>热卖排行榜</h3>
                <div class="HRproduct">
                    <ul>
                        <li>
                            <div class="HRpic">
                                <a href="#">
                                    <img class="lazy" src="js/lazyload/grey.gif" data-original="images/lproduct7.png"
                                         alt="">
                                </a>
                            </div>
                            <div class="HRtxt">
                                <p><a href="#">Sukin苏芊 玫瑰果补湿日霜 120毫升</a></p>
                                <p class="clearfix">
                                    <strong class="c065">￥89</strong>
                                    <s>￥399</s>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="HRpic">
                                <a href="#">
                                    <img class="lazy" src="js/lazyload/grey.gif" data-original="images/lproduct7.png"
                                         alt="">
                                </a>
                            </div>
                            <div class="HRtxt">
                                <p><a href="#">Sukin苏芊 玫瑰果补湿日霜 120毫升</a></p>
                                <p class="clearfix">
                                    <strong class="c065">￥89</strong>
                                    <s>￥399</s>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="HRpic">
                                <a href="#">
                                    <img class="lazy" src="js/lazyload/grey.gif" data-original="images/lproduct7.png"
                                         alt="">
                                </a>
                            </div>
                            <div class="HRtxt">
                                <p><a href="#">Sukin苏芊 玫瑰果补湿日霜 120毫升</a></p>
                                <p class="clearfix">
                                    <strong class="c065">￥89</strong>
                                    <s>￥399</s>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="HRpic">
                                <a href="#">
                                    <img class="lazy" src="js/lazyload/grey.gif" data-original="images/lproduct7.png"
                                         alt="">
                                </a>
                            </div>
                            <div class="HRtxt">
                                <p><a href="#">Sukin苏芊 玫瑰果补湿日霜 120毫升</a></p>
                                <p class="clearfix">
                                    <strong class="c065">￥89</strong>
                                    <s>￥399</s>
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 主要内容 -->
        <div class="mianContent">

            <!-- 商品内容 -->
            <div class="product">
                <ul class="" id="product-table">
                    <c:forEach var="iterm" items="${data}">

                        <li data_obj="${iterm.goodsTotalPrice}">
                            <div class="proImg">
                                <a href="#">
                                    <img class="lazy" src="resources/js/lazyload/grey.gif" height='165' width='183'
                                         data-original="images/${iterm.goodsImgPath}"
                                         alt="">
                                </a>
                            </div>
                            <div class="proTxt">
                                <p><a href="#">${iterm.goodsName}</a></p>
                                <p>
                                    数量：<span id="num-jian" class="num-jian" data_obj="${iterm.itermId}">-</span>
                                        <input type="text" class="input-num" size="5" value="${iterm.goodsNum}"/>
                                        <span id="num-jia" class="num-jia" data_obj="${iterm.itermId}">+</span>
                                </p>
                                <p>
                                    <strong data_obj="${iterm.goodsPrice}">小计：<b>${iterm.goodsTotalPrice}</b>￥</strong>
                                </p>
                                <p>
                                    <input type="hidden" value="${iterm.itermId}">
                                    <strong><a class="deleteiterm" size="10">移除购物车</a></strong>
                                </p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

            </div>

            <div>
                <p>
                    <c:set var="total" value="0"></c:set>
                    <c:forEach var="iterm" items="${data}">
                        <c:set var="total" value="${total + iterm.goodsTotalPrice}"></c:set>
                    </c:forEach>>

                    <c:if test="${total > 0}">
                        总价：<b id="total">${total}</b> , <a href="http://127.0.0.1/shopcart/flushCart?userid=${param.userid}">清空购物车</a>
                    </c:if>

                </p>
            </div>

        </div>





    </div>
</div>
<!-- 底部 -->
<div class="foot">
    <!-- 保证 -->
    <div class="BZ center_1200 textWarp">
        <ul class="footer_bg clearfix">
            <a target="_blank" class="first" href="http://www.aumalls.com/oversea">
                <div class="icon"></div>
                <p>100% 正品保障</p>
            </a>
            <a target="_blank" class="two" href="http://www.aumalls.com/oversea">
                <div class="icon"></div>
                <p>100% 海外进口</p>
            </a>
            <a target="_blank" class="three" href="http://www.aumalls.com/Logistics">
                <div class="icon"></div>
                <p>100% 极速发货</p>
            </a>
            <a target="_blank" class="four" href="http://www.aumalls.com/afterRules">
                <div class="icon"></div>
                <p>100% 无忧售后</p>
            </a>
        </ul>
    </div>
    <!-- 信息 -->
    <div class="information center_1200 textWarp">
        <div class="IRight">
				<span class="Iphone">
					<em></em>
					<strong>澳猫客服热线：</strong>
				</span>
            <span class="num c065">400-115-8086</span>
            <span class="time c065">工作时间：09:00-24:00(周一至周日)</span>
            <span class="email">澳猫邮箱：customer@aumalls.net</span>
        </div>
        <div class="ICenter">
            <div class="ICenW">
                <dl>
                    <dt><a target="_blank" href="#">购物指南</a></dt>
                    <dd><a target="_blank" href="#">· 购物流程</a></dd>
                    <dd><a target="_blank" href="#">· 购物须知</a></dd>
                    <dd><a target="_blank" href="#">· 免费注册</a></dd>
                    <dd><a target="_blank" href="#">· 品牌大全</a></dd>
                    <dd><a target="_blank" href="#">· 常见问题</a></dd>
                </dl>
                <dl>
                    <dt><a target="_blank" href="#">帮助中心</a></dt>
                    <dd><a target="_blank" href="#">· 帮助中心</a></dd>
                    <dd><a target="_blank" href="#">· 海外正品</a></dd>
                    <dd><a target="_blank" href="#">· 服务保障</a></dd>
                    <dd><a target="_blank" href="#">· 关税&清关</a></dd>
                    <dd><a target="_blank" href="#">· 身份证报关</a></dd>
                </dl>
                <dl>
                    <dt><a target="_blank" href="">下单与配送</a></dt>
                    <dd><a target="_blank" href="#">· 关于价格</a></dd>
                    <dd><a target="_blank" href="#">· 关于支付</a></dd>
                    <dd><a target="_blank" href="#">· 关于物流</a></dd>
                    <dd><a target="_blank" href="#">· 关于优惠券</a></dd>
                    <dd><a target="_blank" href="#">· 物流跟踪</a></dd>
                </dl>
                <dl>
                    <dt><a target="_blank" href="#">售后服务</a></dt>
                    <dd><a target="_blank" href="#">· 售后规则</a></dd>
                    <dd><a target="_blank" href="#">· 退货政策</a></dd>
                    <dd><a target="_blank" href="#">· 退货流程</a></dd>
                    <dd><a target="_blank" href="#">· 退款说明</a></dd>
                    <dd><a target="_blank" href="#">· 联系客服</a></dd>
                </dl>
                <dl class="MRn">
                    <dt><a target="_blank" href="#">商家服务</a></dt>
                    <dd><a target="_blank" href="#">· 平台规则</a></dd>
                    <dd><a target="_blank" href="#">· 国际招商</a></dd>
                    <dd><a target="_blank" href="#">· 商家入驻</a></dd>
                    <dd><a target="_blank" href="#">· 商家中心</a></dd>
                    <dd><a target="_blank" href="#">· 联系我们</a></dd>
                </dl>
            </div>
        </div>
        <div class="Ileft">
            <div class="er">
                <div class="erPic">
                    <img src="images/WXe.png" alt="二维码">
                </div>
                <span>扫码下载澳猫APP</span>
            </div>
            <div class="fen">
                <a class="weixin" href="#">
                    <em></em>
                    <span>aumalls</span>
                    <div class="WXer">
                        <p>新鲜好玩的<br>
                            澳洲货推荐<br>
                            <strong>扫码加微信</strong>
                        </p>
                        <div class="wxe">
                            <img src="images/WXe.png" alt="二维码">
                        </div>
                    </div>
                </a>
                <a class="sina" href="#">
                    <em></em>
                    <span>澳猫新浪微博</span>
                </a>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="up">
        <div class="txt textWarp  w1190">
            <!-- <ul>
                <li><a target="_blank" href="#">关于澳猫海淘</a></li>
                <li><a target="_blank" href="#">商家入驻</a></li>
                <li><a target="_blank" href="#">网站合作</a></li>
                <li><a target="_blank" href="#">友情链接</a></li>
                <li><a target="_blank" href="#">澳猫公益</a></li>
                <li><a target="_blank" href="#">法律声明</a></li>
                <li><a target="_blank" href="#">诚聘英才</a></li>
                <li><a target="_blank" href="#">联系我们</a></li>
                <li><a target="_blank" href="#">网站地图</a></li>
            </ul>
            <ul class="twoArea">
                <li><a target="_blank" href="#">澳猫云商</a></li>
                <li><a target="_blank" href="#">澳洲澳猫</a></li><span>|</span>
                <li><a target="_blank" href="#">康多多</a></li><span>|</span>
                <li><a target="_blank" href="#">PPTV</a></li><span>|</span>
                <li><a target="_blank" href="#">红孩子</a></li><span>|</span>
                <li><a target="_blank" href="#">缤购</a></li><span>|</span>
                <li><a target="_blank" href="#">乐购仕</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫物流</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫澳大利亚</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫新西兰</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫物流</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫澳大利亚</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫新西兰</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫物流</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫澳大利亚</a></li><span>|</span>
                <li><a target="_blank" href="#">澳猫新西兰</a></li>
            </ul> -->
            <p>
                澳大利亚Health more - 河南康多多贸易有限公司 - 河南澳蜜电子商务有限公司 版权所有<br>
                Copyright © 20015-2018 澳猫aumalls.com 版权所有, 豫ICP备15030837号-1
            </p>
            <div class="ALLN"></div>
        </div>
    </div>
</footer>
<script src="../../resources/js/jquery-1.7.2.min.js"></script>
<script src="../../resources/js/jquery.lazyload.min.js"></script>
<script src="../../resources/js/base.js"></script>
<script src="../../resources/js/controller/paging.js"></script>
<script src="../../resources/js/controller/login.js"></script>
<script>

    $(".deleteiterm").click(function () {

        var del_id = $(this).parent().prev("input").val()
        var th = $(this);

        alert(del_id)

        if (confirm("确认将其移除购物车吗？")) {
            //发送ajax请求删除
            $.ajax({
                url: "http://127.0.0.1/shopcart/flushCartIterm?itermid=" + del_id,
                success: function (result) {
                    alert("111111111111")
                    th.parents("li").remove()
                    alert("删除成功！");
                    var total = $("#total").text()
                    var itermtotal = th.parent().parent().parent().parent().attr("data_obj")
                    $("#total").text(parseInt(total) - parseInt(itermtotal))

                }
            });
        }

    })

    $(".num-jian").click(function () {

        var num = parseInt($(this).next().val())

        if(num == 1){
            alert("数量不能为负数！！！")
        }else{
            alert(${APP_PATH})
            var id = $(this).attr("data_obj")
            var tl = $(this)
            var goodsprice = tl.parent().next().children().attr("data_obj")
            alert(goodsprice)

            $.ajax({
                url:"http://127.0.0.1/shopcart/updataCartNum?itermid="+ id + "&goodsnum=" + (num - 1),

                success:function(result){

                    tl.next().val(num -1)
                    tl.parent().next().children().children().text(goodsprice * (num - 1))

                    var total = $("#total").text()

                    $("#total").text(parseInt(total) - parseInt(goodsprice))


                }
            });

        }




    })

    $(".num-jia").click(function () {

        var num = parseInt($(this).prev().val())

        var id = $(this).attr("data_obj")
        var tl = $(this)

        var goodsprice = tl.parent().next().children().attr("data_obj")


        $.ajax({
         url:"http://127.0.0.1/shopcart/updataCartNum?itermid="+ id + "&goodsnum=" + (num + 1),

         success:function(result){
             alert("+++++++++")
                tl.prev().val(num + 1)
             tl.parent().next().children().children().text(goodsprice * (num + 1))
             }
         });

        var total = $("#total").text()

        $("#total").text(parseInt(total) + parseInt(goodsprice))

    })


    $(".input-num").change(function () {
        alert("进入")
        var id = $(this).prev().attr("data_obj")
        var num = $(this).val()
        var tl = $(this)
        if(num <= 0){
            alert("数据失败！！！")
            window.location.href="http://127.0.0.1/shopcart/getUserShopCartIterm?userid=1";
        }else{
            var oldtotal = tl.parent().parent().parent().attr("data_obj")
            alert(oldtotal)
            $.ajax({

                url:"http://127.0.0.1/shopcart/updataCartNum?itermid="+ id + "&goodsnum=" + num,

                success:function(result){

                    var goodsprice = tl.parent().next().children().attr("data_obj")
                    alert(goodsprice)

                    tl.parent().next().children().children().text(parseInt(goodsprice) * parseInt(num))

                    var total = $("#total").text()
                    alert(total)

                    $("#total").text(parseInt(total) - parseInt(oldtotal) + parseInt(goodsprice) * parseInt(num))
                }
            });
        }


    })


</script>
</body>
</html>