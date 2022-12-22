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

<img src="https://github.com/oscargon12/android_hoodstore/blob/main/hoodstore.gif?raw=true" alt="App-navigation" style="width:280px"/>
 
## Acerca Del Proyecto
Este proyecto ha sido creado con **java** y **Firebase**, mediante el IDE **Android Studio**.

La aplicación **Hoodstore** ha sido creada como ejercicio evaluativo para el ciclo 4 de programación (Desarrollo Móvil) UNAB/MinTic .\
**Hoodstore** dentro del ejercicio, funciona como una app, para la administración de productos.\
Las distintas funcionalidades han sido creadas paso a paso conforme avanzó el curso y como entrega final -Además de los features desarrollados- se propone una mejora en la interfaz y en la usabilidad.

### Funcionalidades actuales
- Pantalla de inicio (mainActivity)
- Login y registro con Firebase authentication
- Catálogo (activity_catalog)
- Catálogo por template y adapter
- Detalle de producto (activity_info)
- CRUD con firebase
- Mapas

<img src="https://github.com/oscargon12/android_hoodstore/blob/main/screens.jpg?raw=true" alt="App-navigation" style="width:700px"/>

________________________

## Comandos disponibles

### Previo...
Deberá realizar la instalación del IDE (Recomendado IntelliJ o Android Studio) y realizar la configuración de la máquina virtual de android (emulador)

Podrá obtener una versión del repositorio ejecutando en la terminal:

```git clone https://github.com/oscargon12/android_hoodstore.git```

________________________

## Sprints

Actualmente el proyecto se encuantra realizado hasta el Sprint No. 4

### `Sprint 1`
Se realizó la maquetación y diseño de interfaz de las pantallas:
- Pantalla de inicio
- Listado de productos
- Detalle de producto

### `Sprint 2`
La información del catálogo se ha hecho más dinámica, usando un template con el modelo de la información del producto el cual será consumido por el listado de productos mediante un adapter.

### `Sprint 3`
La información del catálogo ahora está siendo consultda en firebase, se ha creado una base de datos de productos en **Firestore**, la cual permitirá los métodos CRUD (Inserción, consulta, actualización y eliminación) de productos.

### `Sprint 4`
Se ha implementado el inicio de sesión y registro a la aplicación, usando los servicios de Firebase Authentication. Además se ha implementado el mapa para ver las ubicaciones de los productos.
