/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.connectors.integration.jdbc.transfer.requests;

import org.odpi.openmetadata.accessservices.datamanager.metadataelements.*;
import org.odpi.openmetadata.accessservices.datamanager.properties.*;
import org.odpi.openmetadata.frameworks.auditlog.AuditLog;
import org.odpi.openmetadata.integrationservices.database.connector.DatabaseIntegratorContext;

import java.util.List;
import java.util.Optional;

/**
 * Utility class that delegates requests to designated access service
 */
public class Omas {

    private final DatabaseIntegratorContext databaseIntegratorContext;
    private final AuditLog auditLog;

    public Omas(DatabaseIntegratorContext databaseIntegratorContext, AuditLog auditLog){
        this.databaseIntegratorContext = databaseIntegratorContext;
        this.auditLog = auditLog;
    }

    /**
     * Get table
     *
     * @param tableGuid table guid
     *
     * @return table
     */
    public Optional<DatabaseTableElement> getTable(String tableGuid){
        return new OmasGetTable(databaseIntegratorContext, auditLog).apply(tableGuid);
    }

    /**
     * Get schemas of database
     *
     * @param databaseGuid database guid
     *
     * @return schemas
     */
    public List<DatabaseSchemaElement> getSchemas(String databaseGuid){
        return new OmasGetSchemas(databaseIntegratorContext, auditLog).apply(databaseGuid);
    }

    /**
     * Get tables of schema
     *
     * @param assetGuid database or schema guid
     *
     * @return tables
     */
    public List<DatabaseTableElement> getTables(String assetGuid){
        return new OmasGetTables(databaseIntegratorContext, auditLog).apply(assetGuid);
    }

    /**
     * Get columns of table
     *
     * @param tableGuid table guid
     *
     * @return columns
     */
    public List<DatabaseColumnElement> getColumns(String tableGuid){
        return new OmasGetColumns(databaseIntegratorContext, auditLog).apply(tableGuid);
    }

    /**
     * Create endpoint
     *
     * @param newEndpointProperties properties
     *
     * @return guid
     */
    public Optional<String> createEndpoint(EndpointProperties newEndpointProperties){
        return new OmasCreateEndpoint(databaseIntegratorContext, auditLog).apply(newEndpointProperties);
    }

    /**
     * Create connection
     *
     * @param newConnectionProperties properties
     *
     * @return guid
     */
    public Optional<String> createConnection(ConnectionProperties newConnectionProperties){
        return new OmasCreateConnection(databaseIntegratorContext, auditLog).apply(newConnectionProperties);
    }

    /**
     * Create database
     *
     * @param newDatabaseProperties properties
     *
     * @return guid
     */
    public Optional<String> createDatabase(DatabaseProperties newDatabaseProperties){
        return new OmasCreateDatabase(databaseIntegratorContext, auditLog).apply(newDatabaseProperties);
    }

    /**
     * Create schema in database
     *
     * @param databaseGuid database guid
     * @param newSchemaProperties properties
     *
     * @return guid
     */
    public Optional<String> createSchema(String databaseGuid, DatabaseSchemaProperties newSchemaProperties){
        return new OmasCreateSchema(databaseIntegratorContext, auditLog).apply(databaseGuid, newSchemaProperties);
    }

    /**
     * Create table in schema
     *
     * @param schemaGuid schema guid
     * @param newTableProperties properties
     *
     * @return guid
     */
    public Optional<String> createTable(String schemaGuid, DatabaseTableProperties newTableProperties){
        return new OmasCreateTable(databaseIntegratorContext, auditLog).apply(schemaGuid, newTableProperties);
    }

    /**
     * Create column in table
     *
     * @param tableGuid table guid
     * @param newColumnProperties properties
     *
     * @return guid
     */
    public Optional<String> createColumn(String tableGuid, DatabaseColumnProperties newColumnProperties){
        return new OmasCreateColumn(databaseIntegratorContext, auditLog).apply(tableGuid, newColumnProperties);
    }

    /**
     * Remove schema
     *
     * @param schemaElement schema
     */
    public void removeSchema(DatabaseSchemaElement schemaElement) {
        new OmasRemoveSchema(databaseIntegratorContext, auditLog).accept(schemaElement);
    }

    /**
     * Remove table
     *
     * @param tableElement table
     */
    public void removeTable(DatabaseTableElement tableElement) {
        new OmasRemoveTable(databaseIntegratorContext, auditLog).accept(tableElement);
    }

    /**
     * Remove column
     *
     * @param columnElement column
     */
    public void removeColumn(DatabaseColumnElement columnElement) {
        new OmasRemoveColumn(databaseIntegratorContext, auditLog).accept(columnElement);
    }

