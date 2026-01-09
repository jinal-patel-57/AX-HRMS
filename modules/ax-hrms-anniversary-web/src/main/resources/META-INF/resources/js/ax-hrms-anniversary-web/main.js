(function($, AXHrmsAnniversaryWebPortlet) {

    let namespace;
    let employeeName;
    let employeeId;
    let wishHtmlData;
    let sendWishUrl;
    let validateFormStatus = false;

    function setAnniversaryConfigs(config){
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
            var wishEditorData =  $('#'+namespace+'anniversaryWishNote').summernote('code').trim();
            $("#"+namespace+"anniversaryWishForm").validate({
                rules: {
                    [namespace+"employeeName"]:{
                        required: true
                    }
                },
                messages: {
                    [namespace+"employeeName"]:{
                        required: "Please Reopen the form to fetch Employee Name"
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                }
            });
            // Check if wishType is empty
            if (wishEditorData === '') {

                showMessage("Write some wish for "+employeeName+"'s Anniversary.");
                validateFormStatus = false;
                return false;
            }
            validateFormStatus=true;
            // If  fields are filled, return true (form is valid)
            return true;
        }

        $('#anniversaryWishModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var recipient = button.data('employee-name') // Extract info from data-* attributes

            employeeName = button.data('employee-name');
            employeeId = button.data('employee-id');
            //wishId = $('#'+namespace+'wishType').val();
            $('#employeeNameAni').prop('readonly', true);


            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
            var modal = $(this)
            // modal.find('.modal-title').text('New message to ')
            modal.find('#employeeNameAni').val(recipient)
                hideError();

        });

        $('#'+namespace+'sendWish').on('click', function(){

                    if (!isSummernoteValid()) {
                            showError();
                            return false; // prevent submission
                    }else{

        hideError();

            validateFormStatus = validateForm();
            wishHtmlData = $('#'+namespace+'anniversaryWishNote').summernote('code');
            if(validateFormStatus){
                $('#'+namespace+'wishesData').val(wishHtmlData);
                $('#anniversaryWishModal').modal('hide');
                $('#'+namespace+'anniversaryWishForm').submit();
            }
            }
        });

$(document).on(
    'focusout',
    '#'+namespace+'anniversaryWishNote + .note-editor .note-editable',
    function () {
        if (!isSummernoteValid()) {
            showError();
        } else {
            hideError();
        }
    }
);



        var hideNoteModalSummernote = function() {
            $('.note-modal').css('display','none');
        };

            function isSummernoteValid() {
                let html = $('#'+namespace+'anniversaryWishNote').summernote('code');
                let $content = $('<div>').html(html);

                let text = $content.text().trim();
                let hasImage = $content.find('img').length > 0;

                return text.length > 0 || hasImage;
            }

            function showError() {
                $('#'+namespace+'wishError').show();
            }

            function hideError() {
                $('#'+namespace+'wishError').hide();
            }


        const initializeSummernote = function(anniversaryWishNote){
            $('#'+namespace+'anniversaryWishNote').summernote({
                height: 150,
                codemirror: {
                    theme: 'monokai'
                },
            });
            hideNoteModalSummernote();
        };
        initializeSummernote();
        // Function to empty CKEditor
        $('#'+namespace+'anniversaryWishNote')
            .next('.note-editor')
            .find('.note-btn[data-original-title="Video"]')
            .remove();


        function emptyEditor(){
            $('#'+namespace+'anniversaryWishNote').summernote('code','');
        }

        $(document).ready(function (){
            $(".sendAnniversaryWish").click(function(){
                // Set employee name in the modal
                debugger;
                $('#anniversaryWishModal').modal('show');
                employeeName = $(this).data('employee-name');
                employeeId = $(this).data('employee-id');
             //   wishId = $('#'+namespace+'wishType').val();
                let empName = $(this).data('employee-name');
                $('#employeeNameAni').val(empName);
                $('#'+namespace+'employeeId').val(employeeId);
            });
        });




        // Cleanup Editor instance when modal is closed
        $('#anniversaryWishModal').on('hidden.bs.modal', function() {
            emptyEditor();
        });

    }

    AXHrmsAnniversaryWebPortlet.setAnniversaryConfigs = setAnniversaryConfigs;
})(jQuery, (window.AXHrmsAnniversaryWebPortlet = window.AXHrmsAnniversaryWebPortlet || {}));
