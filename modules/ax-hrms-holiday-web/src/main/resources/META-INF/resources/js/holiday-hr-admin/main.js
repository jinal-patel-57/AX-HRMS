(function ($, AxHrmsHolidayHrAdminWebPortlet) {

    'use strict';

    let namespace;


    $(document).ready(function () {

    function applyGenericDateRestriction(element) {
        if (!element) return;

        const nextYear = new Date().getFullYear() + 1;
        const pastYear = new Date().getFullYear() - 2;
        const maxDate = `${nextYear}-12-31`;
        const minDate = `${pastYear}-01-01`;

        element.setAttribute('min', minDate);
        element.setAttribute('max', maxDate);

        element.addEventListener('input', function () {
            const val = this.value;
            if (val) {
                const parts = val.split('-');
                if (parts[0] && parts[0].length > 4) {
                    parts[0] = parts[0].substring(0, 4);
                    this.value = parts.join('-');
                }
            }
        });
    }

    const holidayDate = document.getElementById("holidayDate");
                    if (holidayDate) {
                        applyGenericDateRestriction(holidayDate);
                    }



        if (!$.validator || !$.validator.addMethod) {
            console.error("jQuery Validation plugin not loaded");
            return;
        }

        if (!$.validator.methods.validHolidayName) {
            $.validator.addMethod("validHolidayName", function (value, element) {
                return this.optional(element) ||
                    /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value.trim());
            }, "Only alphabets, spaces, & and - are allowed");
        }

        if (!$.validator.methods.validHolidayDesc) {
            $.validator.addMethod("validHolidayDesc", function (value, element) {
                return this.optional(element) ||
                    /^[A-Za-z0-9\s.,()-]+$/.test(value.trim());
            }, "Invalid characters in description");
        }
      $.validator.addMethod("noWeekend", function (value) {
          if (!value) return true;

          var date = new Date(value);
          var day = date.getDay();

          return day !== 0 && day !== 6;
      }, "Saturday and Sunday are not allowed");





      if (!$.validator.methods.validHolidayDate) {
       $.validator.addMethod("validHolidayDate", function (value) {
           if (!value) return true;

           var selectedYear = new Date(value).getFullYear();
           var currentYear = new Date().getFullYear();

           return selectedYear >= currentYear - 2 &&
                  selectedYear <= currentYear + 1;
       }, function () {
           var y = new Date().getFullYear();
           return "Please select a date between " + (y - 2) + " and " + (y + 1);
       });


      }


        console.log("Holiday validators registered");
    });


    function setConfigsForValidation(config) {

        namespace = config.namespace;
        const $form = $("#addEditHolidayHrAdmin");

        if (!$form.length) {
            return;
        }


        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({
            ignore: [],

            rules: {
                [namespace + "holidayName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validHolidayName: true
                },
                [namespace + "holidayDate"]: {
                    required: true,
                    validHolidayDate: true,
                    noWeekend: true
                },
                [namespace + "holidayDesc"]: {

                    minlength: 0,
                    maxlength: 70,
                    validHolidayDesc: true
                },
                [namespace + "isFloater"]: {
                    required: true
                }
            },

            messages: {
                [namespace + "holidayName"]: {
                    required: "Enter holiday name"
                },
                [namespace + "holidayDate"]: {
                    required: "Select holiday date"
                },
                [namespace + "holidayDesc"]: {
                    required: "Enter holiday description"
                },
                [namespace + "isFloater"]: {
                    required: "Please select floater option"
                }
            },

            errorElement: "small",

            errorPlacement: function (error, element) {
                error.addClass("text-danger");
                if (element.attr("type") === "radio") {
                    error.insertAfter(element.closest(".form-group"));
                } else {
                    error.insertAfter(element);
                }
            },

            highlight: function (element) {
                $(element).addClass("is-invalid");
            },

            unhighlight: function (element) {
                $(element).removeClass("is-invalid");
            },


             onkeyup: function (element) {
                    $(element).valid();
                },
            onfocusout: function (element) {
                $(element).valid();
            },

            submitHandler: function (form) {
                form.submit();
            }
        });
    }


    function setConfigsForDeleteHoliday(config) {

        let url = config.deleteUrl;
        url = url.replace('SELECTED_YEAR', config.selectedYear);

        if (confirm("Are you sure you want to delete this holiday?")) {
            window.location.href = url;
        }
    }


    function setConfigsForRenderHolidayWithYear(config) {

        let url = config.renderUrl;
        url = url.replace('SELECTED_YEAR', config.selectedYear);

        window.location.href = url;
    }


    AxHrmsHolidayHrAdminWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxHrmsHolidayHrAdminWebPortlet.setConfigsForDeleteHoliday =
        setConfigsForDeleteHoliday;

    AxHrmsHolidayHrAdminWebPortlet.setConfigsForRenderHolidayWithYear =
        setConfigsForRenderHolidayWithYear;

})(
    jQuery,
    window.AxHrmsHolidayHrAdminWebPortlet =
        window.AxHrmsHolidayHrAdminWebPortlet || {}
);
