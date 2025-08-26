package com.br.wanted.license.service;

import com.br.wanted.license.model.License;
import com.br.wanted.license.model.Product;
import com.br.wanted.license.model.User;
import com.br.wanted.license.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public License createLicense(User user, Product product, Integer qntLicense) {
        License license = new License();
        license.setUser(user);
        license.setProduct(product);
        license.setQntLicense(qntLicense != null ? qntLicense : 1);
        license.generateLicenseKey();
        return licenseRepository.save(license);
    }

    public boolean validateLicense(String licenseKey, String ip, String port) {
        Optional<License> optionalLicense = licenseRepository.findByLicenseKey(licenseKey);
        if (optionalLicense.isEmpty()) return false;

        License license = optionalLicense.get();

        if (license.getLicenseIP() != null && license.getLicensePort() != null) {
            return license.getLicenseIP().equals(ip) && license.getLicensePort().equals(port);
        }

        license.setLicenseIP(ip);
        license.setLicensePort(port);
        licenseRepository.save(license);

        return true;
    }

    public Optional<License> findById(Long id) {
        return licenseRepository.findById(id);
    }
}
