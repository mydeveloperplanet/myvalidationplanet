package com.mydeveloperplanet.myvalidationplanet.domain;

import com.mydeveloperplanet.myvalidationplanet.validation.DutchZipcode;

public record Address (String street, @DutchZipcode String zipcode) {
}
