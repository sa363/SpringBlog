(function($) {
    function _init(){
        _initCategorySelectMenu();
        _initEvent();
    }
    function _initCategorySelectMenu(){
        var html = '';
        var menu = $('.newpost-category-select-menu');


        var data = [{name:'C++',id:1},{name:'Java',id:2},{name:'Python',id:3}];
        for(var i = 0; i < data.length; i++){
            var categoryName = data[i].name;
            html += '<li><a data-key="'+data[i].id+'" href="#">'+categoryName+'</a></li>';
        }
        menu.append($(html));

        $('li','.newpost-category-select-menu').each(function(){
            $(this).on('click',function(){
                var category = $(this).find('a');
                $('.newpost-category-btn-name').html(category.html());
                $('.newpost-category-btn-name').attr('data-key',category.attr('data-key'));
                $('.dropdown-toggle').dropdown();

            });

        });

    }
    function _initEvent(){

        $('.new-post-save-btn').on('click',function(){
            _savePosts();

        });
        $('.new-post-publish-btn').on('click',function(){
            _publishPosts();

        });

    }

    //ajax
    function _savePosts(){

        var categoryId = $('.newpost-category-btn-name').attr('data-key');
        var postTitle = $('.admin-new-post-title').val();
        var postContent = $('.admin-new-post-content').val();
        var postId =  $('.admin-new-post-title').attr('data-key');

        var url = '/admin/new/post';
        var data = {
            categoryId : categoryId,
            title : postTitle,
            content : postContent
        };
        if(postId != undefined && postId != ''){
            data.postId = postId;
        }

        $.post(url,data,function(data){
            console.log('save post success----'+data);
            if(data.returnCode == 1){

                var postId = data.postId;
                $('.admin-new-post-title').attr('data-key',postId);

                $('.admin-new-post-alert').addClass('alert-success');
                $('.admin-new-post-alert').css('display','block');
            }

        });

    }

    function _publishPosts(){

        var categoryId = $('.newpost-category-btn-name').attr('data-key');
        var postTitle = $('.admin-new-post-title').val();
        var postContent = $('.admin-new-post-content').val();
        var postId =  $('.admin-new-post-title').attr('data-key');

        var url = '/admin/new/post';
        var data = {
            categoryId : categoryId,
            title : postTitle,
            content : postContent
        };
        if(postId != undefined && postId != ''){
            data.postId = postId;
        }

        $.post(url,data,function(data){
            console.log('save post success----'+data);
            if(data.returnCode == 1){

                var postId = data.postId;

                $.admin.container.load('/admin/posts/'+postId,function(){

                });

            }


        });

    }
    _init();


})(jQuery);