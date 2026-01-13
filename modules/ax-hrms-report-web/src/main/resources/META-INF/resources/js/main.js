function teamIdMultiSelect() {

    const STORAGE_KEY = 'selectedOptions';
    const mySelect = $('#employeeIds');
    const selectedOptionsContainer = $('#selectedOptionsContainer');

    function getSelectedValues() {
        const data = localStorage.getItem(STORAGE_KEY);
        if (!data) return [];
        try {
            const parsed = JSON.parse(data);
            return Array.isArray(parsed) ? parsed : [];
        } catch {
            return [];
        }
    }

    function setSelectedValues(values) {
        if (!Array.isArray(values)) values = [];
        localStorage.setItem(STORAGE_KEY, JSON.stringify(values));
    }

    function setTeamIdInParams() {
        const teamIdElement = document.getElementById(namespace + "employeeId");
        if (teamIdElement) {
            teamIdElement.value = getSelectedValues().join(',');
        }
    }

    function renderSelectedOptions() {
        selectedOptionsContainer.empty();
        const selectedValues = getSelectedValues();

        selectedValues.forEach(value => {
            const text = mySelect.find(`option[value="${value}"]`).text();

            const selectedOptionElement = $('<div>').addClass('selected-option');
            const span = $('<span>').text(text);
            const closeButton = $('<button>').text('x');

            closeButton.on('click', function () {
                const updatedValues = getSelectedValues().filter(v => v !== value);
                setSelectedValues(updatedValues);
                mySelect.val(updatedValues).trigger('change.select2');
                renderSelectedOptions();
                setTeamIdInParams();
            });

            selectedOptionElement.append(span, closeButton);
            selectedOptionsContainer.append(selectedOptionElement);
        });
    }

    mySelect.on('change', function () {
        const selectedValues = $(this).val() || [];
        setSelectedValues(selectedValues);
        renderSelectedOptions();
        setTeamIdInParams();
    });

    renderSelectedOptions();
    setTeamIdInParams();
}

$(document).ready(function () {
    teamIdMultiSelect();
});
