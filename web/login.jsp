<%-- 
    Document   : login
    Created on : 22/10/2024, 9:59:42?a. m.
    Author     : Cesar
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Proyecto Final</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
        * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(to right, #a1c4fd, #c2e9fb); /* Fondo de gradiente */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.login-container {
    background-color: #ffffff; /* Fondo blanco para el formulario */
    padding: 40px;
    border-radius: 15px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); /* Sombra sutil */
    width: 100%;
    max-width: 350px; /* Ancho máximo para asegurar que no se expanda demasiado */
    text-align: center;
}

.login-container h2 {
    margin-bottom: 20px;
    color: #333333; /* Color del texto */
    font-weight: 500;
    font-size: 26px;
}

.login-container input[type="text"], 
.login-container input[type="password"] {
    width: 100%;
    padding: 14px;
    margin-bottom: 20px;
    border: 2px solid #d1d5db;
    border-radius: 12px;
    background-color: #f8f9fa;
    color: #333;
    font-size: 16px;
    transition: border-color 0.3s ease;
}

.login-container input[type="text"]:focus, 
.login-container input[type="password"]:focus {
    border-color: #a1c4fd;
    outline: none;
}

.login-container button {
    background-color: #a1c4fd;
    color: white;
    padding: 15px;
    width: 100%;
    border: none;
    border-radius: 12px;
    cursor: pointer;
    font-size: 18px;
    font-weight: 500;
    transition: background-color 0.3s ease, transform 0.3s ease;
}

.login-container button:hover {
    background-color: #89b4fc;
    transform: translateY(-3px);
}

.error-message {
    color: #f87171;
    margin-top: 15px;
    font-weight: bold;
    font-size: 14px;
}
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Iniciar Sesión</h2>
        
        <!-- Formulario de login -->
        <form action="LoginControlador" method="POST">
            <input type="text" name="usuario" placeholder="Usuario" required><br>
            <input type="password" name="contrasena" placeholder="Contraseña" required><br>
            <button type="submit">Iniciar Sesión</button>
        </form>
        
        
        <%
            if (request.getParameter("error") != null) {
        %>
            <div class="error-message">
                Usuario o contraseña incorrectos.
            </div>
        <%
            }
        %>
    </div>
</body>
</html>

