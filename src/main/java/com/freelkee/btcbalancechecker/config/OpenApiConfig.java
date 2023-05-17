package com.freelkee.btcbalancechecker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "BTC Balance Checker",
                description = "BTC Balance Checker is a web application that allows " +
                        "users to check the balance of their Bitcoin wallet" +
                        " addresses by querying the blockchain using a third-party API.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Danila Berdnikov",
                        email = "freelkee@ya.ru",
                        url = "https://t.me/freelkee"
                )
        )
)
public class OpenApiConfig {

}