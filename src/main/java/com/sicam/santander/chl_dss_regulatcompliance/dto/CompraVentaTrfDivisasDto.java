
package com.sicam.santander.chl_dss_regulatcompliance.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ToString
@Tag(
        name = "CompraVentaTrfDivisasDto",
        description = "Operaciones de compra, venta al contado y transferencia de divisas"
)
public class CompraVentaTrfDivisasDto {

    @Schema(description = "1.- Evento de reporte. No puede venir vacio",format = "Varchar(01)" ,example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull (message = "El codigo de evento reporte no puede ser nulo")
    @NotBlank(message = "El codigo de evento reporte no puede venir en blanco")
    @Size(max = 1)
    private String eventoReporte;

    @Schema(description = "2.- Tipo de operacion " +
            "Código que identifica si la operación corresponde a una" +
            "Compra, Venta, Transferencia de Ingreso o Transferencia de Egreso, según lo indicado en Tabla" +
            " “Tipo de documento”. ",
            format="DATETIME (yyyy-mm- ddThh:mm:ss)" ,
            example = "01",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 2)
    private String tipoOperacion;

    @Schema(description = "3.- Fecha y hora de la negociacion \n" +
            "En lo que respecta al día y hora de negociación\n" +
            "de las operaciones de compra/venta de divisas al contado la fecha deberá corresponder\n" +
            " al día de celebración de la operación (trade date), independientemente\n" +
            "de la fecha en que se realice el pago. En tanto el registro de la hora se\n" +
            "debe hacer en un plazo no mayor a 15 minutos de acordado los términos de precio y\n" +
            " monto de la operación. En el caso de las transferencias solo se debe indicar la fecha del\n " +
            "abono o cargo a las cuentas corrientes.\n",
              format="yyyy-mm-ddThh:mm:ss",
              example = "2023-09-06T11:30:02",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaHoraNegociacion;

    @Schema(description = "4.- Fecha efectiva en donde se realizan los pagos asociados a la moneda recibida por el \n " +
            "reportante en la transacción.Puede venir vacio cuando el tipo de operacion sea 03 y 04",
            format = "DATE (yyyy-mm-dd)",
            example = "2023-09-06T11:30:02",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaValuataMonedaRecibida;


    @Schema(description = "5.- Fecha efectiva en donde se realizan los pagos asociados a\n" +
            "la moneda entregada por el reportante en la transacción. Puede venir vacio cuando el tipo de operacion sea 03 y 04",
    format = "DATE (yyyy-mm-dd)",
    example = "2023-09-06")
    @DateTimeFormat(pattern = "2023-09-06")
    private LocalDate fechaValuataMonedaEntregada;

    @Schema(description = "6.- Corresponde al número, asignado por la Entidad del MCF, que identifica la operación de cambios ante el Banco. \n" +
            "Este número deberá ser único por Entidad.",
            format = "VARCHAR(15)",
            example="ID-Op-1231",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @NotNull
    @Size(max = 15)
    private String identificadorOperacion;

    @Schema(description = "7.- Rol Único Tributario (RUT) de la entidad obligada a reportar.",
            format = "VARCHAR(10)",
            example="970060006",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 10)
    private String rutContraparte1;


    @Schema(description = "8.- Código LEI (Legal Entity Identifier) de la entidad obligada a reportar, si lo tuviere.",
            format = "VARCHAR(20)",
            example="549300E9E5Y3PKW24142",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 20)
    private String leiContraparte1;

    @Schema(description = "9.- Nombre o razón social de la Contraparte obligada a reportar",
            format = "VARCHAR(50)",
            example="Banco BCI",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 50)
    private String nombreContraparte1;


    //Validar parece debe tener LEI o RUT
    @Schema(description = "10.- Rol Único Tributario (RUT) que identifica a la contraparte de la entidad obligada a reportar," +
            "puede venir vacio cuando la entidad sea" +
            "extranjera y no cuente" +
            "con RUT. En ese caso, " +
            "deberá informar LEI en " +
            "campo 10.",
            format = "VARCHAR(10)",
            example="94789001",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 10)  // Varchar(10)
    private String rutContraparte2;


    @Schema(description = "11.- Código LEI (Legal Entity Identifier) que identifica a la entidad obligada a" +
            "reportar, si lo tuviere," +
            "puede venir vacio cuando la entidad \n" +
            "cuente con RUT, ya sea \n" +
            "local o extranjera.",
            format = "VARCHAR(20)",
            example="94789001",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 20)
    private String leiContraparte2;

    @Schema(description = "12.- Nombre o razón social de la Contraparte 2.",
            format = "VARCHAR(50)",
            example="Nombre Contraparte2",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 50)  // Varchar(50)
    private String nombreContraparte2;

    @Schema(description = "13.- Código del país de residencia o domicilio de la Contraparte 2, de acuerdo con la norma ISO 3166-1 alpha-3",
            format = "VARCHAR(3)",
            example="CHL",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 3)  // Varchar(3)
    private String paisContraparte2;

    @Schema(description = "14.- RUT del intermediario financiero que utiliza a una entidad del MCF para realizar " +
            "una transferencia hacia o desde el exterior, como una corredora de bolsa, entre otras." +
            "Puede venir vacio cuando la informacion no aplica",
            format = "VARCHAR(10)",
            example="CHL",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 10)
    private String rutIntermediarioOperacion;

    @Schema(description = "15.- Código de la Plataforma de Negociación en la cual fue pactado el contrato, " +
            "según código MIC (Market Identifier Code) de la norma ISO 10383. " +
            "En el caso que el contrato fuese negociado de manera telefónica, " +
            "correo electrónico u otra forma fuera de Bolsa, se deberá indicar en este campo el código “OTC”.",
            format = "VARCHAR(10). Puede venir vacio cuando el Tipo de " +
                    "Operación sea" +
                    "transferencia (03, 04)",
            example="CHL",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 4)
    private String plataformaNegociacion;

    @Schema(description = "16.- Código que identifica la naturaleza de la Operación, " +
            "según lo indicado en el Anexo 2.1 del RO II.2 del SICAM",
            format="VARCHAR(6)",
            example = "100101",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 6)
    private String codigoOperacionCambios;

    @Schema(description = "17.- Código del país correspondiente a la legislación y jurisdicción " +
            "donde se realizó la operación o transferencia, de acuerdo con la norma ISO 3166 alpha-3",
            format="VARCHAR(3)",
            example = "CHL",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull
    @Size(max = 3)  // Varchar(3)
    private String paisOrigenMonedaExtranjera;

    @Schema(description = "18.- Código de la moneda a recibir por la Contraparte en la operación de cambios, " +
            "de acuerdo con la norma ISO 4217. Puede venir vacio cuando el tipo de operacion sea Transferencia de egreso (04)",
            format="VARCHAR(3)",
            example = "USD",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 3)  // Varchar(3)
    private String monedaCompradaRecibida;

    @Schema(description = "19.- Monto de la moneda a recibir por la Contraparte en la operación de cambios" +
            ". Puede venir vacio cuando el tipo de operacion sea Transferencia de egreso (04)",
            format="NUM(15,5)",
            example = "12500000",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 10, fraction = 5)  // Num(15,5)
    private BigDecimal montoMonedaCompradaRecibida;

    @Schema(description = "20.- Código de la moneda a entregar a la Contraparte en la operación de cambios, de acuerdo con la norma ISO 421"+
            "Puede venir vacio si el tipo de operacion sea transferencia de ingreso 03",
            format="VARCHAR(3)",
            example = "CLP",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 3)
    private String monedaVendidaEntregada;

    @Schema(description ="21.- Monto de la moneda a entregar a la Contraparte en la operación de cambios." +
            "  Puede venir vacio si el tipo de operacion sea transferencia de ingreso 03",
            format="NUM(15,5)",
            example = "10375000000",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 15, fraction = 5)  // Num(15,5)
    private BigDecimal montoMonedaVendidaEntregada;


    @Schema(description ="22.- Convención de tipo de cambio definida en el Contrato para expresar la información de precios de la operación, utilizando los códigos ISO 4217 para las monedas involucradas separados por el signo “/”" +
            "  Puede venir vacio si el tipo de operacion sea transferencia de ingreso 03 Y 04",
            format="VARCHAR(7)",
            example = "USD/CLP",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 7)
    private String convencionTipoCambio;

    @Schema(description ="23.- Tipo de cambio pactado en la operación, conforme a la Convencion Tipo de cambio pactado en la operación, conforme a la" +
            " Puede venir vacio si el tipo de operacion sea transferencia de ingreso 03 Y 04",
            format="NUM(15,5)",
            example = "830",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 10, fraction = 5)  // Num(15,5)
    private BigDecimal tipoCambioOperacion;

    @Schema(description ="24.- Indicar si la operación que se realiza cuenta con un contrato de derivados de aquellos referidos en el Capítulo III.D.3 del Compendio de Normas Financieras (CNF), de acuerdo con la Tabla “Afecta a Derivados”." +
            " Campo obligatorio ",
            format="NUM(15,5)",
            example = "S",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Size(max = 1)
    @NotNull
    private String afectaDerivados;

    @Schema(description ="25.- Código único, asignado por el reportante, de la operación de derivados asociada a la operación de cambios. En caso de poseer el UTI (Unique Transaction Identifier) de la operación de derivados, debe reportarlo en este campo" +
            " Puede venir vacio cuando el campo 23 es 0 no afecta a derivados",
            format="Varchar(52)",
            example = "ContDeriv-1234567890-A",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 52)  // Varchar(52)
    private String idDerivadosFinancieros;


    @Schema(description ="26.- Fecha de la operación entre la entidad MCF y la Contraparte, en que acuerdan las condiciones del Contrato. Cierre de la Operación significa el instante en el cual las partes manifiestan su consentimiento y cierran a firme un Contrato." +
            " Puede venir vacio si el campo 23 es 0 (no afecta a derivados)",
            format="Varchar(52)",
            example = "2023-08-16T11:00:02",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaSuscripcionContratoDerivado;

    /**Operaciones financieras en el exterior **/

    @Schema(description ="27.- Este campo deberá ser completado para las operaciones de deuda externa señaladas en el Capítulo II y sus ROs, indicando el número otorgado por el BCCh." +
            " Puede venir cuando el código de operación de cambios comience con valores distintos a 2004 \n" +
            "(desembolsos y pagos de deuda externa) y 2005 (desembolsos y pagos de créditos externos asociados a DL600",
            format="Varchar(50)",
            example = "N.Incrip.1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 50)
    private String numeroInscripcionObligacionExterior;


    @Schema(description ="28.- Nombre del Acreedor, Depositante, Inversionista o Aportante del Capital extranjero, según sea el caso" +
            "Puede venir vacio cuando el código de operación de cambios comience con valor distinto a 2 (pasivos con el exterior).",
            format="Varchar(50)",
            example = "Nombre Financista Extranjero 1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 50)
    private String nombreFinancistaExtranjero;



    @Schema(description ="29.- Código LEI del Acreedor, Depositante, Inversionista o Aportante del Capital extranjero, según sea el caso."+
            " Puede venir vacio cuando el código de operación de cambios comience con valor distinto a 2 (pasivos con el exterior), "+
            "o cuando el financista extranjero no cuente con LEI.",
            format="Varchar(20)",
            example = "FOR8UP27PHTHYVLBNG30",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 20)  // Varchar(20)
    private String leiFinancistaExtranjero;


    @Schema(description ="30.- Nombre del no residente receptor de la inversión en el exterior"+
            " Puede venir vacio cuando el código de operación de cambios comience con valor distinto a 2 (pasivos con el exterior), "+
            "o cuando el financista extranjero no cuente con LEI.",
            format="Varchar(50)",
            example = "London Clearing House",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 50)
    private String nombreReceptorExterior;


    @Schema(description = "31.- Código LEI del no residente receptor de la inversión en el exterior." +
            "Puede venir vacio cuando el código de operación de cambios comience con valor distinto a 2 (pasivos con el exterior)"+
            "o cuando el financista extranjero no cuente con LEI.",
            format = "Varchar(20)",
            example = "K8MS7FD7N5Z2WQ51AZ71",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 20)
    private String leiReceptorInversionExterior;

    @Schema(description = "32.- Completar este campo si la operación corresponde a inversiones realizadas conforme a la Sección III de la" +
            " Letra B del Capítulo II del CNCI, respecto de títulos o valores mantenidos en custodia por un Custodio Internacional. " +
            "Esto, según la Tabla “Modalidad intervención custodio internacional”" + "Puede venir vacio cuando la informacion no aplica",
            format = "Varchar(2)",
            example = "01",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 2)
    private String modalidadIntervencionCustodioInternacional;

}
