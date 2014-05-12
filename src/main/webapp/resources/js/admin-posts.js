(function($) {

    var COMMETNS_STAUTS_CLOSE = 0;
    var COMMETNS_STAUTS_OPEN = 1;

    var table = $('.admin-posts-table');
    var tbody = table.find('tbody');

    var readBtn = $('.admin-posts-read');
    var editBtn = $('.admin-posts-edit');
    var deleteBtn = $('.admin-posts-delete');
    var closeCommentsBtn = $('.admin-posts-close-comments');
    var openCommentsBtn = $('.admin-posts-open-comments');


    function _init(){
        _initEvent();
        _listPost();
    }




    function _initEvent(){

        readBtn.on('click',function(){

            _readPost();

        });

        editBtn.on('click',function(){

            _editPost();

        });

        deleteBtn.on('click',function(){

            _deletePost();

        });

        closeCommentsBtn.on('click',function(){

            _changeCommentStatus(COMMETNS_STAUTS_CLOSE);

        });

        openCommentsBtn.on('click', function(){

            _changeCommentStatus(COMMETNS_STAUTS_OPEN);

        });


    }

    function refreshBtnGroup(){

       var checkArr =  $('tbody input[type=checkbox]:checked','.admin-posts-table');
       var count = checkArr.length;

        console.log('refresh----'+count);

       switch (count){
           case 1:
               readBtn.removeAttr('disabled');
               editBtn.removeAttr('disabled');
               deleteBtn.removeAttr('disabled');
               closeCommentsBtn.removeAttr('disabled');
               openCommentsBtn.removeAttr('disabled');
               break;

           default:

               readBtn.attr('disabled','disabled');
               editBtn.attr('disabled','disabled');
               deleteBtn.attr('disabled','disabled');
               closeCommentsBtn.attr('disabled','disabled');
               openCommentsBtn.attr('disabled','disabled');

       }
    }
//    function refreshBtnGroup(){
//
//        var checkArr =  $('tbody input[type=checkbox]:checked','.admin-posts-table');
//        var count = checkArr.length;
//
//        console.log('refresh----'+count);
//
//        switch (count){
//            case 0:
//                readBtn.attr('disabled','disabled');
//                editBtn.attr('disabled','disabled');
//                deleteBtn.attr('disabled','disabled');
//                closeCommentsBtn.attr('disabled','disabled');
//                break;
//
//            case 1:
//                readBtn.removeAttr('disabled');
//                editBtn.removeAttr('disabled');
//                deleteBtn.removeAttr('disabled');
//                closeCommentsBtn.removeAttr('disabled');
//                break;
//
//            default:
//
//                deleteBtn.removeAttr('disabled');
//                closeCommentsBtn.removeAttr('disabled');
//
//                readBtn.attr('disabled','disabled');
//                editBtn.attr('disabled','disabled');
//
//        }
//    }



    function _loadPostData(posts){
        var html = [];
        for(var i = 0; i < posts.length; i++){

            var post = posts[i];

            html.push(' <tr data-key="'+post.postId+'">');
            html.push(' <td>');
            html.push(' <div class="checkbox">');
            html.push(' <label>');
            html.push(' <input type="checkbox" value="">');
            html.push(' <h4>'+post.postTitle+'</h4>');
            html.push(' </label>');
            html.push(' </div>');
            html.push(' </td>');
            html.push(' </tr>');

        }
        tbody.empty();
        tbody.append(html.join(''));

        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });

    }

    //ajax

    function _readPost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        console.log(postId);

        $.admin.container.load('/admin/view/post/'+postId,function(){

        });

    }

    function _editPost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        $.get('/admin/post/'+postId,function(data){

            var post = data.post;
            var category = data.category;

            $('.admin-posts-container').load('/admin/view/new',function(){

                $('#new-post-content').val(post.postContent);
                $('.admin-new-post-title').val(post.postTitle);
                $('.admin-new-post-title').attr('data-key',post.postId);
                $('.newpost-category-btn-name').html(category.catName);
                $('.newpost-category-btn-name').attr('data-key',category.catId);

            });

        });
    }

    function _deletePost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        $.delete('/admin/post/'+postId,null,function(response,textStatus){

            _listPost();
        });



    }

    function _changeCommentStatus(commentStatus){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');
        var data = {
            commentStatus : commentStatus
        }
        var url = '/admin/post/'+postId;
        $.put(url,data,function(data){

            if(data.returnCode == 1){

                if(commentStatus == COMMETNS_STAUTS_CLOSE){

                    $('.admin-posts-alert-msg-notice').html('You successfully close comments of the post.')

                }else{

                    $('.admin-posts-alert-msg-notice').html('You successfully open comments of the post.')

                }
                $('.admin-posts-alert').addClass('alert-success');
                $('.admin-posts-alert').css('display','block');


            }

        });

    }

    function _listPost(){

        $.get('/admin/posts', function(data){
            var posts = data.posts;
            _loadPostData(posts);
        });

    }



    _init();


})(jQuery);