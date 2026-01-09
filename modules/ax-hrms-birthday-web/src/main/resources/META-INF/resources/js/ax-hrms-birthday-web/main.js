(function ($, AXHrmsBirthdayWebPortlet) {

    let namespace;
    let employeeName;
    let wishType;
    let wishes;
    let employeeId;
    let sendWishesurl;
    let validateFormStatus = false;
    var initializeSummernote;

    function setBirthdayConfigs(config) {
        namespace = config.namespace;
        employeeName = config.employeeName;
        wishType = config.wishType;
        wishes = config.wishes;
        employeeId = config.employeeId;
        sendWishesurl = config.sendWishesurl;

		
        $(document).ready(function () {




$('#wishesIdDiv').next('.note-editor')
    .find('.note-btn[data-original-title="Video"]').remove();

            function validateForm() {
                var wishes = $('#wishesIdDiv').summernote('code').trim();

                // Check if wishType is empty
                if (wishes === '') {
                    alert('Please enter a wishes.');
                    return false;
                }
                // If fields are filled, return true (form is valid)
                return true;
            }

            /* ---------------- Validation ---------------- */
            function isSummernoteValid() {
                let html = $('#wishesIdDiv').summernote('code');
                let $content = $('<div>').html(html);

                let text = $content.text().trim();
                let hasImage = $content.find('img').length > 0;
                let hasVideo = $content.find('iframe, video').length > 0;

                return text.length > 0 || hasImage || hasVideo;
            }
            function showError() {
                $('#wishesError').show();
            }

            function hideError() {
                $('#wishesError').hide();
            }





            // Event handler for form submission
            $(document).on('click', '#send', function () {


                if (!isSummernoteValid()) {
                    $('#wishesError').show();
                    return false;
                }


                // Perform form validation
                if (validateForm()) {

                    $("#wishesData").val($('#wishesIdDiv').summernote('code'));

                    $('#birthdayWishesModal').modal('hide');

                    $('#wishesForm').submit();
                }
            });

            var hideNoteModalSummernote = function () {
                $('.note-modal').css('display', 'none');
            };


            $(document).on('focusout', '.note-editable', function () {
                if (!isSummernoteValid()) {
                    showError();
                }
                else{
                  hideError();
                }
            });

            $('#wishesIdDiv').summernote({
                height: 150,
                codemirror: {
                    theme: 'monokai'
                },
    callbacks: {

        // 🔥 REAL-TIME change (typing, image add)
        onChange: function () {
            if (isSummernoteValid()) {
                hideError();
            }
        },

        // 🔥 BLUR EVENT (THIS is the key)
        onBlur: function () {
            if (!isSummernoteValid()) {
                showError();
            }
        }
    }

            });



            hideNoteModalSummernote();


            // Function to empty CKEditor
            function emptyEditor() {
                $('#wishesIdDiv').summernote('code', '');
            }

            // Function to show the popup with employee name and wish type

            $(".sendBirthdayWish").click(function () {
                // Set employee name in the modal

                $("#employeeName").val($(this).data("name"));
                $("#employeeId").val($(this).data("id"));
               // $("#wishType").val("Birthday Wishes");

                // Show the modal
                $('#birthdayWishesModal').modal('show');
                                hideError();

            });

            // Cleanup Editor instance when modal is closed
            $('#birthdayWishesModal').on('hidden.bs.modal', function () {
                emptyEditor();
            });
            document.querySelectorAll('.note-editor.note-frame.panel.panel-default')[1].remove();
    
        });
    }

    AXHrmsBirthdayWebPortlet.setBirthdayConfigs = setBirthdayConfigs;
})(jQuery, (window.AXHrmsBirthdayWebPortlet = window.AXHrmsBirthdayWebPortlet
    || {}));
