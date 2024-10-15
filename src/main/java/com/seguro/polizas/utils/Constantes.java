package com.seguro.polizas.utils;

public class Constantes {
    /** Path utilizado para suscribir */
    public static final String PATH_SUSCRIBIR = "/suscribir";

    /** Path utilizado para cancelar suscripcion */
    public static final String PATH_CANCELAR = "/{suscripcionId}/{tipoNotificacion}";

    /** Path utilizado para fondo controller */
    public static final String PATH_FONDO = "/fondos";

    /** Path utilizado para transacciones controller */
    public static final String PATH_TRANSACCIONES = "/transacciones";

    /** path utilizado para asegurados controller */
    public static final String PATH_ASEGURADOS = "/api/asegurados";

    /** path utilizado para  liquidación  */
    public static final String PATH_LIQUIDACION = "/liquidacion";

    /** path utilizado para crear lista clientes controller */
    public static final String PATH_CREAR_LISTA_CLIENTES = "crear-lista-usuarios";


    public static final String MENSAJESMS = "<p>Señor(a) Juan Pérez, la suscripción en <strong>Fondo ABC</strong> quedó en estado <strong>Activo</strong>.</p>";
    public static final String PATH_HISTORIAL_TRANSACCIONES = "/transacciones/historial/{clienteId}";
    // Mensajes de error para validaciones de FondoDTO
    public static final String ERROR_FONDO_DTO_NULL = "El objeto FondoDTO no puede ser nulo."; // Error cuando el objeto es nulo
    public static final String ERROR_NOMBRE_VACIO = "El nombre del fondo no puede estar vacío."; // Error cuando el nombre está vacío
    public static final String ERROR_MONTO_MINIMO_INVALIDO = "El monto mínimo debe ser un valor positivo."; // Error cuando el monto es <= 0
    public static final String ERROR_CATEGORIA_VACIA = "La categoría no puede estar vacía."; // Error cuando la categoría está vacía
    /** error la suscripcion no existe */
    public static final String ERROR_SUSCRIPCION_NO_EXISTE = "No se encontro suscripcion";
    /** "Error monto de vinculación no es suficiente para el fondo " */
    public static final String  ERROR_MONTO_INSUFICIENTE_PARA_EL_FONDO = "El monto de vinculación no es suficiente para el fondo ";
    /**Error no hay saldo disponible*/
    public static final String ERROR_NO_SALDO_SUFICIENTE = "No tiene saldo disponible para vincularse al fondo ";

    /** Error fondo no existe */
    public static final String ERROR_FONDO_NO_EXISTE = "El fondo no existe en el sistema.";

    /** Suscripcion realizada exitosamente */
    public static final String SUSCRIPCION_EXITOSA ="Suscripción realizada exitosamente para el cliente {0} en el fondo {1}";
    /** Cancelacion exitosa */
    public static final String CANCELACION_EXITOSA= "Cancelación de la suscripción realizada exitosamente para el cliente {} en el fondo {}";

    /** enviar email log exitosa */
    public static final String SEND_EMAIL_LOG = "Correo enviado a {} con el asunto {}";

    /** enviar sms log exitosa */
    public static final String SEND_SMS_LOG = "SMS enviado a {} con el mensaje {}";
}
