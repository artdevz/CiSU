package com.CaniNUS.dto;

import java.util.UUID;

public record CourseDTO(UUID universityId, String name, int numOfPlaces, int duration) {}
