/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String country;
    private String province;
    private String city;

}
