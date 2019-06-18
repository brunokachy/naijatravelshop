package com.naijatravelshop.service.portal.service.impl;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.PortalUserRoleMap;
import com.naijatravelshop.persistence.model.portal.Role;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.portal.PortalUserRepository;
import com.naijatravelshop.persistence.repository.portal.PortalUserRoleMapRepository;
import com.naijatravelshop.persistence.repository.portal.RoleRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.AffiliateAccountDetail;
import com.naijatravelshop.service.portal.pojo.response.UserResponse;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import com.naijatravelshop.web.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Service
public class PortalServiceImpl implements PortalService {

    private PortalUserRepository portalUserRepository;
    private PortalUserRoleMapRepository portalUserRoleMapRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private EmailService emailService;
    private SettingRepository settingRepository;

    private static final Logger log = LoggerFactory.getLogger(PortalServiceImpl.class);


    public PortalServiceImpl(PortalUserRepository portalUserRepository,
                             PasswordEncoder passwordEncoder,
                             PortalUserRoleMapRepository portalUserRoleMapRepository,
                             RoleRepository roleRepository,
                             EmailService emailService,
                             SettingRepository settingRepository) {
        this.portalUserRepository = portalUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.portalUserRoleMapRepository = portalUserRoleMapRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.settingRepository = settingRepository;
    }


    @Override
    @Transactional
    public UserResponse createUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (optionalPortalUser.isPresent()) {
            throw new BadRequestException("User account already exists");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = new PortalUser();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        if (!StringUtils.isEmpty(userDTO.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        user.setPasswordReset(false);
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateCreated(currentTime);
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(currentTime);
        user.setLastPasswordUpdate(currentTime);
        portalUserRepository.save(user);
        Optional<Role> optionalRole = roleRepository.findFirstByNameEquals(RoleType.PORTAL_USER);
        PortalUserRoleMap portalUserRoleMap = new PortalUserRoleMap();
        portalUserRoleMap.setPortalUser(user);
        portalUserRoleMap.setRole(optionalRole.get());
        portalUserRoleMap.setStatus(EntityStatus.ACTIVE);
        portalUserRoleMapRepository.save(portalUserRoleMap);

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setId(user.getId());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setRoles(Collections.singletonList(optionalRole.get().getDisplayName()));

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: New User Account!", "account-creation-template", newAccount, "travel@naijatravelshop.com");

        return userResponse;
    }

    @Override
    @Transactional
    public UserResponse updateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = optionalPortalUser.get();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setLastUpdated(currentTime);
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());

        return userResponse;
    }

    @Override
    public UserResponse deactivateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        PortalUser user = optionalPortalUser.get();
        user.setStatus(EntityStatus.DEACTIVATED);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());

        return userResponse;
    }

    @Override
    public UserResponse reactivateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        PortalUser user = optionalPortalUser.get();
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setId(user.getId());

        return userResponse;
    }

    @Override
    public UserResponse resetPassword(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = Optional.empty();

        if (userDTO.getId() != null) {
            optionalPortalUser = portalUserRepository.findById(userDTO.getId());
        }

        if (!optionalPortalUser.isPresent()) {
            optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
            if (!optionalPortalUser.isPresent()) {
                throw new NotFoundException("User does not exist");
            }
        }
        String newPassword = randomAlphaNumeric(8);
        PortalUser user = optionalPortalUser.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        user.setLastPasswordUpdate(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);
        log.info(newPassword);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        newAccount.put("password", newPassword);
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: Password Reset!", "password-reset-template", newAccount, "travel@naijatravelshop.com");

        return userResponse;
    }

    @Override
    public UserResponse changePassword(PasswordDTO passwordDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(passwordDTO.getUserId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(passwordDTO.getOldPassword());
        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            user.setLastUpdated(currentTime);
            user.setLastPasswordUpdate(currentTime);
            portalUserRepository.save(user);
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setPhoneNumber(user.getPhoneNumber());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setId(user.getId());

            return userResponse;
        } else {
            throw new BadRequestException("Password is incorrect");
        }
    }

    @Override
    public UserResponse login(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User with this email does not exist");
        }
        List<PortalUserRoleMap> roleMaps = portalUserRoleMapRepository.getAllByStatusAndPortalUserEquals(EntityStatus.ACTIVE, optionalPortalUser.get());
        List<String> roles = new ArrayList<>();
        for (PortalUserRoleMap portalUserRoleMap : roleMaps) {
            Optional<Role> role = roleRepository.findById(portalUserRoleMap.getRole().getId());
            if (role.isPresent()) {
                roles.add(role.get().getDisplayName());
            }

        }
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(userDTO.getPassword());

        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setId(user.getId());
            userResponse.setLastName(user.getLastName());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setPhoneNumber(user.getPhoneNumber());
            userResponse.setRoles(roles);
            userResponse.setPasswordReset(user.isPasswordReset());

            return userResponse;
        } else {
            throw new NotFoundException("User with this password does not exist");
        }
    }

    @Override
    public AffiliateAccountDetail getAffiliateAccountDetail() {
        Optional<Setting> secretKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        Optional<Setting> publicKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        Optional<Setting> affiliateCode = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);

        AffiliateAccountDetail affiliateAccountDetail = new AffiliateAccountDetail();
        affiliateAccountDetail.setAffiliateCode(affiliateCode.get().getValue());
        affiliateAccountDetail.setPublicKey(publicKey.get().getValue());
        affiliateAccountDetail.setSecretKey(secretKey.get().getValue());

        return affiliateAccountDetail;
    }

    @Override
    public String getApiBaseUrl() {
        Optional<Setting> baseUrl = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        return baseUrl.get().getValue();
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
