# TALLER AREM #1: APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)


Esta es una aplicación para consultar la información de películas de cine.  La aplicación recibe una frase de búsqueda del título, por ejemplo “Guardians of the galaxy”  y deberá mostrar el los datos de la película correspondiente. Para esto utilize el API gratuito de https://www.omdbapi.com/ (Se uso una clave gratuita). 

## Empezando

Estas instrucciones te permitirán obtener una copia del proyecto y ejecutarlo en tu máquina local con fines de desarrollo y pruebas. Consulta la sección de implementación para obtener notas sobre cómo desplegar el proyecto en un sistema en vivo.

### Prerequisitos

¿Qué cosas necesitas instalar para el software?

```
- Un navegador (Preferencia que sea Mozilla o Chrome).
- Un IDLE como NetBeans para poder arrancar el servidor (Nota: Hay otras maneras).
- GitBash para clonar tu proyecto en tu Computadora.

```

### Instalacion

Una serie paso a paso de ejemplos que te indican cómo configurar un entorno de desarrollo.

```
    1. Clonar este respositorio en su computadora.
    2. Encontrara dos carpetas, server-web y client-web.
    3. Server-web puede abrirlo desde NETBEANS y arranca el mai.java
    4. Abra el cliente: 
        4.1. Si tiene una extension en Visual Studio code puede usarla para abrir un puerto y consultar la pagina de la siguiente manera. Por Ejemplo: http://127.0.0.1:5500/index.html
        4.2 Mas sencillo, simplemente abra el index.html en Mozilla o Chrome.

```


## Ejecución de las pruebas.

Explica cómo ejecutar las pruebas automatizadas para este sistema.

### Desglosar en pruebas de extremo a extremo.

Explica qué prueban estas pruebas y por qué.

```

CacheInitTest

    1. Prueba debeCrearUnaInstanciaNueva:

    Verificar que se pueda crear una nueva instancia de CacheInit utilizando su método estático getInstance().Esto garantiza que la clase CacheInit se pueda usar y crear instancias correctamente en todo el código que lo utilice.


    2.Prueba debeDevolverPeliculaDeLaCache:

    Probar si el método buscarPeliculaPorNombre devuelve correctamente una película que ya está en la caché.


    3. Prueba debeDevolverPeliculaDeLaApiExterna:

    Asegurarse de que el método buscarPeliculaPorNombre busque en la API externa cuando la película no está en la caché.

```

```

Cliente Java para Tests concurrente, se realizaron dos pruebas con 5 peliculas que se encuentran de forma correcta y otras 5 que no se encontraron.


4. Prueba testConcurrenciaCincoPeliculasServicioExterno()

5. testConcurrenciaNoEncontrarPeliculas()

En las pruebas se usaron el fundamento: given,when y then.


```




## Implementación

```
    5. Consulte la pelicula:

    6. Escribe "Guardians of the galaxy" y dale en el boton "Buscar Pelicula"
```
Fotos:
        ![Cliente](https://tucatalogo.digital/img_cvds/peli.png)

## Construido Con

* [omdbapi](https://www.omdbapi.com/ ) - API Gratuito
* [Maven](https://maven.apache.org/) - Dependency Management
* [README](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2) - Contrui este ReadMe basado en la plantilla de https://gist.github.com/PurpleBooth.


<!-- 
## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us. -->

<!-- ## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).  -->

## Autores

* **Daniel Esteban Perez Bohorquez** -

## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Agradecimientos

* Escuela Colombiana de Ingenieria
