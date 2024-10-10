package com.sicam.santander.chl_dss_regulatcompliance.controller;

import com.sicam.santander.chl_dss_regulatcompliance.constants.AccountsConstants;
import com.sicam.santander.chl_dss_regulatcompliance.dto.CompraVentaTrfDivisasDto;
import com.sicam.santander.chl_dss_regulatcompliance.dto.ErrorResponseDto;
import com.sicam.santander.chl_dss_regulatcompliance.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Tag(
        name = "CompraVentaTrfDivisasController",
        description = "REST Controller para Compra/Venta/Transferencias de divisas"
)
@RestController
@RequestMapping(path = "/api" , produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CompraVentaTrfDivisasController {

    private static final Logger logger = LoggerFactory.getLogger(CompraVentaTrfDivisasController.class);

    @Operation(
            summary = "Create Account REST API",
            description = "REST API para crear una compra de divisas"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCompraDivisas(@Valid @RequestBody CompraVentaTrfDivisasDto compraVentaTrfDivisasDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201,
                                        AccountsConstants.MESSAGE_201,
                                         LocalDateTime.now()
                        )
                );

    }
}
