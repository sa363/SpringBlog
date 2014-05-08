(function($) {

    $.extend({
        admin: {}
    });

    $.admin.container = $('.admin-container-inner-wrap');

    function _init(){

        $.admin.container.load('/admin/home',function(){

            $('.menu-btn-home').addClass('active');

        });
        _initEvent();


    }

    function _initEvent(){

        $('.menu-btn-home').on('click',function(){

            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/home',function(){

                $('.menu-btn-home').addClass('active');

           });
        });
        $('.menu-btn-new').on('click',function(){

            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/new',function(){

                $('.menu-btn-new').addClass('active');
            });
        });
        $('.menu-btn-posts').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/posts',function(){
                $('.menu-btn-posts').addClass('active');

            });
        });
        $('.menu-btn-categories').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/categories',function(){
                $('.menu-btn-categories').addClass('active');

            });
        });
        $('.menu-btn-comments').on('click',function(){
            $('.admin-menu').find('a').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/comments',function(){
                $('.menu-btn-comments').addClass('active');
            });
        });
    }

    _init();




})(jQuery);