package com.accountProServer.AccountProServer.Adapter;

import graphql.schema.DataFetchingEnvironment;

interface DataFetcher<T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}