(function($) {
    function _init(){
        _initEvent();
        refreshBtnGroup();

    }

    function _initEvent(){
        var table = $('.admin-posts-table');
        var tbody = table.find('tbody');

        $('tr',tbody).each(function(){

            $(this).on('click',function(){
                console.log('tr click--'+$('tbody input[tpye=check]:checked','.admin-posts-table').length);
                refreshBtnGroup();
            });

        });


    }

    function refreshBtnGroup(){
       var checkArr =  $('tbody input[type=checkbox]:checked','.admin-posts-table');
       var count = checkArr.length;
       var readBtn = $('.admin-posts-read');
       var editBtn = $('.admin-posts-edit');
       var deleteBtn = $('.admin-posts-delete');
       var closeCommentsBtn = $('.admin-posts-close-comments');
        console.log('refresh----'+count);

       switch (count){
           case 0:
               readBtn.attr('disabled','disabled');
               editBtn.attr('disabled','disabled');
               deleteBtn.attr('disabled','disabled');
               closeCommentsBtn.attr('disabled','disabled');
               break;
           case 1:
               readBtn.removeAttr('disabled');
               editBtn.removeAttr('disabled');
               deleteBtn.removeAttr('disabled');
               closeCommentsBtn.removeAttr('disabled');
               break;
           default:

               readBtn.removeAttr('disabled');
               editBtn.removeAttr('disabled');

               deleteBtn.attr('disabled','disabled');
               closeCommentsBtn.attr('disabled','disabled');

       }
    }



    _init();


})(jQuery);