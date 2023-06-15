package com.jb.code_analysis.inspections.verbose_redundant_code;

import java.util.Optional;

public class OptionalUseCases {
    void useCase1() {
/*
        optional.map(x -> true).orElse(false) → optional.isPresent()
        optional.map(x -> Optional.of(x.trim())).orElseGet(Optional::empty) → optional.map(String::trim)
        optional.map(x -> (String)x).orElse(null) → (String) optional.orElse(null)
        Optional.ofNullable(optional.orElse(null)) → optional
                val = optional.orElse(null); val != null ? val : defaultExpr → optional.orElse(defaultExpr)
        val = optional.orElse(null); if(val != null) expr(val) → optional.ifPresent(val -> expr(val))
*/
    }
}
