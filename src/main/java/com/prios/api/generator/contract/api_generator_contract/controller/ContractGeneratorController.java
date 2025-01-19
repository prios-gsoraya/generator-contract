package com.prios.api.generator.contract.api_generator_contract.controller;

import com.prios.api.generator.contract.api_generator_contract.exception.ApiException;
import com.prios.api.generator.contract.api_generator_contract.service.ContractGeneratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ContractGeneratorController {

    private final ContractGeneratorService contractGeneratorService;

    @Value("${base.directory}")
    private String baseDirectory;

    public ContractGeneratorController(ContractGeneratorService contractGeneratorService) {
        this.contractGeneratorService = contractGeneratorService;
    }

    @GetMapping("/generateContract")
    public String showContractForm() {
        return "contractForm";
    }

    @PostMapping("/generateContract")
    public String generateContract(
            @RequestParam String entityName,
            @RequestParam String description,
            Model model) {

        try {
            String yamlContract = contractGeneratorService.generateYamlContract(entityName, description);

            // Conversion du nom de l'entité au format snake_case
            String snakeCaseName = toSnakeCase(entityName);

            // Construction du chemin du fichier
            String subDirectoryPath = snakeCaseName.replace("_", "/");
            Path folderPath = Paths.get(baseDirectory, subDirectoryPath);
            Files.createDirectories(folderPath);

            String fileName = snakeCaseName + ".yaml";
            Path filePath = folderPath.resolve(fileName);

            // Écriture du fichier
            Files.write(filePath, yamlContract.getBytes());

            // Encodage du chemin pour l'URL
            String encodedFilePath = URLEncoder.encode(filePath.toString(), StandardCharsets.UTF_8);


            model.addAttribute("downloadLink", "/download?filePath=" + encodedFilePath);
            model.addAttribute("entityName", entityName);
            model.addAttribute("yamlContract", yamlContract);

            return "contractGenerated";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue : " + e.getMessage());
            return "contractError";
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String filePath) {
        try {
            String decodedPath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);
            Path path = Paths.get(decodedPath);
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new ApiException("Le fichier demandé n'existe pas ou n'est pas lisible.");
            }
        } catch (Exception e) {
            throw new ApiException("Erreur lors du téléchargement : " + e.getMessage());
        }
    }

    private String toSnakeCase(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}
