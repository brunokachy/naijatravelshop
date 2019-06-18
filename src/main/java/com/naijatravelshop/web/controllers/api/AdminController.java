package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.AffiliateAccountDetail;
import com.naijatravelshop.service.portal.pojo.response.UserResponse;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bruno on
 * 08/05/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private PortalService portalService;

    public AdminController(PortalService portalService) {
        this.portalService = portalService;
    }

    @ApiOperation(value = "Create Portal User Account")
    @PostMapping(value = {"/create_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> createAccount(@RequestBody UserDTO user) {
        log.info("CREATE ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.createUserAccount(user);
        apiResponse.setMessage("User Account Created successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Portal User Account")
    @PostMapping(value = {"/update_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> updateAccount(@RequestBody UserDTO user) {
        log.info("UPDATE ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.updateUserAccount(user);
        apiResponse.setMessage("User Account Updated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Deactivate Portal User Account")
    @PostMapping(value = {"/deactivate_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> deactivateUserAccount(@RequestBody UserDTO user) {
        log.info("DEACTIVATE USER ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.deactivateUserAccount(user);
        apiResponse.setMessage("User Account Deactivated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Re-activate Portal User Account")
    @PostMapping(value = {"/reactivate_account"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> reactivateUserAccount(@RequestBody UserDTO user) {
        log.info("REACTIVATE USER ACCOUNT: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.reactivateUserAccount(user);
        apiResponse.setMessage("User Account Re-activated successfully");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Reset Portal User Password")
    @PostMapping(value = {"/reset_user_password"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> resetPassword(@RequestBody UserDTO user) {
        log.info("RESET USER PASSWORD: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.resetPassword(user);
        apiResponse.setMessage("User Account Password Reset successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Portal User Login")
    @PostMapping(value = {"/login"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> login(@RequestBody UserDTO user) {
        log.info("PORTAL USER LOGIN: {}", user.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.login(user);
        apiResponse.setMessage("User Account Authentication successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Change Portal User Password")
    @PostMapping(value = {"/change_password"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserResponse>> changePassword(@RequestBody PasswordDTO passwordDTO) {
        log.info("PORTAL USER CHANGE PASSWORD: {}", passwordDTO.toString());
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        UserResponse userResponse = portalService.changePassword(passwordDTO);
        apiResponse.setMessage("User Account Password changed successful");
        apiResponse.setData(userResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Affiliate Account")
    @GetMapping(value = {"/get_affiliate_account_details"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<AffiliateAccountDetail>> getAffiliateAccountDetails() {
        ApiResponse<AffiliateAccountDetail> apiResponse = new ApiResponse<>();
        AffiliateAccountDetail affiliateAccountDetail = portalService.getAffiliateAccountDetail();
        apiResponse.setMessage("Affiliate Account Details retrieved successfully");
        apiResponse.setData(affiliateAccountDetail);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch Base URL")
    @GetMapping(value = {"/get_base_url"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> getBaseUrl() {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        String baseUrl = portalService.getApiBaseUrl();
        apiResponse.setMessage("Base URL retrieved successfully");
        apiResponse.setData(baseUrl);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
