# language: pt

@leilao
Funcionalidade: Cadastrando um leilao

Contexto:
Dado o user logado  

Cenário: Um usuário cadastrado pode cadastrar um leilao
	Quando acessa a pagina de novo leilao
	E preenche o formulario com dados validos
	Então volta para a pagina de leiloes
	E o novo leilao aparece na tabela
	

Cenário: Um usuário cadastrado pode editar um leilao
	Quando clicar para editar um leilao
	E edita o formulario
	Então volta para a pagina de leiloes
	E o leilao alterado aparece na tela