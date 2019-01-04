$(document).ready(function () {
    var tops = $(".swiper-card-wrapper").offset().top + $(".swiper-card-wrapper").height() / 2 - $(".btn-card-prev").height() / 2;
    $(".btn-card-prev").css("top", tops);
    $(".btn-card-next").css("top", tops);
})