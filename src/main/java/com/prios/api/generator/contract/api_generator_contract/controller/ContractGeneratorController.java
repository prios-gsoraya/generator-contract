package com.prios.api.generator.contract.api_generator_contract.controller;

import com.prios.api.generator.contract.api_generator_contract.service.ContractGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContractGeneratorController {

    private final ContractGeneratorService contractGeneratorService;

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

            model.addAttribute("entityName", entityName);
            model.addAttribute("yamlContract", yamlContract);

            return "contractGenerated";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue : " + e.getMessage());
            return "contractError";
        }
    }
}
