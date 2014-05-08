(function($) {

    $.extend({
        admin: {}
    });


    $.admin.container = $('.admin-container-inner-wrap');

    function _init(){

        $.admin.container.load('/admin/home',function(){

            $('.menu-btn-home').parent().addClass('active');

        });
        _initEvent();


    }

    function _initEvent(){

        $('.menu-btn-home').on('click',function(){

            $('.admin-menu').find('li').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/home',function(){

                $('.menu-btn-home').parent().addClass('active');

           });
        });
        $('.menu-btn-new').on('click',function(){

            $('.admin-menu').find('li').each(function(){
                $(this).removeClass('active');
            });

            $.admin.container.load('/admin/new',function(){

                $('.menu-btn-new').parent().addClass('active');
            });
        });
        $('.menu-btn-posts').on('click',function(){
            $('.admin-menu').find('li').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/posts',function(){
                $('.menu-btn-posts').parent().addClass('active');

            });
        });
        $('.menu-btn-categories').on('click',function(){
            $('.admin-menu').find('li').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/categories',function(){
                $('.menu-btn-categories').parent().addClass('active');

            });
        });
        $('.menu-btn-comments').on('click',function(){
            $('.admin-menu').find('li').each(function(){
                $(this).removeClass('active');
            });
            $.admin.container.load('/admin/comments',function(){
                $('.menu-btn-comments').parent().addClass('active');
            });
        });
    }

    _init();




})(jQuery);