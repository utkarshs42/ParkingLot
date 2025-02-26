package dtos;

import models.Token;

public class TokenResponseDto {
    private Token token;
    private ResponseStatus responseStatus;
    private String failureReason;
}
