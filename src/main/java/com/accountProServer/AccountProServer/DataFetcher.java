package com.accountProServer.AccountProServer;

import graphql.schema.DataFetchingEnvironment;

interface DataFetcher<T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}