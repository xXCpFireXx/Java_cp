# Sistema de Usuarios con POO

## 1. Objetivo del ejercicio

Diseñar un **sistema de gestión de usuarios** aplicando los **4 principios de la Programación Orientada a Objetos (POO)**:

1. **Encapsulamiento** → proteger los datos con atributos privados y validaciones en getters/setters.
2. **Herencia** → clase base `Usuario` y subclases como `Administrador` y `Cliente`.
3. **Polimorfismo** → métodos comunes sobrescritos en cada subclase.
4. **Abstracción** → uso de clase abstracta y/o interfaz.

---

## 2. Contexto del sistema

La plataforma maneja dos tipos de usuarios:

* **Administrador**

    * Puede bloquear/desbloquear usuarios.
    * Puede ver listado completo de usuarios.

* **Cliente**

    * Puede actualizar su información de contacto (teléfono y dirección).
    * Puede ver el listado de clientes.

Ambos:

* Pueden registrarse e iniciar sesión.
* Pueden ver su perfil (nombre, correo, rol, estado).

---

## 3. Requerimientos funcionales

* **Registro y autenticación**: crear usuarios y validar credenciales.
* **Perfiles**: mostrar datos básicos (nombre, correo, rol, estado).
* **Acciones por rol**:

    * Admin → gestionar usuarios.
    * Cliente → actualizar contacto.

---

## 4. Principios de POO aplicados

### 🔹 Encapsulamiento

* Atributos privados: `email`, `password`, `estado`.
* Validaciones en setters:

    * Email válido (contiene `@`).
    * Contraseña ≥ 6 caracteres.
    * Teléfono/dirección no vacíos.

```java
private String email;
private String password;

public void setEmail(String email) {
    if(email.contains("@")) {
        this.email = email;
    } else {
        System.out.println("Email inválido");
    }
}
```

---

### 🔹 Herencia

Clase base: `Usuario`.

Subclases:

* `Administrador extends Usuario`
* `Cliente extends Usuario`

---

### 🔹 Polimorfismo

Un método común como `mostrarPerfil()` se comporta distinto:

* En `Cliente` → incluye teléfono y dirección.
* En `Administrador` → incluye permisos de gestión.

```java
public abstract void mostrarPerfil();
```

---

### 🔹 Abstracción

* **Clase abstracta**: `Usuario` define atributos y métodos abstractos.
* **Interfaz**: `Autenticable` obliga a implementar `login(String email, String password)`.

---

## 5. Reglas de negocio mínimas

* Cliente puede actualizar teléfono y dirección (no vacíos).
* Email debe tener `@` y un dominio.
* Password mínimo 6 caracteres.

---

## 6. Estructura sugerida

```
model/
 ├── Usuario.java (abstracta)
 ├── Administrador.java (subclase)
 └── Cliente.java (subclase)

security/
 └── Autenticable.java (interfaz)

service/
 ├── UsuarioInterface.java
 └── UsuarioService.java (implementación)

app/
 └── Main.java (menú de pruebas)
```

---

## 7. Ejemplo de código simplificado

```java
// security/Autenticable.java
public interface Autenticable {
    boolean login(String email, String password);
}

// model/Usuario.java
public abstract class Usuario implements Autenticable {
    private String nombre;
    private String email;
    private String password;
    private boolean activo = true;

    public Usuario(String nombre, String email, String password) {
        setNombre(nombre);
        setEmail(email);
        setPassword(password);
    }

    public void setEmail(String email) {
        if(email.contains("@")) this.email = email;
        else System.out.println("Email inválido");
    }

    public void setPassword(String password) {
        if(password.length() >= 6) this.password = password;
        else System.out.println("Contraseña demasiado corta");
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public abstract void mostrarPerfil();
}

// model/Administrador.java
public class Administrador extends Usuario {
    public Administrador(String nombre, String email, String password) {
        super(nombre, email, password);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("Admin: " + getNombre() + " - " + getEmail());
    }

    public void bloquearUsuario(Usuario u) {
        System.out.println("Usuario bloqueado: " + u.getNombre());
    }
}

// model/Cliente.java
public class Cliente extends Usuario {
    private String telefono;
    private String direccion;

    public Cliente(String nombre, String email, String password) {
        super(nombre, email, password);
    }

    public void setContacto(String telefono, String direccion) {
        if(!telefono.isEmpty() && !direccion.isEmpty()) {
            this.telefono = telefono;
            this.direccion = direccion;
        }
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("Cliente: " + getNombre() + " - " + getEmail());
        System.out.println("Tel: " + telefono + " | Dir: " + direccion);
    }
}
```

---

✅ Con este diseño el sistema aplica **Encapsulamiento, Herencia, Polimorfismo y Abstracción** de forma completa.
