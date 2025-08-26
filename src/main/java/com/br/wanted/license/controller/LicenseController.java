package com.br.wanted.license.controller;

import com.br.wanted.license.dto.LicenseRequestDTO;
import com.br.wanted.license.dto.LicenseResponseDTO;
import com.br.wanted.license.model.License;
import com.br.wanted.license.model.Product;
import com.br.wanted.license.model.User;
import com.br.wanted.license.service.LicenseService;
import com.br.wanted.license.service.ProductService;
import com.br.wanted.license.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/licenses")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/validate")
    public ResponseEntity<?> validateLicense(@RequestBody Map<String, String> body) {
        String key = body.get("licenseKey");
        String ip = body.get("ip");
        String port = body.get("port");

        if (key == null || ip == null || port == null) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "message", "Parâmetros licenseKey, ip e port são obrigatórios"
            ));
        }

        boolean valid = licenseService.validateLicense(key, ip, port);
        if (valid) {
            return ResponseEntity.ok(Map.of(
                    "status", "ok",
                    "message", "Licença válida"
            ));
        } else {
            return ResponseEntity.status(403).body(Map.of(
                    "status", "error",
                    "message", "Licença inválida ou já registrada em outro servidor"
            ));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<LicenseResponseDTO> createLicense(@RequestBody LicenseRequestDTO request) {
        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Product product = productService.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        License license = licenseService.createLicense(user, product, request.getQntLicense());

        LicenseResponseDTO response = new LicenseResponseDTO();
        response.setId(license.getId());
        response.setUserId(user.getId());
        response.setProductId(product.getId());
        response.setLicenseKey(license.getLicenseKey());
        response.setQntLicense(license.getQntLicense());
        response.setLicenseIP(license.getLicenseIP());
        response.setLicensePort(license.getLicensePort());
        response.setCreatedAt(license.getCreatedAt());
        response.setUpdatedAt(license.getUpdatedAt());

        return ResponseEntity.ok(response);
    }
}
