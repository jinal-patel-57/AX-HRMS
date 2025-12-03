(function($, AxProfileManagementWeb) {
    let namespace;

    let permanantLine1;
    let permanantLine2;
    let permanantLine3;
    let permanantState;
    let permanantPincode;
    let permanantCountry;

    let presentLine1;
    let presentLine2;
    let presentLine3;
    let presentState;
    let presentPincode;
    let presentCountry;

    let presentLine1Value;
    let presentLine2Value;
    let presentLine3Value;
    let presentStateValue;
    let presentPincodeValue;
    let presentCountryValue;

    let isSamePresentAddress;

    let firstName;
    let middleName;
    let lastName;
    let personalEmail;
    let mobileNumber;


    function setConfigs(config){
        namespace = config.namespace;

        firstName = $('#'+namespace+'firstName');
        middleName = $('#'+namespace+'middleName');
        lastName = $('#'+namespace+'lastName');
        personalEmail = $('#'+namespace+'personalEmail');
        mobileNumber = $('#'+namespace+'mobileNumber');

        permanantLine1 = $('#'+namespace+'permanantLine1');
        permanantLine2 = $('#'+namespace+'permanantLine2');
        permanantLine3 = $('#'+namespace+'permanantLine3');
        permanantState = $('#'+namespace+'permanantState');
        permanantPincode = $('#'+namespace+'permanantPincode');
        permanantCountry = $('#'+namespace+'permanantCountry');

        presentLine1 = $('#'+namespace+'presentLine1');
        presentLine2 = $('#'+namespace+'presentLine2');
        presentLine3 = $('#'+namespace+'presentLine3');
        presentState = $('#'+namespace+'presentState');
        presentPincode = $('#'+namespace+'presentPincode');
        presentCountry = $('#'+namespace+'presentCountry');

        presentLine1Value = presentLine1.val();
        presentLine2Value = presentLine2.val();
        presentLine3Value = presentLine3.val();
        presentStateValue = presentState.val()
        presentPincodeValue = presentPincode.val();
        presentCountryValue = presentCountry.val();
        console.log("Present Country value: "+presentCountryValue);

        isSamePresentAddress = $('#'+namespace+'isSamePresentAddress');

        $(document).ready(function(){

            $("#profileForm").validate({
                rules:{
                    [namespace+"firstName"]:{
                        required:true,
                        validLetters:true,
                        maxlength: 75
                    },
                    [namespace+"lastName"]:{
                        required:true,
                        validLetters:true,
                        maxlength: 75
                    },
                    [namespace+"middleName"]:{
                        required:true,
                        validLetters:true,
                        maxlength: 75
                    },
                    [namespace+"mobileNumber"]:{
                        required:true,
                        onlyNumbers:true,
                        maxlength: 10,
                        minlength: 10
                    },
                    [namespace+"personalEmail"]:{
                        required:true,
                        validEmail:true,
                        maxlength: 75
                    },
                    [namespace+"permanantLine1"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"permanantLine2"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"permanantLine3"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"presentLine1"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"presentLine2"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"presentLine3"]:{
                        required:true,
                        maxlength: 75
                    },
                    [namespace+"permanantPincode"]:{
                        required:true,
                        onlyNumbers: true,
                        maxlength: 6,
                        minlength: 6
                    },
                    [namespace+"permanantState"]:{
                        required:true,
                        validLetters: true,
                        maxlength: 75
                    },
                    [namespace+"permanantCountry"]:{
                        required:true,
                        onlyNumbers:true,
                        maxlength: 5
                    },
                    [namespace+"presentPincode"]:{
                        required:true,
                        onlyNumbers: true,
                        maxlength: 6,
                        minlength: 6
                    },
                    [namespace+"presentState"]:{
                        required:true,
                        validLetters: true,
                        maxlength: 75
                    },
                    [namespace+"presentCountry"]:{
                        required:true,
                        onlyNumbers:true,
                        maxlength: 5
                    },
                },
                messages:{
                    [namespace+"firstName"]:{
                        required:"Enter first name",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"lastName"]:{
                        required:"Enter last name",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"middleName"]:{
                        required:"Enter middle name",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"mobileNumber"]:{
                        required:"Enter Mobile number",
                        maxlength: "Mobile number length is high",
                        minlength: "Enter 10 numbers.."
                    },
                    [namespace+"personalEmail"]:{
                        required:"Enter Personal email",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"permanantLine1"]:{
                        required:"Enter address line 1",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"permanantLine2"]:{
                        required:"Enter address line 2",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"permanantLine3"]:{
                        required:"Enter address line 3",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"presentLine1"]:{
                        required:"Enter address line 1",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"presentLine2"]:{
                        required:"Enter address line 2",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"presentLine3"]:{
                        required:"Enter address line 3",
                        maxlength: "lessthan 75 character required"
                    },
                    [namespace+"permanantPincode"]:{
                        required:"Enter Pincode",
                        maxlength: "Exact 6 length required",
                        minlength: "Exact 6 length required"
                    },
                    [namespace+"permanantState"]:{
                        required:"Enter State",
                        maxlength: "Max 75 length required"
                    },
                    [namespace+"permanantCountry"]:{
                        required:"Select Country"
                    },
                    [namespace+"presentPincode"]:{
                        required:"Enter Pincode",
                        maxlength: "Exact 6 length required",
                        minlength: "Exact 6 length required"
                    },
                    [namespace+"presentState"]:{
                        required:"Enter State",
                        maxlength: "Max 75 length required"
                    },
                    [namespace+"presentCountry"]:{
                        required:"Select Country"
                    },
                },
                errorPlacement:function(error,element){
                    error.insertAfter(element);
                }
            });
            $.validator.addMethod("validLetters", function(value, element) {
                return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
            }, "Please enter letters only");
            $.validator.addMethod("onlyNumbers", function(value, element) {
                return this.optional(element) || /^[0-9]+$/.test(value);
            }, "Please enter number only");
            $.validator.addMethod("validEmail", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/i.test(value);
            }, "Please enter a valid email address");
        });

        function changePresentAddressFieldData(){
            console.log("changePresentAddressFields function called")
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress){
                presentLine1.val(permanantLine1.val());
                presentLine2.val(permanantLine2.val());
                presentLine3.val(permanantLine3.val());
                presentPincode.val(permanantPincode.val());
                presentState.val(permanantState.val());
                presentCountry.val(permanantCountry.val());
                presentLine1.prop('disabled',true);
                presentLine2.prop('disabled',true);
                presentLine3.prop('disabled',true);
                presentPincode.prop('disabled',true);
                presentState.prop('disabled',true);
                presentCountry.prop('disabled',true);
            }
            else{
                presentLine1.val(presentLine1Value);
                presentLine2.val(presentLine2Value);
                presentLine3.val(presentLine3Value);
                presentPincode.val(presentPincodeValue);
                presentState.val(presentStateValue);
                presentCountry.val(presentCountry.val());
                presentLine1.prop('disabled',false);
                presentLine2.prop('disabled',false);
                presentLine3.prop('disabled',false);
                presentPincode.prop('disabled',false);
                presentState.prop('disabled',false);
                presentCountry.prop('disabled',false);
            }
        }

        permanantLine1.on('keyup',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentLine1.val(permanantLine1.val());
        })
        permanantLine2.on('keyup',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentLine2.val(permanantLine2.val());
        })
        permanantLine3.on('keyup',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentLine3.val(permanantLine3.val());
        })
        permanantPincode.on('keyup',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentPincode.val(permanantPincode.val());
        })
        permanantState.on('keyup',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentState.val(permanantState.val());
        })
        permanantCountry.on('change',function(){
            let isCheckedSamePresentAddress = isSamePresentAddress.is(":checked");
            if(isCheckedSamePresentAddress)
                presentCountry.val(permanantCountry.val());
        })

        isSamePresentAddress.on('change',function (){
            changePresentAddressFieldData();
        });
        $(document).on('load',changePresentAddressFieldData());
    }

    AxProfileManagementWeb.setConfigs = setConfigs;
})($, (window.AxProfileManagementWeb = window.AxProfileManagementWeb || {}));
