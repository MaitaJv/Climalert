# Configuración del proyecto

Este proyecto requiere una configuración previa en el archivo `application.yml` para poder funcionar correctamente.

## Configuración necesaria

Antes de ejecutar la aplicación, debes completar las siguientes propiedades en el archivo:

```yaml
email:
  destinatarios:
    - admin@clima.com
    - emergencias@clima.com
    - meteorologia@clima.com
weather:
  apiKey: TU API KEY
alerta:
  ubicacion: Buenos Aires
  tempMax: 35
  humedadMax: 60