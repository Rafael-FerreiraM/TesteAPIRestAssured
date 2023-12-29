#language: pt

     Funcionalidade: Cadastrar cliente

        Cenário: Cadastrar um cliente com sucesso

          Dado que eu queria criar um cliente
          Quando eu fizer uma requisição para cadastrar um novo cliente
          Então a resposta da requisição deve ter status 201



     Funcionalidade: Atualizar Cliente

       Cenário: Atualizar dados do cliente

         Dado que eu queria atualizar dados de um cliente
         Quando eu fizer uma requisição para o endpoint do tipo PUT em /cliente/{id}
         Então a resposta da requisição deve ter status 200



    Funcionalidade: Deletar Cliente

      Cenário: Deletar  cliente da API

        Dado que eu queria deletar um cliente da
        Quando eu fizer uma requisição para o endpoint do tipo DELETE em /cliente/{id}
        Então a resposta da requisição deve ter status 200


    Funcionalidade: Ver Clientes

      Cenário: Ver os dados dos cliente cadastrado

        Dado que eu queria ver todos os clientes cadastrados
        Quando eu fizer uma requisição para o endpoint do tipo GET em /clientes
        Então a resposta da requisição não deve ser vazia