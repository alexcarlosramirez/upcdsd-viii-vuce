# Requerimientos #

---


**Para el Nodo Central:**
  * Entorno de Desarrollo Integrado Eclipse
  * Plugin para soporte de SVN (Preferible Subclipse)

**Para el Nodo Financiero:**
  * Entorno de Desarrollo Visual Studio 2008 (Financiera\_2008)
  * Entorno de Desarrollo Visual Studio 2012 (Financiera\_2012)
  * Herramienta para el soporte de control de versiones por SVN (obligatorio [TortoiseSVN](http://www.visualsvn.com/visualsvn/download/tortoisesvn/))
  * Herramienta para Visual Studio para el soporte de control de versiones por SVN con Tortoise (recomendable [VisualSVN](http://www.visualsvn.com/visualsvn/download/))

**Para el Nodo Entidad:**
  * Herramienta para el soporte de control de versiones por SVN (obligatorio [TortoiseSVN](http://www.visualsvn.com/visualsvn/download/tortoisesvn/))

**Para el Nodo Usuario:**
  * Entorno de Desarrollo Visual Studio 2010
  * Herramienta para el soporte de control de versiones por SVN (obligatorio [TortoiseSVN](http://www.visualsvn.com/visualsvn/download/tortoisesvn/))
  * Herramienta para Visual Studio para el soporte de control de versiones por SVN con Tortoise (recomendable [VisualSVN](http://www.visualsvn.com/visualsvn/download/))

# Instalación #

---


**Para el Nodo Central:**
  1. Abrir el entorno de desarrollo Eclipse
  1. Abrir la perspectiva SVN Repository Exploring
  1. Hacer clic derecho en la vista "SVN Repositories"
  1. En el menú desplegable, seleccionar "New > Repository Location"
  1. En el campo "Url", agregar la dirección: https://upcdsd-viii-vuce.googlecode.com/svn y hacer clic en "Aceptar"
  1. Desplegar el contenido del repositorio agregado
  1. Abrir la carpeta "Central"
  1. Seleccionar las 4 subcarpetas `SCE.RestService`, `SCE.Servicio`, `SCE.WebService` y `ScripBd`
  1. Hacer clic derecho en la vista "SVN Repositories" sin dejar de tener seleccionado las carpetas
  1. En el menú desplegable, seleccionar "Checkout"
  1. En la ventana emergente, hacer clic en el botón "Finish"



**Para el Nodo Financiero:**
  1. Abrir el entorno de desarrollo a trabajar: Visual Studio 2008 o 2012
  1. En la barra de menú, ubicar y seleccionar "VisualSVN"
  1. En el menú desplegable, seleccionar Repo-Browser
  1. En el campo URL agregar la dirección: https://upcdsd-viii-vuce.googlecode.com/svn y hacer enter
  1. Hacer clic derecho en la carpeta `Finaciera_2008` o `Financiera_2012`, según el proyecto a importar
  1. En el menú desplegable, elegir "Checkout"
  1. Elegir una carpeta de destino en el campo "Checkout directory" _(Se recomienda cambiar el que aparece por defecto, puesto es la ruta a la carpeta donde está instalado el IDE)_
  1. Hacer click en "Ok"
  1. Abrir la solución donde se guardó los archivos descargados por el repositorio