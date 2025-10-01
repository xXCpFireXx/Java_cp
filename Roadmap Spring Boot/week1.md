# 📅 Semana 1 – Refuerzo de Java + Bases de datos

🎯 **Objetivo:** Al final deberías ser capaz de hacer un CRUD en consola que guarde usuarios en una base de datos (primero con JDBC y luego con Hibernate/JPA).

---

## 🔹 Día 1 – Repaso Java básico
- Clases, objetos, constructores.  
- Herencia e interfaces.  
- Sobrecarga y sobreescritura de métodos.  

👉 Ejercicio: Crear clase `Usuario` con `id`, `nombre`, `email`, e imprimir usuarios con un `ArrayList<Usuario>`.  

---

## 🔹 Día 2 – Colecciones y excepciones
- `List`, `Map`, `Set` → operaciones básicas.  
- Manejo de errores: `try/catch/finally`.  

👉 Ejercicio: método que devuelva un `Usuario` por email o lance `UsuarioNoEncontradoException`.  

---

## 🔹 Día 3 – Introducción a JDBC
- Conexión con `DriverManager`.  
- `Connection`, `PreparedStatement`, `ResultSet`.  

👉 Ejercicio: Programa que guarde un usuario en la BD y lo liste.  

---

## 🔹 Día 4 – CRUD con JDBC
- Operaciones: `INSERT`, `SELECT`, `UPDATE`, `DELETE`.  
- Clase `UsuarioDAO` con métodos CRUD.  

👉 Ejercicio: menú en consola con opciones CRUD.  

---

## 🔹 Día 5 – Introducción a JPA/Hibernate
- `@Entity`, `@Id`, `@GeneratedValue`.  
- `EntityManager` y `persistence.xml`.  

👉 Ejercicio: programa que guarde un usuario en la BD usando JPA.  

---

## 🔹 Día 6 – CRUD con JPA
- Métodos: `persist()`, `find()`, `merge()`, `remove()`.  

👉 Ejercicio: menú en consola igual al del día 4, pero usando JPA.  

---

## 🔹 Día 7 – Proyecto de cierre de semana
- CRUD completo en consola con **JPA/Hibernate**.  
- Separar lógica con `UsuarioService`.  

👉 Resultado: primer mini-proyecto Java + BD, base para migrar a Spring Boot.  
