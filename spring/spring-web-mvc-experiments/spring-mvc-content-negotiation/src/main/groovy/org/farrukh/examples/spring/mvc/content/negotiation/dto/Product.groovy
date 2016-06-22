package org.farrukh.examples.spring.mvc.content.negotiation.dto

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Farrukhjon on 5/19/2015.
 */
class Product {

    @JsonProperty('ID')
    int id

    @JsonProperty('NAME')
    String name
}
