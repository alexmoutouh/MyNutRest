package com.alexm.MyNutRest.domain.port;

import java.math.BigDecimal;

import com.alexm.MyNutRest.domain.model.NutScanResultDomain;

public interface MyNutScanService {
	NutScanResultDomain scanAndSave(Long userId, byte[] imageBytes, BigDecimal grams);
}
