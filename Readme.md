# Track Testing

## Ejercicio 1: Definición planes de prueba

En el siguiente ejercicio práctico nos pondremos en la piel de un equipo agile de desarrollo enfrentándose a una nueva
funcionalidad definida por el Product Owner.

La nueva tarea hace referencia a la funcionalidad de ‘login’ de una aplicación. El Product Owner ha definido los
siguientes requisitos:

- El usuario es una dirección válida de correo.
- El password debe tener entre 6 y 18 caracteres.
- El password debe contener mayúsculas y minúsculas y un número.
- En caso de login exitoso, se debe cargar la página de inicio del perfil del usuario.
- En caso de usuario no registrado, debe mostrarse el siguiente mensaje de error: ‘Usuario no registrado’ y mostrar
  enlace de registro.
- En caso de usuario registrado y password incorrecto, debe mostrarse el siguiente mensaje de error: ‘Password
  incorrecto’.
- En caso de usuario registrado y password que no cumple requisitos, debe mostrarse el siguiente mensaje de error:
  ‘Password no cumple requisitos’.
- En caso de usuario que no cumple requisitos, debe mostrarse el siguiente mensaje de error: ‘Usuario no es correo
  válido’.

En base a las especificaciones anteriores, ponte en la piel de un QA del equipo y define un plan de pruebas utilizando
notación Gherkin, por ejemplo:

`Scenario:` Login successful

&emsp;`Given` I enter a correct user

&emsp;`And` I enter a correct password

&emsp;`When` I click on login button

&emsp;`Then` I am redirected to user profile page
<br></br>

### <center>Plan de pruebas

`Background:`

&emsp;`Given` web server running

&emsp;`And` database running with already registered users

&emsp;`And` login page loaded
<br></br>

`Scenario:` Login successful

&emsp;`Given` I enter an email which contains @ and ends with .com

&emsp;`And` I enter a password which length is between 6 and 8 characters and contains at least one capital letter, one
lowercase and one number

&emsp;`When` I click on login button

&emsp;`Then` I am redirected to my user profile page
<br></br>

`Scenario:` User not registered

&emsp;`Given` I enter a not registered email/user in the system

&emsp;`And` I enter a valid password

&emsp;`When` I click on login button

&emsp;`Then` error pop up appears with the message "User not registered"

&emsp;`And` I am redirected to link "register"
<br></br>

`Scenario:` Wrong password with valid user

&emsp;`Given` I enter user which is already registered in the system

&emsp;`And` I enter a wrong password

&emsp;`When` I click on login button

&emsp;`Then` error pop up appears with the message "Wrong password"

&emsp;`And` I am redirected to the login page
<br></br>

`Scenario:` Password not meet requirements

&emsp;`Given` I enter user which is already registered in the system

&emsp;`And` I enter a password which contains less than 6 characters or more than 18 characters, without one capital
letter and without one number

&emsp;`When` I click on login button

&emsp;`Then` error pop up appears with the message "The password does not meet the requirements"
<br></br>

`Scenario:` User not meet the requirements

&emsp;`Given` I enter an email which not contains @ or not ends with .com

&emsp;`And` I enter a valid password

&emsp;`When` I click on login button

&emsp;`Then` error pop up appears with the message "The user does not meet the requirements"
<br></br>

## Ejercicio 2: Selenium testing & BDD

En el siguiente ejercicio práctico nos vamos a poner en la piel de un QA enfrentándose a la automatización de tests con
Selenium y Behavior Driven Development.

Basándonos en los conocimientos adquiridos durante los cursos, hay que automatizar el siguiente caso de uso:

1. Ir a la página de búsqueda de Google.
2. Aceptar cookies.
3. Escribir Stratio en la barra de búsqueda .
4. Comprobar que el primer enlace se corresponde con https://stratio.com/.
5. Hacer click en dicho enlace.
6. Aceptar cookies.
7. Comprobar que estamos en el home de Stratio ("Stratio :: Transform and build your digital strategy around Big Data
   and AI").
8. Hacer click en el drop down de ‘Solutions’.
9. Entrar en Use Case Governance.
10. Esperar a que la página cargue y comprobar que estamos en la página correcta.
11. Imprimir por pantalla el título del primer ‘Use Case’ que aparece en la página.

Para realizar la automatización debemos tener en cuenta lo siguiente:

- Utilizar el patrón de diseño POM (Page Object Model).
- Definir la ‘feature’ y sus ‘scenarios’ usando Cucumber.
- Implementar los steps necesarios.
- Hacer la automatización para el navegador Firefox.
