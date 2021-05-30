package com.accountProServer.AccountProServer.infrastructure.repository;

public class DBSchema {
    public static final class CompanyTable {
        public static String TABLE_NAME = "company";

        public static final class Cols {
            public static final String ID = "id";
            public static final String REGISTER_NUMBER = "register_number";
            public static final String SECRETARY_FIRM_ID_FK = "secretary_firm_id_fk";
            public static final String CONTACT_PERSON_ID_FK = "contact_person_id_fk";
            public static final String FORMERLY_KNOWN_AS = "formerly_known_as";
            public static final String NAME = "name";
            public static final String OLD_REGISTER_NO = "old_register_no";
            public static final String ORIGIN_OF_COMPANY = "origin_of_company";
            public static final String STATUS_OF_COMPANY = "status_of_company";
            public static final String TYPE_OF_COMPANY = "type_of_company";
            public static final String ADDRESS = "address";
        }
    }
}
