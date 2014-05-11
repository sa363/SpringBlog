(function($){

    var editBtn = $('.admin-comments-edit');
    var deleteBtn = $('.admin-comments-delete');
    var editModal = $('#editCommentModal');

    function _init(){
        _initEvent();
    }
    function _initEvent(){

        editBtn.on('click',function(){
            _findComment();
        });
        editModal.find('.edit-comment-btn').on('click',function(){
            _updateComment();
        });

        deleteBtn.on('click',function(){
            _deleteComment();

        });

    }



    //ajax

    function _findComment(){
        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');
        $.get('/admin/comment/'+commentId,function(data){
            var comment = data.comment;
            editModal.find('.comment-content').val(comment.commentContent);
            editModal.modal('show');
        });
    }

    function _updateComment(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');
        var commentContent = editModal.find('.comment-content').val();

        editModal.modal('hide');

        $.put('/admin/comment/'+commentId,{commentContent : commentContent},function(){
            $.admin.container.load('/admin/comments');
        });
    }

    function _deleteComment(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-comments-table');
        var commentId = selection.parents('tr').attr('data-key');

        $.delete('/admin/comment/'+commentId,null,function(){
            $.admin.container.load('/admin/comments');
        })
    }




    _init();



})(jQuery);