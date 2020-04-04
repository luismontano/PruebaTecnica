# Prueba Técnica

1. [Descripción](#Descripción)
2. [Integración](#Integración)
3. [Prerequisitos](#Prerequisitos)
4. [Instalación](#Instalación)
5. [Uso](#Uso)
3. [Contacto](#Contacto)

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

## Contacto
Luis Carlos Montaño Castañeda 
luismontano@outlook.com