    /**
     * Update database
     *
     * @param databaseGuid guid
     * @param databaseProperties properties
     */
    public void updateDatabase(String databaseGuid, DatabaseProperties databaseProperties){
        new OmasUpdateDatabase(databaseIntegratorContext, auditLog).accept(databaseGuid, databaseProperties);
    }

    /**
     * Update schema
     *
     * @param schemaGuid guid
     * @param schemaProperties properties
     */
    public void updateSchema(String schemaGuid, DatabaseSchemaProperties schemaProperties){
        new OmasUpdateSchema(databaseIntegratorContext, auditLog).accept(schemaGuid, schemaProperties);
    }

    /**
     * Update table
     *
     * @param tableGuid guid
     * @param tableProperties properties
     */
    public void updateTable(String tableGuid, DatabaseTableProperties tableProperties){
        new OmasUpdateTable(databaseIntegratorContext, auditLog).accept(tableGuid, tableProperties);
    }

    /**
     * Update column
     *
     * @param columnGuid guid
     * @param columnProperties properties
     */
    public void updateColumn(String columnGuid, DatabaseColumnProperties columnProperties){
        new OmasUpdateColumn(databaseIntegratorContext, auditLog).accept(columnGuid, columnProperties);
    }

    /**
     * Set primary key
     *
     * @param columnGuid guid
     * @param primaryKeyProperties properties
     */
    public void setPrimaryKey(String columnGuid, DatabasePrimaryKeyProperties primaryKeyProperties) {
        new OmasSetPrimaryKey(databaseIntegratorContext, auditLog).accept(columnGuid, primaryKeyProperties);
    }

    /**
     * Set foreign key
     *
     * @param primaryKeyColumnGuid guid
     * @param foreignKeyColumnGuid guid
     * @param foreignKeyProperties properties
     */
    public void setForeignKey(String primaryKeyColumnGuid, String foreignKeyColumnGuid, DatabaseForeignKeyProperties foreignKeyProperties) {
        new OmasSetForeignKey(databaseIntegratorContext, auditLog).accept(primaryKeyColumnGuid, foreignKeyColumnGuid, foreignKeyProperties);
    }

    /**
     * Get databases
     *
     * @param databaseQualifiedName qualified name
     *
     * @return databases
     */
    public List<DatabaseElement> getDatabasesByName(String databaseQualifiedName){
        return new OmasGetDatabasesByName(databaseIntegratorContext, auditLog).apply(databaseQualifiedName);
    }

    /**
     * Get connector types by name
     *
     * @param connectorTypeQualifiedName qualified name
     *
     * @return connector types
     */
    public List<ConnectorTypeElement> getConnectorTypesByName(String connectorTypeQualifiedName){
        return new OmasGetConnectorTypesByName(databaseIntegratorContext, auditLog).apply(connectorTypeQualifiedName);
    }

    /**
     * Get connection by name
     *
     * @param connectionQualifiedName qualified name
     *
     * @return connections
     */
    public List<ConnectionElement> getConnectionsByName(String connectionQualifiedName){
        return new OmasGetConnectionsByName(databaseIntegratorContext, auditLog).apply(connectionQualifiedName);
    }

    /**
     * Find endpoints
     *
     * @param searchBy criteria
     *
     * @return endpoints
     */
    public List<EndpointElement> findEndpoints(String searchBy){
        return new OmasFindEndpoints(databaseIntegratorContext, auditLog).apply(searchBy);
    }

    /**
     * Find columns
     *
     * @param searchBy criteria
     *
     * @return columns
     */
    public List<DatabaseColumnElement> findDatabaseColumns(String searchBy){
        return new OmasFindDatabaseColumns(databaseIntegratorContext, auditLog).apply(searchBy);
    }

    /**
     * Setup connector type
     *
     * @param connectionGuid guid
     * @param connectorTypeGuid guid
     */
    public void setupConnectorType(String connectionGuid, String connectorTypeGuid){
        new OmasSetupConnectorType(databaseIntegratorContext, auditLog).accept(connectionGuid, connectorTypeGuid);
    }

    /**
     * Setup asset connection
     *
     * @param assetGuid guid
     * @param assetSummary summary
     * @param connectionGuid guid
     */
    public void setupAssetConnection(String assetGuid, String assetSummary, String connectionGuid){
        new OmasSetupAssetConnection(databaseIntegratorContext, auditLog).accept(assetGuid, assetSummary, connectionGuid);
    }

    /**
     * Setup endpoint
     *
     * @param connectionGuid guid
     * @param endpointGuid guid
     */
    public void setupEndpoint(String connectionGuid, String endpointGuid){
        new OmasSetupEndpoint(databaseIntegratorContext, auditLog).accept(connectionGuid, endpointGuid);
    }

}
