(function($) {

    var createBtn = $('.admin-categories-create');
    var editBtn = $('.admin-categories-edit');
    var deleteBtn = $('.admin-categories-delete');

    var createModal = $('#createCategoryModal');
    var editModal = $('#editCategoryModal');

   function _init(){
       _initEvent();
   }

    function _initEvent(){

        createBtn.on('click',function(){

            createModal.modal('show');

        });

        createModal.find('.save-category-btn').on('click',function(){

            _saveCategory();

        });

        editBtn.on('click',function(){

            _editCategory();

        });

        editModal.find('.edit-category-btn').on('click',function(){

            _updateCategory();
        });

        deleteBtn.on('click',function(){
           _deleteCategory();
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

    function _editCategory(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');

        var categoryId = selection.parents('tr').attr('data-key');



        $.get('/admin/category/'+categoryId,function(data){

            var category = data.category;
            editModal.find('.category-name').val(category.catName);
            editModal.modal('show');

        });

    }

    function _updateCategory(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');

        var categoryId = selection.parents('tr').attr('data-key');

        var categoryName =  editModal.find('.category-name').val();


        editModal.modal('hide');

        $.put('/admin/category/'+categoryId,{categoryName:categoryName},function(){

            $.admin.container.load('/admin/categories');

        });
    }


    function _deleteCategory(){

        var selection = $('tbody input[type=checkbox]:checked','.admin-categories-table');

        var categoryId = selection.parents('tr').attr('data-key');

        $.delete('/admin/category/'+categoryId,null,function(data){

            $.admin.container.load('/admin/categories');

        });

    }



    _init();



})(jQuery);