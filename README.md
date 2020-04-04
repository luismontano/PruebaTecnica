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
