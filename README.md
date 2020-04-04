# Preguntas Teóricas
A continuación, se da respuesta a las preguntas pleanteas

### Identifique las diferencias (si las hay) entre un microservicio y un servicio web
Los servicios web son servicios que son ofrecidos en la web por medio de peticiones HTTP. Por otro lado, los microservicios son una arquitectura para desarrollar software basada en modelar la aplicación en partes, en servicios independientes; esto último, garantiza un bajo acoplamiento. Los microservicios pueden estar escritos en diferentes lenguajes de programación y suelen ser implementados como servicios web.

### Diferencias entre Rest y Restful
REST es un estilo arquitectural que define una serie de principios la creación de servicios web y para para establecer una comunicación entre el cliente y el servidor. En esta se describe que el protocolo de comunicación utilizado es HTTP y a demás se deben utilizar diferentes métodos como GET, POST, PUT, PATCH y DELETE. Los servicios Restful son aquellos que implementan todos los principios de la arquitectura REST.

### Que significa la inyección de dependencias y cuando se aplica
La inyección de dependecias es un patron de diseño utilizado en la programación orientada a objetos, en el cual el objeto no realiza la creación de sus dependencias sino que estas le son suministradas. Hay una clase que le pasa o inyecta las dependencias. Se puede utilizar cuando se desea modularidad, reutilziación, bajo acoplamiento y evitar crear muchos objetos de una clase, debido a que en la inyección de dependencias las dependencias funcionana como un singleton. Adicionalmente, son utiles al realizar pruebas de unidad debido a que las dependencias se pueden mockear.

# Prueba Técnica

1. [Procedimiento](#Procedimiento)
2. [Descripción](#Descripción)
3. [Integración](#Integración)
4. [Tecnologías](#Tecnologías)
4. [Prerequisitos](#Prerequisitos)
5. [Instalación](#Instalación)
6. [Uso](#Uso)
7. [Postman](#Postman)
8. [Contacto](#Contacto)

## Procedimiento
A continuación, se describe de manera detallada el procedimiento realizado para la creación de la API
1. Lectura cuidadosa de las instrucciones
2. Pruebas manuales de los endpoints suministrados usando Postman
3. Creación del proyecto usando Spring Boot Initilizer
4. Adición de dependencias útiles para el desarrollo del proyecto (Gson)
5. Estructuración del proyecto por medio de cla creación de los paquetes necesarios para dividir el código. En este paso se crearon los siguientes paquetes: **controllers:** clases e interfaces correspondientes a controladores rest. **dtos:** clases utilizadas para transferir datos. **models:** clases necesarias para modelar la información. **repository:** clases e interfaces utilizadas para acceder a los datos. **services:** clases relacionadas con servicios de negocio
6. Creación de las interfaces utilizadas por los controladores, los servicios de negocio y los servicios de acceso a datos
7. Implementación de la capa de acceso a datos
8. Creación de pruebas automáticas para la capa de acceso a datos usando JUnit
9. Implementación de la capa de negocio e integración con la capa de acceso a datos
10. Creación de pruebas para la capa de negocio usando JUnit y la integración con la capa de acceso a datos
11. Implementación de los controladores Rest e integración con los servicios de negocio
12. Creación de pruebas para los controladores y la integración con los servicios de negocio
13. Adicionalmente, se realizan pruebas manuales usando Postman

## Descripción
Este documento expone la creación y el funcionamiento del **microservicio** escrito en **Java** utilizando el **framework Spring**. Realiza una **integración con el API** descrita a continuación con el objetivo de consumir sus servicios utilizando **peticiones HTTP y los métodos GET, POST, PUT y DELETE**. Las peticiones y respuestas se realizan mediante el **formato Json**. Adicionalmente en los recursos del proyecto se pueden observar las pruebas de integración y de unidad desarrollada.

## Integración

**EndPoint 1**
```
https://testbankapi.firebaseio.com/products.json
```
> **_Nota:_** Permite los métodos GET Y POST

**EndPoint 2**
```
https://testbankapi.firebaseio.com/products/{id}.json
```
> **_Nota:_** Permite los métodos PUT Y DELETE

## Tecnologías

Spring Boot, JUnit, Java, Gson, Java Lambda

## Prerequisitos

Para hacer uso del servicio se debe tener instalado el **JDK de java**. Se recomienda la versión jdk1.8.0_171 o posterior
```
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
```

## Instalación

Se proponen dos mecánismos para realizar la ejecución del proyecto. Inicialmente se debe realizar la clonación del repositorio
```
https://github.com/luismontano/PruebaTecnica.git
```

### Ejecución usando la línea de compados y el jar

1. Ejecutar la aplicación usando la línea de comandos
```
java -jar accenture-0.0.1-SNAPSHOT.jar 
```

### Ejecución usando eclipse

1. Importar el proyecto en eclipse: File > import

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/1.%20Importar.png"></p>

2. Seleccione la opción **Existing Maven Projects**

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/2.%20Import%20Maven.png"></p>

3. Seleccione la opción **Finish**

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/3.%20Import%20Maven.png"></p>

4. Actualice las dependencias del proyecto: Clic derecho > Maven > Update proyect

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/4.%20Actualizar%20dependencias.png"></p>

5. Seleccione la opción **Force update of Snapshots** y de clic en Ok

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/5.%20Actualizar%20dependencias.png"></p>

6. Ejecute la aplicación como una aplicación java, para esto ubique el archivo **AccentureApplication.java**: clic derecho > Run As > Java Application

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/6.%20Ejecutar%20la%20aplicaci%C3%B3n.png"></p>

7. Si los pasos se han realizado correctamente se debería observar el siguiente mensaje en el log

<p align="center"><img src="https://github.com/luismontano/PruebaTecnica/blob/master/7.%20Log.png"></p>

## Uso

La aplicación se ejecutará en un servidor local que recibe peticientes usando el puerto 8080. Las peticiones y respuestas se realizan mediante el **formato Json**

**EndPoint 1**
```
http://localhost:8080/products.json
```
> **_Nota:_** Permite los métodos GET Y POST

**EndPoint 2**
```
http://localhost:8080/products/{id}.json
```
> **_Nota:_** Permite los métodos PUT Y DELETE

**EndPoint 3**
```
http://localhost:8080/totalvalues.json
```
> **_Nota:_** Permite el método GET

## Postman

Para probar la API desarrollada puede hacer uso de postman, importando la siguiente configuración
```
https://github.com/luismontano/PruebaTecnica/blob/master/Accenture.postman_collection.json
```
> **_Nota:_** Recuerde modificar los ids cuando se requiera

## Contacto
Luis Carlos Montaño Castañeda 
luismontano@outlook.com
