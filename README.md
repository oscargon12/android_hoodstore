<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="https://cdn-icons-png.flaticon.com/512/1785/1785278.png" alt="Logo" width="80" height="80">

  <h1 align="center">Tienda Hoods</h1>

  <p align="center">
    Tienda ecommerce (Java, firebase)
    <br />
  </p>
  <h6>Ciclo 4 MinTic/UNAB Desarrollo de apps móviles</h6>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Contenido</summary>
  <ol>
    <li>Acerca del proyecto</li>
    <li>Comandos disponibles</li>
    <li>Sprints</li>
    <li>Arquitectura del proyecto</li>
  </ol>
</details>

________________________

 ![Hoodstore navigation](https://github.com/oscargon12/android_hoodstore/blob/main/hoodstore.gif?raw=true)
 
## Acerca Del Proyecto
Este proyecto ha sido creado con el framework React JS [Create React App](https://github.com/facebook/create-react-app).

La aplicación **Hoodsstore** ha sido creada como ejercicio evaluativo para el ciclo 4 de programación (Desarrollo Móbil) UNAB/MinTic .\
**Scoole** dentro del ejercicio, funciona como una app, para la administración de productos.\
Las distintas funcionalidades han sido creadas paso a paso conforme avanzó el curso y como entrega final -Además de los features desarrollados- se propone una mejora en la interfaz y en la usabilidad.

### Funcionalidades actuales
- Pantalla de inicio (mainActivity)
- Login y registro con Firebase authentication
- Catálogo (activity_catalog)
- Catálogo por template y adapter
- Detalle de producto (activity_info)
- CRUD con firebase
- Mapas

________________________

## Comandos disponibles

### Previo...
Deberá realizar la instalación del IDE (Recomendado IntelliJ o Android Studio) y realizar la configuración de la máquina virtual de android (emulador)

Podrá obtener una versión del repositorio ejecutando en la terminal:

```https://github.com/oscargon12/android_hoodstore.git```

________________________

## Sprints

Actualmente el proyecto se encuantra realizado hasta el Sprint No. 2

### `Sprint 1`
Se realizó la maquetación y deseño de interfaz de las pantallas:
- Pantalla de inicio
- Listado de productos
- Detalle de producto

### `Sprint 2`
La información del catálogo se ha hecho más dinámica, usando un template con el modelo de la información del producto el cual será consumido por el listado de productos mediante un adapter.

### `Sprint 3`
Se inició el desarrollo de las funciones CRUD mediante una base de datos con Firestore.
