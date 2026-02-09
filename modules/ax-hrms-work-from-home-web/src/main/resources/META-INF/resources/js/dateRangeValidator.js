/**
 * Simple WFH Date Validation Utility
 * Validates dates according to Work From Home business rules
 * 
 * @author HRMS Development Team
 * @version 2.0 - Simplified
 */

(function(window) {
    'use strict';

    /**
     * Validates WFH start date
     * Rule: Must be within current month or immediately previous month only
     * 
     * @param {string|Date} dateValue - The date to validate
     * @returns {Object} { isValid: boolean, message: string }
     */
    function validateWFHStartDate(dateValue) {
        if (!dateValue) {
            return { isValid: false, message: 'Start date is required' };
        }

        const date = new Date(dateValue);
        if (isNaN(date.getTime())) {
            return { isValid: false, message: 'Invalid date format' };
        }

        const today = new Date();
        const currentYear = today.getFullYear();
        const currentMonth = today.getMonth();

        // Get first day of previous month
        const previousMonthStart = new Date(currentYear, currentMonth - 1, 1);
        previousMonthStart.setHours(0, 0, 0, 0);

        // Get last day of current month
        const currentMonthEnd = new Date(currentYear, currentMonth + 1, 0);
        currentMonthEnd.setHours(23, 59, 59, 999);

        // Reset time for comparison
        const dateOnly = new Date(date);
        dateOnly.setHours(0, 0, 0, 0);

        if (dateOnly < previousMonthStart) {
            return { 
                isValid: false, 
                message: 'Start date cannot be earlier than the previous month' 
            };
        }

        if (dateOnly > currentMonthEnd) {
            return { 
                isValid: false, 
                message: 'Start date cannot be in future months beyond the current month' 
            };
        }

        return { isValid: true, message: '' };
    }

    /**
     * Validates WFH end date
     * Rule: Can be any date up to December 31 of the current year
     * 
     * @param {string|Date} dateValue - The date to validate
     * @returns {Object} { isValid: boolean, message: string }
     */
    function validateWFHEndDate(dateValue) {
        if (!dateValue) {
            return { isValid: false, message: 'End date is required' };
        }

        const date = new Date(dateValue);
        if (isNaN(date.getTime())) {
            return { isValid: false, message: 'Invalid date format' };
        }

        const today = new Date();
        const currentYear = today.getFullYear();

        // Get December 31 of current year
        const currentYearEnd = new Date(currentYear, 11, 31);
        currentYearEnd.setHours(23, 59, 59, 999);

        // Reset time for comparison
        const dateOnly = new Date(date);
        dateOnly.setHours(0, 0, 0, 0);

        if (dateOnly > currentYearEnd) {
            return { 
                isValid: false, 
                message: 'End date cannot be beyond December 31 of the current year' 
            };
        }

        return { isValid: true, message: '' };
    }

    /**
     * Validates both start and end dates together
     * 
     * @param {string|Date} startDate - The start date
     * @param {string|Date} endDate - The end date
     * @returns {Object} { isValid: boolean, errors: Array }
     */
    function validateWFHDates(startDate, endDate) {
        const errors = [];

        const startResult = validateWFHStartDate(startDate);
        if (!startResult.isValid) {
            errors.push({ field: 'startDate', message: startResult.message });
        }

        const endResult = validateWFHEndDate(endDate);
        if (!endResult.isValid) {
            errors.push({ field: 'endDate', message: endResult.message });
        }

        // Additional check: end date must be after start date
        if (startResult.isValid && endResult.isValid) {
            const start = new Date(startDate);
            const end = new Date(endDate);
            if (end < start) {
                errors.push({ 
                    field: 'endDate', 
                    message: 'End date must be after start date' 
                });
            }
        }

        return {
            isValid: errors.length === 0,
            errors: errors
        };
    }

    // Export to global scope
    window.DateRangeValidator = {
        validateWFHStartDate: validateWFHStartDate,
        validateWFHEndDate: validateWFHEndDate,
        validateWFHDates: validateWFHDates
    };

})(window);
