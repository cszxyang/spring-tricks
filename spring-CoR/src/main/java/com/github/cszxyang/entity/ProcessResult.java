package com.github.cszxyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessResult {
    public ProcessResult() {
    }

    private boolean isFinished;
}
