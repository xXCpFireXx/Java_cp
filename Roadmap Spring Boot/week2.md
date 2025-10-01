# 📅 Semana 2 – Introducción a Spring y arranque en Spring Boot

🎯 **Objetivo:** Entender qué hace Spring y arrancar con Spring Boot.

---

## 🔹 Día 1 – Inversión de Control y DI
- Conceptos: IoC, Beans, `@Component`, `@Autowired`.  

👉 Ejercicio: Crear un servicio simple inyectado en un controlador.  

---

## 🔹 Día 2 – Spring MVC básico
- `@Controller` vs `@RestController`.  
- `@GetMapping`, `@PostMapping`.  

👉 Ejercicio: endpoint `/hello` que devuelva `"Hola Spring Boot"`.  

---

## 🔹 Día 3 – Crear proyecto con Spring Initializr
- Dependencias: Web, JPA, H2/MySQL.  
- Estructura de carpetas (`entity`, `repository`, `service`, `controller`).  

👉 Ejercicio: levantar proyecto vacío y probar endpoint.  

---

## 🔹 Día 4 – Entidades y Repository
- `@Entity` para `Usuario`.  
- `UsuarioRepository extends JpaRepository`.  

👉 Ejercicio: guardar y listar usuarios con JPA desde el repositorio.  

---

## 🔹 Día 5 – Servicios y Controladores
- `@Service` para lógica de negocio.  
- `@RestController` para endpoints CRUD.  

👉 Ejercicio: CRUD básico de usuarios con API REST.  

---

## 🔹 Día 6 – Probar con Postman
- Métodos HTTP: GET, POST, PUT, DELETE.  
- Probar endpoints de CRUD.  

👉 Ejercicio: probar endpoints `/usuarios`.  

---

## 🔹 Día 7 – Proyecto de cierre de semana
- CRUD REST completo en Spring Boot (Usuarios).  
- BD en memoria (H2) o MySQL.  

👉 Resultado: tu primera API REST completa con Spring Boot.  
