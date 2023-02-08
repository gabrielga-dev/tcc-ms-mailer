INSERT INTO email_template
    (name, description, version, content)
values ('EMAIL_CHANGE_EMAIL_VALIDATION',
        'This email will be sent when a someone wants to change the email.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h3>Olá, <span th:text="${personFirstName}"></span> <span th:text="${personLastName}"></span>!</h3>
    <p>A troca de email foi concluída!</p>
</body>
</html>

')