Transação e autenticação

O serviço de transação recebe e valida a transação, com a transação validada
ele salva a transação.

O serviço de autenticação checa se o usuario existe, se existe ele gera um token
para validar a transação 

Autenticacão:
Responsável por validar o usuario e senha,
Gerar token. 
Se o usuario existe, o serviço retorna Accepted, se não Unauthorized


Transação:
Valida o usuario no serviço de autenticação,
Valida transação,
Salva e persiste a transação.
Se a transação foi feita o serviço retorna Created, caso contrário retorna Unauthorized.

