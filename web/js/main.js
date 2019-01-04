$(document).ready(function () {
    var tops = $(".swiper-card-wrapper").offset().top + $(".swiper-card-wrapper").height() / 3;
    console.log("$(\".swiper-card-wrapper\").offset().top = " + $(".swiper-card-wrapper").offset().top)
    console.log("$(\".swiper-card-wrapper\").offset().height / 2 = " + $(".swiper-card-wrapper").height() / 3)
    $(".btn-card-prev").css("top", tops);
    $(".btn-card-next").css("top", tops);
})