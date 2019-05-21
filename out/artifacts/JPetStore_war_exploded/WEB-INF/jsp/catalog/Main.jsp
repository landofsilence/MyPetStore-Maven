<%--
  Created by IntelliJ IDEA.
  User: 24518
  Date: 2018/12/3
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../common/IncludeTop.jsp"%>

<!----><script type="text/javascript" src="js/main.js"></script>

</div>


    <div id="Main">
        <div id="Welcome">
            <div id="WelcomeContent">
                Welcome to MyPetStore!
            </div>
        </div>
        <div id="Sidebar">
            <div id="SidebarContent">
                <a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif"/></a>
                <br/> Saltwater, Freshwater <br/>
                <a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif"/></a>
                <br/> Various Breeds <br/>
                <a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif"/></a>
                <br/> Various Breeds, Exotic Varieties <br/>
                <a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif"/></a>
                <br/> Lizards, Turtles, Snakes <br/>
                <a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif"/></a>
                <br/> Exotic Varieties
            </div>
        </div>

        <div id="MainImage">
            <div id="MainImageContent">
                <map name="estoremap">
                    <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" shape="rect"/>
                    <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" shape="rect"/>
                    <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" shape="rect"/>
                    <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" shape="rect"/>
                    <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" shape="rect"/>
                    <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" shape="rect"/>
                </map>
                <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap"
                     width="350"/>
            </div>
        </div>
        <div id="Separator">&nbsp;</div>
    </div>
<%--
<script  type="text/javascript">
    //卡片切换
    var swiper = new Swiper('.swiper-container-card', {
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        loop: true,
        spaceBetween: 10,
        slidesPerView: 'auto',
        coverflowEffect: {
            rotate: 10,
            stretch: -10,
            depth: 120,
            modifier: 2,
            slideShadows : false
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true
        },
        navigation: {
            nextEl: '.btn-card-prev',
            prevEl: '.btn-card-next',
        },
    });

    //雪花
    $(document).snowfall('clear');
    $(document).snowfall({
        image: "images/flake.png",
        flakeCount:15,
        minSize: 40,
        maxSize: 60
    });
</script>

<script type="text/javascript">


    $('#f-nav').tooltip({
        default: 0,       // 默认为空  --  选中默认值
        width: '277',     // 限制宽度
        height: '100',
        textList: ['Main' ,'Fish' ,'Dogs','Cats', 'Reptiles' , 'Birds'],   // 每个导航的内容
        type: 'slideMove',  // 必填, 选择内容
        success: function(ret){

        }   //初始化回调
    });


</script>--%>


<%@ include file="../common/IncludeBottom.jsp"%>
