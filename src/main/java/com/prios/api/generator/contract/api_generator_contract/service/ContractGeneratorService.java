package com.prios.api.generator.contract.api_generator_contract.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class ContractGeneratorService {

    private final TemplateEngine templateEngine;

    public ContractGeneratorService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /*public String generateYamlContract(String entityName, String description, boolean embedded) {
        // Créer le contexte Thymeleaf
        Context context = new Context();
        context.setVariable("entityName", entityName);
        context.setVariable("description", description);

        String embeddedProperty = embedded
                ? "          $ref: '#/components/schemas/" + entityName + "Id'"
                : "          type: integer\n          description: \"Identifiant\"";

        context.setVariable("embeddedProperty", embeddedProperty);

        // Utiliser Thymeleaf pour générer le fichier YAML
        return templateEngine.process("contract.yaml", context);
    }*/

    public String generateYamlContract(String entityName, String description) {
        // Modèle de base avec des placeholders pour les valeurs dynamiques
        String template = """
                    openapi: 3.0.1
                    info:
                      title: Interface __entityName__
                      description: Interface pour la gestion des __description__
                      version: 1.0.0
                    tags:
                      - name: __entityName__
                        description: __description__
                    paths:
                      /v1/__entityName__s:
                        get:
                          tags:
                            - __entityName__
                          operationId: getAll
                          summary: "Obtenir les __description__ par société"
                          description: "Récupère une liste de __description__ associée à une société spécifique."
                          parameters:
                            - in: header
                              name: idCompany
                              required: true
                              schema:
                                type: integer
                              description: "Identifiant de la société"
                          responses:
                            '200':
                              description: "Liste des __description__ récupérée avec succès"
                              content:
                                application/json:
                                  schema:
                                    type: array
                                    items:
                                      $ref: '#/components/schemas/__entityName__'

                        post:
                          tags:
                            - __entityName__
                          operationId: postAll
                          summary: "Créer des __description__"
                          description: "Ajoute une liste de __description__"
                          requestBody:
                            required: true
                            content:
                              application/json:
                                schema:
                                  type: array
                                  items:
                                    $ref: '#/components/schemas/__entityName__'
                          responses:
                            '201':
                              description: "Liste des __description__ créée avec succès"
                              content:
                                application/json:
                                  schema:
                                    type: array
                                    items:
                                      $ref: '#/components/schemas/__entityName__'
                            '406':
                              description: Not Acceptable

                        put:
                          tags:
                            - __entityName__
                          operationId: putAll
                          summary: "Mettre à jour la liste des __description__"
                          description: "Met à jour une liste de __description__ existante."
                          requestBody:
                            required: true
                            content:
                              application/json:
                                schema:
                                  type: array
                                  items:
                                    $ref: '#/components/schemas/__entityName__'
                          responses:
                            '202':
                              description: "Liste des __description__ mise à jour avec succès"
                              content:
                                application/json:
                                  schema:
                                    type: array
                                    items:
                                      $ref: '#/components/schemas/__entityName__'
                            '406':
                              description: Not Acceptable

                        delete:
                          tags:
                            - __entityName__
                          operationId: deleteAll
                          summary: "Supprimer la liste des __description__"
                          description: "Supprime une liste de __description__."
                          responses:
                            '204':
                              description: "Liste des __description__ supprimée avec succès"
                              content:
                                application/json:
                                  schema:
                                    type: array
                                    items:
                                      $ref: '#/components/schemas/__entityName__'
                            '406':
                              description: Not Acceptable

                    components:
                      schemas:
                        __entityName__:
                          type: object
                          required:
                            - id
                          properties:
                            id:
                                $ref: '#/components/schemas/__entityName__Id"
                        __entityName__Id:
                          type: object
                          properties:
                            idCompany:
                              type: integer
                              description: "Identifiant de la société"
                """;


        // Remplacer les placeholders par les valeurs dynamiques
        return template
                .replace("__entityName__", entityName)
                .replace("__description__", description);
    }

}
