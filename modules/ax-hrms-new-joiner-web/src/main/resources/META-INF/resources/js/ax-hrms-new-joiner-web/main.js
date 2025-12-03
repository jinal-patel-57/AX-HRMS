(function($, AXHrmsNewJoinerWebPortlet) {

    let namespace;
    let employeeName;
    let employeeId;
    let wishHtmlData;
    let sendWishUrl;
    let validateFormStatus = false;

    function setConfigs(config){
        namespace = config.namespace;
        wishHtmlData = config.wish;
        sendWishUrl = config.sendWishUrl;

        function showMessage(newMessage) {
            Liferay.Util.openToast({
                title: 'Info',
                message: newMessage,
                type: 'info',
                autoClose: 10000
            });
        }

        function validateForm(){
            debugger;
            var wishEditorData =  $('#'+namespace+'newJoinerWishNote').summernote('code').trim();
            $("#"+namespace+"newJoinerWishForm").validate({
                rules: {
                    [namespace+"employeeName"]:{
                        required: true
                    },
                    [namespace + "wishType"]: {
                        required: true
                    }
                },
                messages: {
                    [namespace+"employeeName"]:{
                        required: "Please Reopen the form to fetch Employee Name"
                    },
                    [namespace + "wishType"]: {
                        required: "Please Reopen the form to fetch Wish Type"
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                }
            });
            // Check if wishType is empty
            if (wishEditorData === '') {

                showMessage("Write some wish for "+employeeName+"'s new joining.");
                validateFormStatus = false;
                return false;
            }
            validateFormStatus=true;
            // If  fields are filled, return true (form is valid)
            return true;
        }

        $('#newJoinerWishModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var recipient = button.data('employee-name') // Extract info from data-* attributes

            console.log(employeeName)
            employeeId = button.data('employee-id');
            wishId = $('#'+namespace+'wishType').val();
            $('#'+namespace+'employeeName').prop('readOnly', true);
            debugger;


            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
            var modal = $(this)
            modal.find('.modal-title').text('New message to ' + employeeName)
            modal.find('#'+namespace+'employeeName').val(employeeName)
        });

        $('#'+namespace+'sendWish').on('click', function(){
            debugger;
            validateFormStatus = validateForm();
            wishHtmlData = $('#'+namespace+'newJoinerWishNote').summernote('code');
            if(validateFormStatus){
                $('#'+namespace+'wishesData').val(wishHtmlData);
                $('#anniversaryWishModal').modal('hide');
                $('#'+namespace+'newJoinerWishForm').submit();
            }
        });

        var hideNoteModalSummernote = function() {
            $('.note-modal').css('display','none');
        };

        function initializeSummernote(newJoinerWishNote){
            debugger;
            $('.summernote-container').summernote({
                height: 150,
                codemirror: {
                    theme: 'monokai'
                },
            });
            hideNoteModalSummernote();
        };
        initializeSummernote('newJoinerWishNote');
        console.log("summerNote initialize");

        // Function to empty CKEditor
        function emptyEditor(){
            $('#'+namespace+'newJoinerWishNote').summernote('code','');
        }

        $(".sendNewJoineeWish").click(function(){
            // Set employee name in the modal
            employeeName = $(this).data('employee-name');
            console.log(employeeName)
            employeeId = $(this).data('employee-id');
//            wishId = $('#'+namespace+'wishType').val();
            $('#'+namespace+'employeeName').val(employeeName)
            $('#'+namespace+'employeeId').val(employeeId)
            $('#newJoinerWishModal').modal('show');
        });



        // Cleanup Editor instance when modal is closed
        $('#newJoinerWishModal').on('hidden.bs.modal', function() {
            emptyEditor();
        });

    }

    AXHrmsNewJoinerWebPortlet.setConfigs = setConfigs;
})(jQuery, (window.AXHrmsNewJoinerWebPortlet = window.AXHrmsNewJoinerWebPortlet || {}));
