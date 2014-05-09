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
        refreshBtnGroup();

    }

    function _initEvent(){


        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                refreshBtnGroup();
            });

        });

        readBtn.on('click',function(){

            _readPost();

        });

        editBtn.on('click',function(){

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



    //ajax

    function _readPost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        console.log(postId);

        $.admin.container.load('/admin/posts/'+postId,function(){

        });

    }

    function _deletePost(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-posts-table');

        var postId = selection.parents('tr').attr('data-key');

        $.delete('/admin/post/'+postId,null,function(response,textStatus){
            console.log(response);
            console.log(textStatus);
            $.admin.container.load('/admin/posts');
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

            console.log('_changeCommentStatus success----'+data);

        });


    }



    _init();


})(jQuery);