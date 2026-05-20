EcoMarketSPA

Proyecto de DUOC UC para la asignatura Desarrollo Fullstack I 
El objetivo es crear una solución backend para EcoMarket usando una arquitectura de microservicios con SPRING BOOT

Descripción

EcoMarket SPA necesita separar las funciones principales de su sistema en servicios independientes.
En este repositorio se desarrollan microservicios básicos para gestionar usuarios, productos, tiendas, ventas, pedidos, pagos, logística, soporte y monitoreo del sistema mediante una API REST.

Microservicios del proyecto

usuarios-seguridad-service
Gestiona usuarios, roles, permisos e inicio de sesión

inventario-catalogo-service
Gestiona productos, categorías, stock y búsqueda de productos

tiendas-reportes-service
Gestiona tiendas, sucursales, horarios y reportes simples

ventas-facturacion-service
Gestiona ventas, devoluciones, reclamaciones y facturación

pedidos-carrito-service
Gestiona carrito de compras, pedidos e historial de pedidos

pagos-service
Gestiona pagos, confirmaciones y estados de pago

logistica-proveedores-service
Gestiona envíos, proveedores, recepción de mercadería y estados de entrega

soporte-resenas-service
Gestiona tickets de soporte, reseñas y calificaciones

observabilidad-respaldo-service
Gestiona monitoreo básico, alertas, respaldos y restauración de dato

Tecnologías usadas

Java
Spring Boot
Maven
Spring Data JPA
MySQL
Postman
GitHub

Estructura general

EcoMarketSPA/
─ usuarios-seguridad-service/
─ inventario-catalogo-service/
─ tiendas-reportes-service/
─ ventas-facturacion-service/
─ pedidos-carrito-service/
─ pagos-service/
─ logistica-proveedores-service/
─ soporte-resenas-service/
─ observabilidad-respaldo-service/
─ README.md