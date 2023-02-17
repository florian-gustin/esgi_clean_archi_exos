package org.example.exo.domain.interfaces;

import org.example.exo.domain.enums.Type;

public interface Logger {
    void print(String message, Type type);
    void println(String message, Type type);
}