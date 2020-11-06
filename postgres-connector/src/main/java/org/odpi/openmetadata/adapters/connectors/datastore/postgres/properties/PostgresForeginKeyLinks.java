/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adapters.connectors.datastore.postgres.properties;

public class PostgresForeginKeyLinks {

    private final String table_schema;
    private final String constraint_name;
    private final String table_name;
    private final String column_name;
    private final String foreign_table_schema;
    private final String foreign_table_name;
    private final String foreign_column_name;

    public PostgresForeginKeyLinks(String table_schema, String constraint_name, String table_name, String column_name, String foreign_table_schema, String foreign_table_name, String foreign_column_name)
    {
        this.table_schema = table_schema;
        this.constraint_name = constraint_name;
        this.table_name = table_name;
        this.column_name = column_name;
        this.foreign_table_schema = foreign_table_schema;
        this.foreign_table_name = foreign_table_name;
        this.foreign_column_name = foreign_column_name;
    }

    public String getImportedColumnQualifiedName()
    {
        return table_schema +"." +
                table_name + "." +
                column_name ;
    }

    public String getExportedColumnQualifiedName()
    {
        return foreign_table_schema+"." +
                foreign_table_name + "." +
                foreign_column_name;
    }
}
