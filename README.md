# Password Validator App (Java)

Esta es una aplicación de consola en Java que valida contraseñas utilizando expresiones regulares y ejecución concurrente con hilos.

## 🚀 Funcionalidad

El programa lanza múltiples hilos, cada uno encargado de validar una contraseña distinta con los siguientes criterios:

### ✅ Requisitos de la contraseña:

- Mínimo **8 caracteres** de longitud.
- Al menos **1 carácter especial** (`!@#$%^&*()`, etc.).
- Al menos **2 letras mayúsculas** (`A-Z`).
- Al menos **3 letras minúsculas** (`a-z`).
- Al menos **1 número** (`0-9`).

---

## 🧵 Concurrencia

Cada contraseña es validada de forma independiente por un **hilo (`Thread`)**, lo que permite la validación concurrente de múltiples entradas.

---

## 📂 Estructura del proyecto

```text
PasswordValidatorApp.java
README.md
