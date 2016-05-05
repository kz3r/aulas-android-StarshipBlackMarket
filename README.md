# aulas-android-StarshipBlackMarket
**Trabalho Introdutório de Desenvolvimento Android**

Simulação simples de venda de naves espaciais. Lista de naves disponíveis leva a uma view de detalhes onde é possível
"comprar" a nave selecionada. Também é possivel visualizar um histórico de compras e o valor total
gasto com as mesmas. É possível limpar o histórico para zerar a lista contabilizada.

**Conteúdos Trabalhados**
* Manipulação de Listas Personalizadas e List Adapters
* Layout Inflater
* Passagem de objetos entre activities
  * **Intents**
  * Criação de classe para objeto serializavel
  * Passagem e retorno de objeto e ArrayList< Objeto > serializado

###### A temática foi adaptada modificando "vendas de carros" por "vendas de naves do Star Wars" (Todas as características foram retiradas ou adaptadas da [Wookiepeedia](http://starwars.wikia.com/wiki/Main_Page)

## Descrição do trabalho original

O proprietário de uma empresa revendedora de automóveis gostaria de um
aplicativo Android que pudesse auxiliá-lo em vendas direta com clientes fora
da sua loja.

Você, como desenvolvedor, recebeu a missão de ajudar a este empresário e
deve desenvolver o sistema conforme especificação abaixo:

**Visão geral:** o sistema é um aplicativo de auxílio a venda de carros, no qual
o usuário poderá listar e verificar os detalhes dos carros disponíveis para a
venda. O aplicativo no entanto não usará banco de dados para
armazenamento persistente, ao invés disto, deve-se usar estruturas de
dados diversas para guardar os detalhes de cada carro. Como os dados
estão inseridos no código (hard-coded), não há persistência de dados.

* MasterView - Lista de Carros: Apresenta em forma de lista todos os carros
disponíveis para a venda. Cada célula da tabela deve conter uma foto do
carro, o modelo (title) e o preço (subtitle). Ao clicar na célula o usuário é
direcionado a DetailView. Coloque um mínimo de 10 carros no aplicativo.
Após a lista, insira ainda nesta tela um botão relatório que leva a tela de
relatório.
* DetailView - Detalhes do Carro: Esta tela apresenta maiores informações
sobre o carro escolhido. Além da foto, deve-se informar, modelo, fabricante,
cor e preço. Deve-se também apresentar um botão comprar que ao ser
clicado registra a compra. Não há necessidade de verificar estoque.
* Relatório - Esta é uma tela simples que mostra a listagem dos itens
vendidos (apresentar na célula apenas o modelo do carro). Ao final desta
tela, não como parte da lista, deve-se ainda apresentar o total de lucro bruto
acumulado, ou seja, a soma dos valores vendidos
