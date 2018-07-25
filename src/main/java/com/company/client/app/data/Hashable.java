package com.company.client.app.data;

import com.company.client.app.util.Hasher;

public interface Hashable {
    default String hash() {
        return Hasher.hash(toString());
    }
}
