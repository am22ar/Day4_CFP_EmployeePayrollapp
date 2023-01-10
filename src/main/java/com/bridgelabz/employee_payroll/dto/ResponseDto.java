package com.bridgelabz.employee_payroll.dto;

import com.bridgelabz.employee_payroll.model.EmployeeModel;
import lombok.Data;

//used to hide implementation and provide specific information
public @Data class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
