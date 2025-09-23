package com.prios.api.generator.contract.api_generator_contract.service;

import org.springframework.stereotype.Service;

@Service
public class ContractGeneratorService {

    public String generateYamlContract(String entityName, String description) {
        // Modèle de base avec des placeholders pour les valeurs dynamiques
        String template = """
                openapi: 3.0.1
                info:
                  title: Interface __entityName__
                  description: Interface pour la gestion des __description__s
                  version: 1.0.0
                tags:
                  - name: __entityName__
                    description: __description__
                paths:
                  /v1/__entityNameLower__s:
                    get:
                      tags:
                        - __entityName__
                      operationId: getAll__entityName__
                      summary: "Obtenir les __description__s par société"
                      description: "Récupère une liste de __description__ associé(e) à une société spécifique."
                      parameters:
                        - in: header
                          name: idCompany
                          required: true
                          schema:
                            type: integer
                          description: "Identifiant de la société"
                        - in: header
                          name: idEstablishment
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de l'établissement"
                        - in: query
                          name: criteriaParam
                          description: "Paramètres dynamiques sous forme de clé=valeur"
                          required: false
                          style: form
                          explode: true
                          schema:
                            type: object
                            additionalProperties: true
                      responses:
                        '200':
                          description: "Liste des __description__s récupéré(e)s avec succès"
                          content:
                            application/json:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                            application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                              
                    post:
                      tags:
                        - __entityName__
                      operationId: postAll__entityName__
                      summary: "Créer des __description__s"
                      description: "Ajoute une liste de __description__s"
                      parameters:
                        - in: header
                          name: idCompany
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de la société"
                        - in: header
                          name: idEstablishment
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de l'établissement"
                      requestBody:
                        required: true
                        content:
                          application/json:
                            schema:
                              type: array
                              items:
                                $ref: '#/components/schemas/__entityName__'
                          application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                      responses:
                        '201':
                          description: "Liste des __description__s créé(e)s avec succès"
                          content:
                            application/json:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                            application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                        '406':
                          description: Not Acceptable
                              
                    put:
                      tags:
                        - __entityName__
                      operationId: putAll__entityName__
                      summary: "Mettre à jour la liste des __description__s"
                      description: "Met à jour une liste des __description__s existant(e)s."
                      parameters:
                        - in: header
                          name: idCompany
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de la société"
                        - in: header
                          name: idEstablishment
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de l'établissement"
                      requestBody:
                        required: true
                        content:
                          application/json:
                            schema:
                              type: array
                              items:
                                $ref: '#/components/schemas/__entityName__'
                          application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                      responses:
                        '202':
                          description: "Liste des __description__s mis(es) à jour avec succès"
                          content:
                            application/json:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                            application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                        '406':
                          description: Not Acceptable
                              
                    delete:
                      tags:
                        - __entityName__
                      operationId: deleteAll__entityName__
                      summary: "Supprimer la liste des __description__s"
                      description: "Supprime une liste des __description__s."
                      parameters:
                        - in: header
                          name: idCompany
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de la société"
                        - in: header
                          name: idEstablishment
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de l'établissement"
                      responses:
                        '204':
                          description: "Liste des __description__s supprimé(e)s avec succès"
                          content:
                            application/json:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                            application/xml:
                              schema:
                                type: array
                                items:
                                  $ref: '#/components/schemas/__entityName__'
                        '406':
                          description: Not Acceptable
                              
                  /v1/__entityNameLower__s/{id}:
                    get:
                      tags:
                        - __entityName__
                      operationId: get__entityName__ById
                      summary: "Obtenir un(e) __description__ par son identifiant"
                      description: "Récupère un(e) __description__ spécifique en fonction de son identifiant."
                      parameters:
                        - in: header
                          name: idCompany
                          required: true
                          schema:
                            type: integer
                          description: "Identifiant de la société"
                        - in: header
                          name: idEstablishment
                          required: false
                          schema:
                            type: integer
                          description: "Identifiant de l'établissement"
                        - in: path
                          name: id
                          required: true
                          schema:
                            type: integer
                          description: "Identifiant"
                      responses:
                        '200':
                          description: "__description__ récupéré(e) avec succès"
                          content:
                            application/json:
                              schema:
                                $ref: '#/components/schemas/__entityName__'
                            application/xml:
                              schema:
                                $ref: '#/components/schemas/__entityName__'
                        '404':
                          description: "__description__ non trouvé(e)"
                              
                components:
                  schemas:
                    __entityName__:
                      type: object
                      required:
                        - id
                      properties:
                        id:
                          $ref: '#/components/schemas/__entityName__Id'
                    __entityName__Id:
                      type: object
                      properties:
                        idCompany:
                          type: integer
                          description: "Identifiant de la société"
                                  """;


        return template
                .replace("__entityName__", entityName)
                .replace("__entityNameLower__", toLowerCaseFirstChar(entityName))
                .replace("__description__", description);
    }

    private static String toLowerCaseFirstChar(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

}
