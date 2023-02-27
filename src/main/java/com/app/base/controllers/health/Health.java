package com.app.base.controllers.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Health Check API", description = "This is a simple health check API")
public class Health {

    @Operation(
            summary = "Get health info",
            description = "The description of the API is get health information",
            tags = { "contact" }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = String.class
                                            )
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Failed with bad request",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = String.class
                                            )
                                    )
                            )
                    ),
            }
            )
    @GetMapping("/healthInfo")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("All Good", HttpStatus.OK);
    }
}
