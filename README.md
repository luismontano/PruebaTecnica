# Prueba Técnica

Este documento expone la creación y el funcionamiento del **microservicio** escrito en **Java** utilizando el **framework Spring**. Realiza una **integración con el API** descrita a continuación con el objetivo de consumir sus servicios utilizando **peticiones HTTP y los métodos GET, POST, PUT y DELETE**. Las peticiones y respuestas se realizan mediante el **formato Json**.

## Integración

**EndPoint 1**
```
https://testbankapi.firebaseio.com/products.json
```
> **_Nota:_** Permite los métodos GET Y POST

**EndPoint 2**
```
https://testbankapi.firebaseio.com/products/id.json
```
> **_Nota:_** Permite los métodos PUT Y DELETE

## Prerequisitos

Para hacer uso del servicio se debe tener instalado el **JDK de java**. Se recomienda la versión jdk1.8.0_171 o posterior
```
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
```

## Instalación

Se proponen dos mecánismos para realizar la ejecución del proyecto

Inicialmente se debe realizar la clonación del repositorio
```
https://github.com/luismontano/PruebaTecnica.git
```

### Ejecución del jar

1. Ejecutar la aplicación usando la línea de comandos
```
java -jar accenture-0.0.1-SNAPSHOT.jar 
```

### Ejecución usando eclipse

![Image](https://github.com/luismontano/PruebaTecnica/blob/master/Importar.png)
