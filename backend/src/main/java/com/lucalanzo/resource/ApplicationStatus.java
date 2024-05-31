package com.lucalanzo.resource;

import lombok.Getter;

@Getter
public enum ApplicationStatus {
    APPLIED,
    INVITED,
    HIRED,
    GHOSTED,
    DECLINED
}
