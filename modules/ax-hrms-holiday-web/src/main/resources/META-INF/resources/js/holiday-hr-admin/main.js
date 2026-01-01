(function ($, AxHrmsHolidayHrAdminWebPortlet) {

    'use strict';

    let namespace;


    $(document).ready(function () {

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
        $.validator.addMethod("noWeekend", function (value, element) {

            if (!value) return true;

            var parts = value.split("-");
            if (parts.length !== 3) return true;

            var date = new Date(
                parseInt(parts[0], 10),
                parseInt(parts[1], 10) - 1,
                parseInt(parts[2], 10)
            );

            if (isNaN(date.getTime())) return true;

            var day = date.getDay();
            return day !== 0 && day !== 6;

        }, "Saturday and Sunday are not allowed");



      if (!$.validator.methods.validHolidayDate) {
          $.validator.addMethod(
              "validHolidayDate",
              function (value, element) {
                  if (!value) return true;

                  let selectedYear = new Date(value).getFullYear();
                  let currentYear = new Date().getFullYear();

                  return selectedYear >= currentYear - 2 &&
                         selectedYear <= currentYear + 1;
              },
              function () {
                  let currentYear = new Date().getFullYear();
                  return (
                      "Please select a date between " +
                      (currentYear - 2) +
                      " and " +
                      (currentYear + 1) +
                      "."
                  );
              }
          );
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
