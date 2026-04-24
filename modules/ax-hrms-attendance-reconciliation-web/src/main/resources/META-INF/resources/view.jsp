<%@ include file="/init.jsp" %>

    <% List<MissingAttendanceRecord> missingList = (List<MissingAttendanceRecord>)
            renderRequest.getPortletSession().getAttribute(
            AxHrmsAttendanceReconciliationWebPortletKeys.MISSING_ATTENDANCE_LIST);

            Integer uploadedCount = (Integer) renderRequest.getPortletSession().getAttribute(
            AxHrmsAttendanceReconciliationWebPortletKeys.UPLOADED_RECORDS_COUNT);

            // Clear the session attributes so they don't persist on subsequent page refreshes
            if (missingList != null) {
            renderRequest.getPortletSession().removeAttribute(
            AxHrmsAttendanceReconciliationWebPortletKeys.MISSING_ATTENDANCE_LIST);
            }
            if (uploadedCount != null) {
            renderRequest.getPortletSession().removeAttribute(
            AxHrmsAttendanceReconciliationWebPortletKeys.UPLOADED_RECORDS_COUNT);
            }

            boolean hasResults = (missingList != null);
            %>

            <div class="attendance-reconciliation-container">

                <!-- Header Section -->
                <div class="ar-header">
                    <div class="ar-header-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 24 24" fill="none"
                            stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                            <polyline points="14 2 14 8 20 8"></polyline>
                            <line x1="16" y1="13" x2="8" y2="13"></line>
                            <line x1="16" y1="17" x2="8" y2="17"></line>
                            <polyline points="10 9 9 9 8 9"></polyline>
                        </svg>
                    </div>
                    <div class="ar-header-text">
                        <h2 class="ar-title">Attendance Reconciliation</h2>
                        <p class="ar-subtitle">Upload and validate employee attendance records</p>
                    </div>
                </div>

                <!-- Error Messages -->
                <liferay-ui:error key="file-required" message="Please select an Excel file to upload." />
                <liferay-ui:error key="invalid-file-type"
                    message="Invalid file type. Please upload a .xlsx or .xls file." />
                <liferay-ui:error key="empty-file"
                    message="The uploaded file contains no records. Please check the file." />
                <liferay-ui:error key="processingError"
                    message="An error occurred while processing the file. Please try again." />

                <!-- Success Messages -->
                <liferay-ui:success key="processingSuccess" message="Attendance file processed successfully!" />
                <liferay-ui:success key="<%= AxHrmsAttendanceReconciliationWebPortletKeys.MAIL_SENT_SUCCESS %>" message="Attendance file processed successfully! You can see the results here and also the mail sent with the excel as well." />

                <!-- Upload Section -->
                <div class="ar-upload-section" id="uploadSection">
                    <div class="ar-upload-card">
                        <div class="ar-upload-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 24 24"
                                fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path>
                                <polyline points="17 8 12 3 7 8"></polyline>
                                <line x1="12" y1="3" x2="12" y2="15"></line>
                            </svg>
                        </div>

                        <h3 class="ar-upload-title">Upload Attendance File</h3>
                        <p class="ar-upload-instruction">Please upload the attendance Excel file (.xlsx or .xls)</p>

                        <portlet:actionURL
                            name="<%= AxHrmsAttendanceReconciliationWebPortletKeys.ACTION_UPLOAD_ATTENDANCE %>"
                            var="uploadURL" />

                        <form action="<%= uploadURL %>" class="ar-upload-form" enctype="multipart/form-data"
                            id="attendanceForm" method="post">

                            <div class="ar-file-input-wrapper">
                                <label class="ar-file-label" for="<portlet:namespace />attendanceFile">
                                    <span class="ar-file-label-icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                            viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                            stroke-linecap="round" stroke-linejoin="round">
                                            <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                            <polyline points="13 2 13 9 20 9"></polyline>
                                        </svg>
                                    </span>
                                    <span class="ar-file-label-text" id="fileLabel">Choose Excel File...</span>
                                </label>
                                <input accept=".xlsx,.xls" class="ar-file-input"
                                    id="<portlet:namespace />attendanceFile" name="<portlet:namespace />attendanceFile"
                                    onchange="updateFileName(this)" type="file" />
                            </div>

                            <div class="ar-file-info">
                                <small>Accepted formats: .xlsx, .xls</small>
                            </div>

                            <div class="ar-skip-codes-wrapper" style="margin-top: 15px; margin-bottom: 20px; text-align: left;">
                                <label for="<portlet:namespace />skipEmployeeCodes" style="display: block; margin-bottom: 5px; font-weight: 500; color: #495057;">Skip Employee Codes (Optional)</label>
                                <input type="text" id="<portlet:namespace />skipEmployeeCodes" name="<portlet:namespace />skipEmployeeCodes" placeholder="e.g. AX2312202, AX202603181, ..." style="width: 100%; padding: 10px; border: 1px solid #ced4da; border-radius: 4px; box-sizing: border-box; font-size: 14px;" />
                                <small style="color: #6c757d; display: block; margin-top: 4px;">Enter comma-separated employee codes to skip during validation.</small>
                            </div>

                            <button class="ar-submit-btn" id="submitBtn" type="submit">
                                <span class="ar-btn-icon">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24"
                                        fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                        stroke-linejoin="round">
                                        <polyline points="16 16 12 12 8 16"></polyline>
                                        <line x1="12" y1="12" x2="12" y2="21"></line>
                                        <path d="M20.39 18.39A5 5 0 0 0 18 9h-1.26A8 8 0 1 0 3 16.3"></path>
                                    </svg>
                                </span>
                                <span>Process Attendance</span>
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Processing Indicator (hidden by default) -->
                <div class="ar-processing-section" id="processingSection" style="display: none;">
                    <div class="ar-processing-card">
                        <div class="ar-spinner"></div>
                        <h3 class="ar-processing-title">Processing...</h3>
                        <p class="ar-processing-text">Your process is running, please wait...</p>
                        <p class="ar-processing-subtext">Validating attendance records against holidays, leaves, and WFH
                            data</p>
                    </div>
                </div>

                <!-- Results Section -->
                <% if (hasResults) { %>
                    <div class="ar-results-section">

                        <!-- Summary Cards -->
                        <div class="ar-summary-row">
                            <div class="ar-summary-card ar-summary-uploaded">
                                <div class="ar-summary-number">
                                    <%= uploadedCount !=null ? uploadedCount : 0 %>
                                </div>
                                <div class="ar-summary-label">Records Uploaded</div>
                            </div>
                            <div class="ar-summary-card ar-summary-issues">
                                <div class="ar-summary-number">
                                    <%= missingList !=null ? missingList.size() : 0 %>
                                </div>
                                <div class="ar-summary-label">Issues Found</div>
                            </div>
                        </div>

                        <% if (missingList !=null && !missingList.isEmpty()) { %>
                            <div class="ar-results-card">
                                <div class="ar-results-header">
                                    <h3 class="ar-results-title">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                            viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                            stroke-linecap="round" stroke-linejoin="round">
                                            <path
                                                d="M10.29 3.86L1.82 18a2 2 0 0 0 1.71 3h16.94a2 2 0 0 0 1.71-3L13.71 3.86a2 2 0 0 0-3.42 0z">
                                            </path>
                                            <line x1="12" y1="9" x2="12" y2="13"></line>
                                            <line x1="12" y1="17" x2="12.01" y2="17"></line>
                                        </svg>
                                        Missing / Invalid Attendance Report
                                    </h3>
                                    <span class="ar-results-count">
                                        <%= missingList.size() %> issue(s)
                                    </span>
                                </div>

                                <div class="ar-table-wrapper">
                                    <table class="ar-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Employee ID</th>
                                                <th>Employee Name</th>
                                                <th>Date</th>
                                                <th>Reason</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% int index=1; for (MissingAttendanceRecord record : missingList) { %>
                                                <tr>
                                                    <td class="ar-cell-index">
                                                        <%= index++ %>
                                                    </td>
                                                    <td class="ar-cell-empid">
                                                        <%= record.getEmployeeCode() != null ? record.getEmployeeCode() : "" %>
                                                    </td>
                                                    <td class="ar-cell-name">
                                                        <%= record.getEmployeeName() %>
                                                    </td>
                                                    <td class="ar-cell-date">
                                                        <%= record.getDate() %>
                                                    </td>
                                                    <td class="ar-cell-reason">
                                                        <span class="ar-reason-badge
                                                <% if (record.getReason().contains(" Missing")) { %>
                                                            ar-badge-missing
                                                            <% } else if (record.getReason().contains("Invalid")) { %>
                                                                ar-badge-invalid
                                                                <% } else { %>
                                                                    ar-badge-warning
                                                                    <% } %>
                                                                        ">
                                                                        <%= record.getReason() %>
                                                        </span>
                                                    </td>
                                                </tr>
                                                <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <% } else { %>
                                <div class="ar-no-issues">
                                    <div class="ar-no-issues-icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48"
                                            viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5"
                                            stroke-linecap="round" stroke-linejoin="round">
                                            <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
                                            <polyline points="22 4 12 14.01 9 11.01"></polyline>
                                        </svg>
                                    </div>
                                    <h3>All Clear!</h3>
                                    <p>No missing or invalid attendance found. All records are valid.</p>
                                </div>
                                <% } %>
                    </div>
                    <% } %>
            </div>

            <script>
                function updateFileName(input) {
                    var label = document.getElementById('fileLabel');
                    if (input.files && input.files.length > 0) {
                        label.textContent = input.files[0].name;
                        label.classList.add('ar-file-selected');
                    } else {
                        label.textContent = 'Choose Excel File...';
                        label.classList.remove('ar-file-selected');
                    }
                }

                document.getElementById('attendanceForm').addEventListener('submit', function (e) {
                    var fileInput = document.getElementById('<portlet:namespace />attendanceFile');
                    if (!fileInput || !fileInput.files || fileInput.files.length === 0) {
                        e.preventDefault();
                        alert('Please select an Excel file before submitting.');
                        return false;
                    }

                    // Show processing indicator, hide upload form
                    document.getElementById('uploadSection').style.display = 'none';
                    document.getElementById('processingSection').style.display = 'block';
                    return true;
                });
            </script>