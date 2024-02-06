package com.fdobrotv.testphonebooking.service;

import java.util.UUID;

public interface EntityService<T> {
    T getEntityById(UUID id);
}
