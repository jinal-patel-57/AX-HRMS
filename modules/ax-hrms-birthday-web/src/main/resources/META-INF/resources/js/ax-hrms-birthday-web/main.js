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

            // Event handler for form submission
            $(document).on('click', '#send', function () {

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


            $('#wishesIdDiv').summernote({
                height: 150,
                codemirror: {
                    theme: 'monokai'
                },
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
                $("#wishType").val("Birthday Wishes");

                // Show the modal
                $('#birthdayWishesModal').modal('show');
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
