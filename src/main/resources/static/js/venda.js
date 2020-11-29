
function adicionarItem(venda) {
  var codigo = document.getElementById("codigo").value;
  var quant = document.getElementById("quant").value;
  if(quant == ""){
    quant = "1";
  }
  $.ajax({
      url : '/criaItem/' + codigo + '/' + quant ,
      type :'GET',
      cache: false,
      timeout: 600000,
      success : function(data) {  
        if(data == ""){
          alert("Erro : Produto não cadastrado");
          return;
        }

        var body = document.getElementById('tbody');

        for(var i=0; i < quant; i++){
          var row = body.insertRow(0);
          var cel1 = row.insertCell(0);
          var cel2 = row.insertCell(1);
          var cel3 = row.insertCell(2);
          var cel4 = row.insertCell(3);
    
          cel1.innerHTML = data.produto.codigoBarras;
          cel2.innerHTML = data.produto.nome;
          cel3.innerHTML = data.produto.preco;
          cel4.innerHTML = `<button id="excluir" type="reset" onclick="excluirItem(` + data.posicao + `)">Excluir</button>`
        }
      },
      error : function() {
        alert("Erro : Produto não cadastrado");
      }
  });
  document.getElementById("codigo").value = "";
  document.getElementById("quant").value = "";
}

function excluirItem(position){

  $.ajax({
    url : '/removerItem/' + position ,
    type :'GET',
    cache: false,
    timeout: 600000,
    success : function(data) {  
      if(data){
        document.getElementById("tbody").deleteRow(0);
      }
    }
  });
}







var produto1 = {codigo: 01, nome: 'Produto1', valor: 11.49};
var produto2 = {codigo: 02, nome: 'Produto2', valor: 22.90};
var produto3 = {codigo: 03, nome: 'Produto3', valor: 59.99};

var produtos = [produto1, produto2, produto3];

document.addEventListener("DOMContentLoaded", function(){
    produtos.forEach(adicionarProduto);
    
});

function atualizarTabela() {
    document.getElementById('tbody').innerHTML = "";
    produtos.forEach(adicionarProduto);
}

function adicionarProduto(){
  const codigo = document.getElementById("codigo").value;
  const quant = document.getElementById("quant").value;
  const nome = "teste";
  const valor = 10.0;

  

  if(codigo) {
    
  }
}