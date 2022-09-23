package com.soddik.soapservice.endpoint;

import com.soddik.soapservice.dto.*;
import com.soddik.soapservice.mapper.EmployeeMapper;
import com.soddik.soapservice.service.EmployeeService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {
    public static final String NAMESPACE_URI = "http://www.soddik.com/soapservice";
    private final EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByLoginRequest")
    @ResponsePayload
    public GetEmployeeByLoginResponse getEmployeeByLogin(@RequestPayload GetEmployeeByLoginRequest request) {
        GetEmployeeByLoginResponse response = new GetEmployeeByLoginResponse();
        response.setEmployee(EmployeeMapper.toEmployeeDto(employeeService.getEmployeeByLogin(request.getLogin())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
    @ResponsePayload
    public GetAllEmployeesResponse getAllEmployees(@RequestPayload GetAllEmployeesRequest request) {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        response.getEmployees().addAll(employeeService.getAllEmployees().stream()
                .map(EmployeeMapper::toSimpleEmployeeDto)
                .toList());
        return response;
    }

    //works
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployeeRequest(@RequestPayload AddEmployeeRequest request) {
        AddEmployeeResponse addEmployeeResponse = new AddEmployeeResponse();
        Response response = new Response();
        try {
            response.setSuccess(employeeService.addEmployee(EmployeeMapper.toEntity(request)));
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        }
        addEmployeeResponse.setResponse(response);
        return addEmployeeResponse;
    }

    //works
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployeeRequest(@RequestPayload UpdateEmployeeRequest request) {
        UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeResponse();
        Response response = new Response();
        try {
            response.setSuccess(employeeService.updateEmployee(EmployeeMapper.toEntity(request)));
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        }
        updateEmployeeResponse.setResponse(response);
        return updateEmployeeResponse;
    }

    //works
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployeeRequest(@RequestPayload DeleteEmployeeRequest request) {
        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();
        Response response = new Response();
        response.setSuccess(employeeService.deleteEmployee(request.getLogin()));
        deleteEmployeeResponse.setResponse(response);
        return deleteEmployeeResponse;
    }
}
