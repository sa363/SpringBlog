(function($) {

    var createBtn = $('.admin-categories-create');
    var editBtn = $('.admin-categories-edit');
    var deleteBtn = $('.admin-categories-delete');
    var createModal = $('#createCategoryModal');

   function _init(){
       _initEvent();
   }

    function _initEvent(){

        createBtn.on('click',function(){
            console.log('show');
            createModal.modal('show');

        });

        createModal.find('.save-category-btn').on('click',function(){
            console.log('click');
            _saveCategory();
        });

    }




    //ajax

    function _saveCategory(){

        var name = $('#createCategoryModal').find('.category-name').val();

        createModal.modal('hide');

        $.post('/admin/category',{categoryName:name},function(){

            $.admin.container.load('/admin/categories');

        });

    }
    _init();



})(jQuery);