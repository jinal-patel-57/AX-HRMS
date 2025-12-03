(function($, AXHRMSProbationManagementHrWeb) {
    console.log("main js run")

    let namespace;
    let employeeId;
    let noOfExtendMonth;
    let evalutionReview;
    let probationActionURL;
    let validateFormStatus = false;

    function setConfigs(config){
        namespace = config.namespace;
        probationActionURL = config.probationActionURL;
        noOfExtendMonth = $('#'+namespace+'noOfExtendMonth');
        evalutionReview = $('#'+namespace+'evalutionReview');

        function validateForm(){
            $("#"+namespace+"extendDetailForm").validate({
                rules: {
                    [namespace+"noOfExtendMonth"]:{
                        required: true
                    },
                    [namespace + "evalutionReview"]: {
                        required: true,
                        maxlength: 500
                    }
                },
                messages: {
                    [namespace+"noOfExtendMonth"]:{
                        required: "Please Select month of extend value"
                    },
                    [namespace + "evalutionReview"]: {
                        required: "Please enter evalution review",
                        maxlength: "Max 500 character required"
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                }
            });
            validateFormStatus=true;
            // If  fields are filled, return true (form is valid)
            return true;
        }

        function showMessage(newMessage) {
            Liferay.Util.openToast({
                title: 'Info',
                message: newMessage,
                type: 'info',
                autoClose: 10000
            });
        }

        $('#extendProbationDetailModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal

            employeeId = button.data('employee-id');
            var modal = $(this)
            modal.find('.modal-title').text('Extend probation time detail');
            modal.find('#'+namespace+'employeeId').val(employeeId);
        });

        $('#'+namespace+'extendProbationTimeBtn').on('click', function(){
            validateFormStatus = validateForm();
            if(validateFormStatus){
                $('#extendProbationDetailModal').modal('hide');
                probationActionURL = probationActionURL.replace('PROBATION_ACTION_TYPE','Extended');
                probationActionURL = probationActionURL.replace('EMPLOYEE_ID',employeeId);
                console.log(probationActionURL);
                $('#'+namespace+'extendDetailForm').attr('action',probationActionURL);
                if(confirm("Are you sure to extend probation time?"))
                    $('#'+namespace+'extendDetailForm').submit();
                    // window.location.href = probationActionURL;
            }
        });

        // $(".sendWish").click(function(){
        //     // Set employee name in the modal
        //     employeeName = $(this).data('employee-name');
        //     employeeId = $(this).data('employee-id');
        //     wishId = $('#'+namespace+'wishType').val();
        //     $('#'+namespace+'employeeName').val(employeeName)
        //     $('#'+namespace+'employeeId').val(employeeId)
        //     $('#'+namespace+'wishType').val(wishId)
        //     $('#wishesModal').modal('show');
        // });


    }

    AXHRMSProbationManagementHrWeb.setConfigs = setConfigs;
})($, (window.AXHRMSProbationManagementHrWeb = window.AXHRMSProbationManagementHrWeb || {}));
