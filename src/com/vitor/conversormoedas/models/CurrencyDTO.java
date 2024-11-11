package com.vitor.conversormoedas.models;

import java.util.Map;

public record CurrencyDTO(String result, String base_code, String target_code, double conversion_result) {
}
