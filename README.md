# AREP TAREA INTRODUCCIÓN MVN-GIT Y HEROKU
## Autor: David Otálora Bernal

Esta aplicación sirve para consultar el mercado de valores de las acciones negociadas en Bolsa. La aplicación recibe el identificador de una acción, por ejemplo “MSFT” para Microsoft y muestra el histórico de la valoración intra-día, diaria, semanal y mensual.

![image](https://user-images.githubusercontent.com/46855679/187591490-b3fc6d8f-ee39-40f9-9bd6-93b3da44c1c1.png)

### Herramientas

- IntelliJIDEA
- SparkWeb
- Maven
- HTML

### Lenguajes
- Java (requerido Java 8 o Java 11)
- JavaScript

### Diseño 

![image](https://user-images.githubusercontent.com/46855679/187592645-a8ee0909-0b3c-467d-8ce8-2bf854f38894.png)

Esta aplicación utiliza una conexion en HTML muy simple, si se quisiera agregar un servicio adicional basta con simplemente añadir un metodo en la clase HttpConnection con lo que deseemos, tanto el HTML como el JavaScript contiene lo basico para hacer funcionar la aplicación, por lo tanto es bien extensible añadiendo nuevas funciones.


### Heroku

Esta aplicación está desplegada en Heroku, para abrirlo basta con hacer click en el boton de abajo.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://fast-hollows-06971.herokuapp.com/)
