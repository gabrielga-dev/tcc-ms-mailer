INSERT INTO email_template
    (name, description, version, content)
values ('PERSON_CREATION_EMAIL_VALIDATION',
        'This email will be sent when a new person is created.',
        '0.1',
        '<html lang="en">
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="style.css" />

    <style type="text/css">
        * { font-family: Arial, sans-serif; }
    </style>
</head>

<body>
    <h3>Olá, {personFirstName} {personLastName}!</h3>
    <p>Bem vindo(a) à nossa plataforma de eventos, MyEvents!</p>
    <p>Para validar seu email, clique <a href="{validationLink}">aqui</a></p>
</body>
</html>
')