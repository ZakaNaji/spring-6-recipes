package com.znaji.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CourtNameForbiddenException extends RuntimeException {
    private final String courtName;

}
