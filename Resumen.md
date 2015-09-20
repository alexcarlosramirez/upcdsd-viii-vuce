# Introducción #

---


El presente proyecto fue desarrollado para la clase de la _Universidad Peruana de Ciencias Aplicadas (**UPC**)_, _Desarrollo de Sistemas Distribuidos_, _Ciclo 2013-1_, _Módulo 2_.



# Detalles #

---


## Reglas del proyecto ##

Previo al inicio del desarrollo del proyecto, se determinaron las siguientes reglas:

**Obligatorios**

  * El caso debe ser solucionado usando Web Services: Wsdl y Rest
  * La creación de web services en Java debe realizarse con Axis 2

**Opcionales**

_(El cumplimiento de las siguientes reglas amerita puntaje adicional)_

  * Crear las historias siguiendo el marco de trabajo SCRUM
  * Involucrar otros temas que desarrollen en clase
  * Versionar el código fuente
  * El uso de frameworks y lenguaje de programación distintos a Java es libre (excepto si van en contra de las reglas obligatorias).
  * El uso de implementación es libre. Se puede implementar en la nube, en red propia, toda en una PC.

## Presentación ##

**Primera presentación:**

  * La especificación del problema y la arquitectura de la solución en formato word.
  * El proyecto solución funcionando al 100% utilizando web services
  * El cumplimiento con las reglas opcionales

**Segunda presentación:**

  * El proyecto solución funcionando al 100% utilizando Rest e incluye Mensajeria (colas)
  * El cumplimiento con las reglas opcionales

## Caso ##

El proyecto está basado en un caso real: La problemática de la realización de trámites y la solución que plantea el sistema Ventanilla de Comercio Exterior (VUCE). Este sistema tiene como objetivo, solucionar el problema burocrático para la realización de trámites mencionado e imponer un nuevo modelo mental de "Cero papel". Ello, a largo plazo, supondrá ahorros para las entidades públicas y empresas privadas gracias a la disminución de uso del papel y a la agilicación de los trámites.

El proyecto Sistema de Comercio Exterior (SCE) se basa en esta solución, proporcionando una vista pequeña sobre como funciona la VUCE. El proyecto, para la primera etapa, mostrará el funcionamiento esperado una vez se interconecten las entidades privadas, públicas, financieras y la VUCE en la realización de un trámite ficticio. Para la segunda etapa, es la implementación de la versión movil SCE, donde habrá una aplicación que permitirá al usuario de la entidad privada realizar sus trámites y las entidades públicas autorizarlas.

## Estructura de la solución ##

La aplicación estará compuesta por 5 nodos:

**Nodo CENTRAL**

Lenguaje de Programación:
  * Java

En la primera etapa, centralizará las Ordenes de los usuarios privados y generará la tasa de pago, si amerita. Si el usuario paga la tasa correspondiente a su trámite, el sistema transmitirá la SUCE a la entidad pertinente. Por último, la entidad recibirá el Número de Expediente de la entidad para comunicarla al usuario.

Para la segunda Etapa recibirá el Documento Resolutivo por parte de la entidad pública y lo transmitirá al usuario privado.

Además, se implementará el servidor REST, que recepcionará los trámites enviadas por los usuarios privados y las respuestas de una entidad pública ficticia desde la aplicación móvil del SCE.

## Nodo Usuario ##

Lenguaje de Programación:
  * Visual Basic .NET (2008)

Para la primera etapa, está compuesta por una aplicación basada en el framework ASP.NET. Consta de dos (2) pantallas de usuario:
  1. Lista de Solicitudes
  1. Formato DGS015

La primera, lista las solicitudes y sus estados. La segunda, es el formulario del formato fictício DGS015 a transmitir.

## Nodo Entidad ##

## Nodo Financiera ##

## Nodo RUC ##