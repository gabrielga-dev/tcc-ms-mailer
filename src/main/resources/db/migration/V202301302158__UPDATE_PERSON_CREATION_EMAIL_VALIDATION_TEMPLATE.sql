UPDATE email_template
SET version = '1.0',
    content = '<!doctype html>
<html lang="en">
<head>
</head>

<body>
    <h3>Olá, <span th:text="${personFirstName}"></span> <span th:text="${personLastName}"></span>!</h3>
    <p>Bem vindo(a) à nossa plataforma de eventos, MyEvents!</p>
    <p>Para validar seu email, clique <a th:href="${validationLink}">aqui</a></p>
</body>
</html>
'
WHERE id = 2;