package com.example.demo_swager_3.controller;

import com.example.demo_swager_3.response.ErrorResponse;
import com.example.demo_swager_3.service.EmpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EmpService empService;

    @GetMapping("")
    public String msg() {
        return "Just for testing";
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmps() {
        return ResponseEntity.ok(empService.getAllEmp());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an unique emp record", description = "Returns a emp record matched by id")
    @ApiResponse(responseCode = "200", description = "Successful response")
    public ResponseEntity<?> getEmp(
            @Parameter(description = "emp_id",example = "123")
            @PathVariable("id") Integer empId) {
        try{
            return ResponseEntity.ok(empService.findEmpById(empId));
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setApi("/api/id");
            errorResponse.setDate_time(LocalDateTime.now());
            errorResponse.setStatus_code(HttpStatus.NOT_FOUND.toString());
            errorResponse.setError_msg(ex.getLocalizedMessage());
            return ResponseEntity.ok(errorResponse);
        }
    }
}
