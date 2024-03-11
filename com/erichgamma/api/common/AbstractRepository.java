package com.erichgamma.api.common;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {
    public abstract Map<String, ?> save(Map<String, ?> paramMap) throws IOException;
}
