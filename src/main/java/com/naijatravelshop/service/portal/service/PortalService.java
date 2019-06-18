package com.naijatravelshop.service.portal.service;

import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.AffiliateAccountDetail;
import com.naijatravelshop.service.portal.pojo.response.UserResponse;

public interface PortalService {

    UserResponse createUserAccount(UserDTO userDTO);

    UserResponse updateUserAccount(UserDTO userDTO);

    UserResponse deactivateUserAccount(UserDTO userDTO);

    UserResponse reactivateUserAccount(UserDTO userDTO);

    UserResponse resetPassword(UserDTO userDTO);

    UserResponse changePassword(PasswordDTO passwordDTO);

    UserResponse login(UserDTO userDTO);

    AffiliateAccountDetail getAffiliateAccountDetail();

    String getApiBaseUrl();
}
