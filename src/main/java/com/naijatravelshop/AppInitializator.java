package com.naijatravelshop;

import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.portal.Role;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.portal.RoleRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.web.constants.ProjectConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Component
public class AppInitializator {

    private RoleRepository roleRepository;
    private SettingRepository settingRepository;

    private static final Logger log = LoggerFactory.getLogger(AppInitializator.class);


    public AppInitializator(RoleRepository roleRepository,
                            SettingRepository settingRepository) {
        this.roleRepository = roleRepository;
        this.settingRepository = settingRepository;
    }

    @PostConstruct
    private void init() {
        log.info("AppInitializator initialization logic ...");
        checkUserRole();
        createFlwCredentials();
    }

    private void checkUserRole() {
        Optional<Role> optionalRole;

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.SUPER_ADMIN);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("Portal Super Admin");
            role.setDisplayName(RoleType.SUPER_ADMIN.getValue());
            role.setName(RoleType.SUPER_ADMIN);
            roleRepository.save(role);
        }

        optionalRole = roleRepository.findFirstByNameEquals(RoleType.PORTAL_USER);
        if (!optionalRole.isPresent()) {
            Role role = new Role();
            role.setDescription("Portal User");
            role.setDisplayName(RoleType.PORTAL_USER.getValue());
            role.setName(RoleType.PORTAL_USER);
            roleRepository.save(role);
        }
    }

    @Transactional
    void createFlwCredentials() {
        Optional<Setting> optionalSetting;

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
            setting.setName(ProjectConstant.FLW_PAYMENT_VERIFY_ENDPOINT);
            setting.setValue("https://ravesandboxapi.flutterwave.com/flwv3-pug/getpaidx/api/v2/verify");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_PUBLIC_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_PUBLIC_KEY);
            setting.setName(ProjectConstant.FLW_PUBLIC_KEY);
            setting.setValue("FLWPUBK_TEST-8d17767a4a8db582163c16bb16ec4a75-X");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.FLW_SECRET_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.FLW_SECRET_KEY);
            setting.setName(ProjectConstant.FLW_SECRET_KEY);
            setting.setValue("FLWSECK_TEST-701c12446da86736e088cc0683802991-X");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_SECRET_KEY);
            setting.setName(ProjectConstant.AFFILIATE_SECRET_KEY);
            setting.setValue("DBB049465F3F79176658A7F77C05D8A0");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_CODE);
            setting.setName(ProjectConstant.AFFILIATE_CODE);
            setting.setValue("TBAF0000000059");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.AFFILIATE_PUBLIC_KEY);
            setting.setName(ProjectConstant.AFFILIATE_PUBLIC_KEY);
            setting.setValue("D4071DA79A7C79CD9A099A1C36CAEAB6");
            settingRepository.save(setting);
        }

        optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        if (!optionalSetting.isPresent()) {
            Setting setting = new Setting();
            setting.setDescription(ProjectConstant.API_BASE_URL);
            setting.setName(ProjectConstant.API_BASE_URL);
            setting.setValue("http://139.162.210.123:8086/v1/");
            settingRepository.save(setting);
        }
    }


}
