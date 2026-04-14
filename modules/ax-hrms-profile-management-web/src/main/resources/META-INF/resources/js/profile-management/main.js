(function ($, AxProfileManagementWeb) {

    AxProfileManagementWeb.setConfigs = function (config) {

        const ns = config.namespace;
        const form = $("#profileForm");

     function allowOnlySixDigitPincode(input) {
                if (!input) return;

                // Clean pre-filled value (update case)
                input.value = input.value.replace(/\D/g, "").substring(0, 6);

                input.addEventListener("input", function () {
                    this.value = this.value.replace(/\D/g, "").substring(0, 6);
                });
            }
        /* ================= PINCODE INPUT RESTRICTION ================= */

        // Permanent
        allowOnlySixDigitPincode(
            document.getElementById(ns + "permanantPincode")
        );

        // Present
        allowOnlySixDigitPincode(
            document.getElementById(ns + "presentPincode")
        );

        // Nominee
        allowOnlySixDigitPincode(
            document.getElementById(ns + "nomineePincode")
        );


        /* ================= SAME AS PERMANENT ================= */
        const sameCheckbox = $("#" + ns + "isSamePresentAddress");

        const permanent = {
            line1: $("#" + ns + "permanantLine1"),
            state: $("#" + ns + "permanantState"),
            city: $("#" + ns + "permanentCity"),
            pincode: $("#" + ns + "permanantPincode"),
            country: $("#" + ns + "permanantCountry")
        };

        const present = {
            line1: $("#" + ns + "presentLine1"),
            state: $("#" + ns + "presentState"),
            city: $("#" + ns + "presentCity"),
            pincode: $("#" + ns + "presentPincode"),
            country: $("#" + ns + "presentCountry")
        };



        function copyPermanentToPresent() {
            Object.keys(present).forEach(k => present[k].val(permanent[k].val()));
        }

        function togglePresent(disabled) {
            Object.values(present).forEach(el => el.prop("disabled", disabled));
        }




        sameCheckbox.on("change", function () {
            if (this.checked) {
                copyPermanentToPresent();
                togglePresent(true);
            } else {
                togglePresent(false);
            }
        });

        if (sameCheckbox.is(":checked")) {
            copyPermanentToPresent();
            togglePresent(true);
        }

        const addressProofSection = $("#addressProofSection");

        function toggleAddressProofSection() {
            if (sameCheckbox.is(":checked")) {
                addressProofSection.hide();
            } else {
                addressProofSection.show();
            }
        }

        toggleAddressProofSection();

        sameCheckbox.on("change", function () {
            toggleAddressProofSection();
        });

        /* ================= AUTO SYNC WHEN SAME AS PERMANENT ================= */

        // whenever permanent address changes AND checkbox is checked
        Object.values(permanent).forEach(function (el) {
            el.on("input change", function () {
                if (sameCheckbox.is(":checked")) {
                    copyPermanentToPresent();
                }
            });
        });


        /* ================= CUSTOM VALIDATORS ================= */
        $.validator.addMethod("lettersOnly", v => /^[A-Za-z]+( [A-Za-z]+)*$/.test(v));
        $.validator.addMethod("validMobile10", v => /^\d{10}$/.test(v));
        $.validator.addMethod("validPincode", v => /^\d{6}$/.test(v));
        $.validator.addMethod("alphaNumericAddress", v => /^[A-Za-z0-9\s,.-]+$/.test(v));
        $.validator.addMethod("notFutureDate", v => new Date(v) <= new Date());

        /* ================= FORM VALIDATION ================= */
        form.validate({
            ignore: [],
//            errorClass: "is-invalid",
            errorClass: "invalid",
//            validClass: "is-valid",
            validClass: "valid",
            errorElement: "div",

            errorPlacement: function (error, element) {
                error.addClass("invalid-feedback");
                element.closest(".mb-3").append(error);
            },

            rules: {
                [ns+"firstName"]: { required:true, lettersOnly:true },
                [ns+"lastName"]: { required:true, lettersOnly:true },
                [ns+"personalEmail"]: { required:true, email:true },
                [ns+"mobileNumber"]: { required:true, validMobile10:true },

                [ns+"permanantLine1"]: { required:true, alphaNumericAddress:true },
                [ns+"permanantState"]: { required:true, lettersOnly:true },
                [ns+"permanentCity"]: { required:true, lettersOnly:true },
                [ns+"permanantPincode"]: { required:true, validPincode:true },
                [ns+"permanantCountry"]: { required:true },

                [ns+"presentLine1"]: { required:true, alphaNumericAddress:true },
                [ns+"presentState"]: { required:true, lettersOnly:true },
                [ns+"presentCity"]: { required:true, lettersOnly:true },
                [ns+"presentPincode"]: { required:true, validPincode:true },
                [ns+"presentCountry"]: { required:true },

                [ns+"nomineeFirstName"]: { required:true, lettersOnly:true },
                [ns+"nomineeLastName"]: { required:true, lettersOnly:true },
                [ns+"nomineeContact"]: { required:true, validMobile10:true },
                [ns+"relationshipWithNominee"]: { required:true, lettersOnly:true },
                [ns+"nomineeDob"]: { required:true, notFutureDate:true },

                [ns+"nomineeLine1"]: { required:true, alphaNumericAddress:true },
                [ns+"nomineeCity"]: { required:true, lettersOnly:true },
                [ns+"nomineeState"]: { required:true, lettersOnly:true },
                [ns+"nomineeCountry"]: { required:true },
                [ns+"nomineePincode"]: { required:true, validPincode:true }
            },

            /* ================= VALIDATION MESSAGES ================= */
            messages: {
                [ns+"firstName"]: {
                    required: "First name is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"lastName"]: {
                    required: "Last name is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"personalEmail"]: {
                    required: "Email is required",
                    email: "Enter a valid email address"
                },
                [ns+"mobileNumber"]: {
                    required: "Mobile number is required",
                    validMobile10: "Enter a valid 10-digit mobile number"
                },

                [ns+"permanantLine1"]: {
                    required: "Permanent address line 1 is required",
                    alphaNumericAddress: "Special characters are not allowed"
                },
                [ns+"permanantState"]: {
                    required: "Permanent state is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"permanentCity"]: {
                    required: "Permanent city is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"permanantPincode"]: {
                    required: "Permanent pincode is required",
                    validPincode: "Enter a valid 6-digit pincode"
                },
                [ns+"permanantCountry"]: {
                    required: "Please select permanent country"
                },

                [ns+"presentLine1"]: {
                    required: "Present address line 1 is required",
                    alphaNumericAddress: "Special characters are not allowed"
                },
                [ns+"presentState"]: {
                    required: "Present state is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"presentCity"]: {
                    required: "Present city is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"presentPincode"]: {
                    required: "Present pincode is required",
                    validPincode: "Enter a valid 6-digit pincode"
                },
                [ns+"presentCountry"]: {
                    required: "Please select present country"
                },

                [ns+"nomineeFirstName"]: {
                    required: "Nominee first name is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"nomineeLastName"]: {
                    required: "Nominee last name is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"nomineeContact"]: {
                    required: "Nominee contact number is required",
                    validMobile10: "Enter a valid 10-digit mobile number"
                },
                [ns+"relationshipWithNominee"]: {
                    required: "Relationship is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"nomineeDob"]: {
                    required: "Nominee date of birth is required",
                    notFutureDate: "Future date is not allowed"
                },

                [ns+"nomineeLine1"]: {
                    required: "Nominee address line 1 is required",
                    alphaNumericAddress: "Special characters are not allowed"
                },
                [ns+"nomineeCity"]: {
                    required: "Nominee city is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"nomineeState"]: {
                    required: "Nominee state is required",
                    lettersOnly: "Only alphabets and space are allowed"
                },
                [ns+"nomineeCountry"]: {
                    required: "Please select nominee country"
                },
                [ns+"nomineePincode"]: {
                    required: "Nominee pincode is required",
                    validPincode: "Enter a valid 6-digit pincode"
                }
            }
        });

        $(document).on("input change", "#profileForm input, #profileForm select", function () {
            form.validate().element(this);
        });
    };

})($, window.AxProfileManagementWeb = window.AxProfileManagementWeb || {});
